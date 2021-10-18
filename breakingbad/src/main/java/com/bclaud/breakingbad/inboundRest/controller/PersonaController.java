package com.bclaud.breakingbad.inboundRest.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.bclaud.breakingbad.core.port.in.PersonaUseCase;
import com.bclaud.breakingbad.inboundRest.inboundDto.FavPersonaInputDto;
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
@RequestMapping("/api/v1")
public class PersonaController {

    @Autowired
    PersonaUseCase personaService;

    @Autowired
    OutPutMapper outPutMapper;

    @GetMapping("/characters")
    public ResponseEntity<List<PersonaOutPutDto>> findAll() {
        return ResponseEntity.ok(personaService.findAll().stream()
                .map(model -> outPutMapper.personaToPersonaOutPutDto(model)).collect(Collectors.toList()));
    }

    @GetMapping(value = "/characters/{id}")
    public ResponseEntity<PersonaOutPutDto> findById(@PathVariable Long id) {
        PersonaOutPutDto dto = outPutMapper.personaToPersonaOutPutDto(personaService.findById(id));

        return ResponseEntity.ok(dto);
    }

    @PostMapping(value = "/favorites/{id}")
    public ResponseEntity<FavPersonaOutPutDto> favoritePersona(@PathVariable Long id) {
        return ResponseEntity.ok(outPutMapper.favPersonaToFavPersonaOutPutDto(personaService.saveFavorite(id)));
    }

    @PatchMapping(value = "/favorites")
    public ResponseEntity<FavPersonaOutPutDto> changeFavorite(@RequestBody FavPersonaInputDto inPutDto) {
        FavPersonaOutPutDto outPutDto = outPutMapper.favPersonaToFavPersonaOutPutDto(
                personaService.changeFavorite(outPutMapper.favPersonaInPutDtoToFavPersona(inPutDto)));

        return ResponseEntity.ok(outPutDto);
    }

    @GetMapping(value = "/favorites")
    public ResponseEntity<List<FavPersonaOutPutDto>> listAllFav() {
        return ResponseEntity.ok(personaService.findAllFav().stream()
                .map(model -> outPutMapper.favPersonaToFavPersonaOutPutDto(model)).collect(Collectors.toList()));
    }

    @GetMapping(value = "/favorites/{id}")
    public ResponseEntity<FavPersonaOutPutDto> findFavById(@PathVariable Long id) {
        FavPersonaOutPutDto dto = outPutMapper.favPersonaToFavPersonaOutPutDto(personaService.findFavById(id));

        return ResponseEntity.ok(dto);
    }

}
