package com.bclaud.breakingbad.outboundbreakingbadapi.client.ClientMapper;

import com.bclaud.breakingbad.core.models.Persona;
import com.bclaud.breakingbad.outboundbreakingbadapi.client.dtos.PersonaDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-05T19:42:39+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public PersonaDto personaToPersonaDto(Persona model) {
        if ( model == null ) {
            return null;
        }

        PersonaDto personaDto = new PersonaDto();

        personaDto.setChar_id( model.getId() );
        personaDto.setName( model.getName() );
        personaDto.setBirthday( model.getBirthday() );
        List<String> list = model.getOccupation();
        if ( list != null ) {
            personaDto.setOccupation( new ArrayList<String>( list ) );
        }
        personaDto.setImg( model.getImg() );
        personaDto.setStatus( model.getStatus() );
        personaDto.setNickname( model.getNickname() );
        List<Integer> list1 = model.getAppearance();
        if ( list1 != null ) {
            personaDto.setAppearance( new ArrayList<Integer>( list1 ) );
        }
        personaDto.setPortrayed( model.getPortrayed() );
        personaDto.setCategory( model.getCategory() );

        return personaDto;
    }

    @Override
    public Persona personaDtoToPersona(PersonaDto dto) {
        if ( dto == null ) {
            return null;
        }

        Persona persona = new Persona();

        persona.setId( dto.getChar_id() );
        persona.setName( dto.getName() );
        persona.setBirthday( dto.getBirthday() );
        List<String> list = dto.getOccupation();
        if ( list != null ) {
            persona.setOccupation( new ArrayList<String>( list ) );
        }
        persona.setImg( dto.getImg() );
        persona.setStatus( dto.getStatus() );
        persona.setNickname( dto.getNickname() );
        List<Integer> list1 = dto.getAppearance();
        if ( list1 != null ) {
            persona.setAppearance( new ArrayList<Integer>( list1 ) );
        }
        persona.setPortrayed( dto.getPortrayed() );
        persona.setCategory( dto.getCategory() );

        return persona;
    }
}
