package com.bclaud.breakingbad.inboundRest.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.bclaud.breakingbad.core.port.in.PersonaUseCase;
import com.bclaud.breakingbad.inboundRest.inboundDto.FavPersonaOutPutDto;
import com.bclaud.breakingbad.inboundRest.inboundDto.PersonaOutPutDto;
import com.bclaud.breakingbad.inboundRest.mapper.OutPutMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/characters")
public class PersonaController {

    @Autowired
    PersonaUseCase personaService;

    @Autowired
    OutPutMapper outPutMapper;
    
    @GetMapping
    public List<PersonaOutPutDto> findAll() {
        return personaService.findAll().stream()
        .map(model -> outPutMapper.personaToPersonaOutPutDto(model))
        .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonaOutPutDto> findById(@PathVariable Long id){
        PersonaOutPutDto dto = personaService.findById(id).stream()
        .map(model -> outPutMapper.personaToPersonaOutPutDto(model))
        .findFirst()
        .orElseThrow(RuntimeException::new);
        // TODO fazer retornar 404 com excessao customizada

        return ResponseEntity.ok(dto);
    }

    @PostMapping(value = "/fav/{id}")
    public FavPersonaOutPutDto favoritePersona(@PathVariable Long id){
        return outPutMapper.favPersonaToFavPersonaOutPutDto(personaService.saveFavorite(id));
    }

    @GetMapping(value = "/fav")
    public List<FavPersonaOutPutDto> listAllFav(){
        return personaService.findAllFav().stream()
        .map(model -> outPutMapper.favPersonaToFavPersonaOutPutDto(model))
        .collect(Collectors.toList());
    }

    @GetMapping(value = "/fav/{id}")
    public ResponseEntity<FavPersonaOutPutDto> findFavById(@PathVariable Long id){
        FavPersonaOutPutDto dto = personaService.findFavById(id).stream()
        .map(model -> outPutMapper.favPersonaToFavPersonaOutPutDto(model))
        .findFirst()
        .orElseThrow(RuntimeException::new);
        // TODO fazer retornar 404 com excessao customizada

        return ResponseEntity.ok(dto);
    }

    @PatchMapping(value = "/fav")
    public ResponseEntity<FavPersonaOutPutDto> changeFavorite(@RequestBody FavPersonaOutPutDto dto){
        personaService.changeFavorite(outPutMapper.favPersonaOutPutDtoToFavPersona(dto));

        return ResponseEntity.ok(dto);
    }
    
}

//TODO corrigir os verbos HTTP com responseEntity e excessoes corretas
