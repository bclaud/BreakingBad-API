package com.bclaud.breakingbad.inboundRest.mapper;

import com.bclaud.breakingbad.core.models.FavPersona;
import com.bclaud.breakingbad.core.models.Persona;
import com.bclaud.breakingbad.core.service.dto.FavPersonaPatch;
import com.bclaud.breakingbad.inboundRest.inboundDto.FavPersonaInputDto;
import com.bclaud.breakingbad.inboundRest.inboundDto.FavPersonaOutPutDto;
import com.bclaud.breakingbad.inboundRest.inboundDto.PersonaOutPutDto;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OutPutMapper {
    
    Persona personaOutPutDtoToPersona(PersonaOutPutDto dto);

    PersonaOutPutDto personaToPersonaOutPutDto(Persona model);

    FavPersona favPersonaOutPutDtoToFavPersona(FavPersonaOutPutDto dto);

    FavPersonaOutPutDto favPersonaToFavPersonaOutPutDto(FavPersona model);

    FavPersona favPersonaInPutDtoToFavPersona(FavPersonaInputDto dto);
    
    FavPersonaInputDto favPersonaToFavPersonaInPutDto(FavPersona model);

    FavPersonaPatch favPersonaInputDtoToFavPersonaPatch(FavPersonaInputDto dto);

}
