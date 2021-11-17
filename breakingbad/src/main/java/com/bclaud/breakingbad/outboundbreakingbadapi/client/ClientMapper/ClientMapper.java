package com.bclaud.breakingbad.outboundbreakingbadapi.client.ClientMapper;

import com.bclaud.breakingbad.core.models.Persona;
import com.bclaud.breakingbad.outboundbreakingbadapi.client.dtos.PersonaDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    
    @Mapping(source = "id", target = "char_id")
    PersonaDto personaToPersonaDto(Persona model);
    
    @Mapping(source = "char_id", target = "id")
    Persona personaDtoToPersona(PersonaDto dto);
    
}
