package com.bclaud.breakingbad.inboundRest.mapper;

import com.bclaud.breakingbad.core.models.FavPersona;
import com.bclaud.breakingbad.core.models.Persona;
import com.bclaud.breakingbad.core.service.dto.FavPersonaPatch;
import com.bclaud.breakingbad.inboundRest.inboundDto.FavPersonaInputDto;
import com.bclaud.breakingbad.inboundRest.inboundDto.FavPersonaOutPutDto;
import com.bclaud.breakingbad.inboundRest.inboundDto.PersonaOutPutDto;
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
public class OutPutMapperImpl implements OutPutMapper {

    @Override
    public Persona personaOutPutDtoToPersona(PersonaOutPutDto dto) {
        if ( dto == null ) {
            return null;
        }

        Persona persona = new Persona();

        persona.setId( dto.getId() );
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

    @Override
    public PersonaOutPutDto personaToPersonaOutPutDto(Persona model) {
        if ( model == null ) {
            return null;
        }

        PersonaOutPutDto personaOutPutDto = new PersonaOutPutDto();

        personaOutPutDto.setId( model.getId() );
        personaOutPutDto.setName( model.getName() );
        personaOutPutDto.setBirthday( model.getBirthday() );
        List<String> list = model.getOccupation();
        if ( list != null ) {
            personaOutPutDto.setOccupation( new ArrayList<String>( list ) );
        }
        personaOutPutDto.setImg( model.getImg() );
        personaOutPutDto.setStatus( model.getStatus() );
        personaOutPutDto.setNickname( model.getNickname() );
        List<Integer> list1 = model.getAppearance();
        if ( list1 != null ) {
            personaOutPutDto.setAppearance( new ArrayList<Integer>( list1 ) );
        }
        personaOutPutDto.setPortrayed( model.getPortrayed() );
        personaOutPutDto.setCategory( model.getCategory() );

        return personaOutPutDto;
    }

    @Override
    public FavPersona favPersonaOutPutDtoToFavPersona(FavPersonaOutPutDto dto) {
        if ( dto == null ) {
            return null;
        }

        FavPersona favPersona = new FavPersona();

        favPersona.setId( dto.getId() );
        favPersona.setName( dto.getName() );
        List<String> list = dto.getOccupation();
        if ( list != null ) {
            favPersona.setOccupation( new ArrayList<String>( list ) );
        }
        favPersona.setFavorite( dto.getFavorite() );

        return favPersona;
    }

    @Override
    public FavPersonaOutPutDto favPersonaToFavPersonaOutPutDto(FavPersona model) {
        if ( model == null ) {
            return null;
        }

        FavPersonaOutPutDto favPersonaOutPutDto = new FavPersonaOutPutDto();

        favPersonaOutPutDto.setId( model.getId() );
        favPersonaOutPutDto.setName( model.getName() );
        List<String> list = model.getOccupation();
        if ( list != null ) {
            favPersonaOutPutDto.setOccupation( new ArrayList<String>( list ) );
        }
        favPersonaOutPutDto.setFavorite( model.getFavorite() );

        return favPersonaOutPutDto;
    }

    @Override
    public FavPersona favPersonaInPutDtoToFavPersona(FavPersonaInputDto dto) {
        if ( dto == null ) {
            return null;
        }

        FavPersona favPersona = new FavPersona();

        favPersona.setId( dto.getId() );
        favPersona.setFavorite( dto.getFavorite() );

        return favPersona;
    }

    @Override
    public FavPersonaInputDto favPersonaToFavPersonaInPutDto(FavPersona model) {
        if ( model == null ) {
            return null;
        }

        FavPersonaInputDto favPersonaInputDto = new FavPersonaInputDto();

        favPersonaInputDto.setId( model.getId() );
        favPersonaInputDto.setFavorite( model.getFavorite() );

        return favPersonaInputDto;
    }

    @Override
    public FavPersonaPatch favPersonaInputDtoToFavPersonaPatch(FavPersonaInputDto dto) {
        if ( dto == null ) {
            return null;
        }

        FavPersonaPatch favPersonaPatch = new FavPersonaPatch();

        favPersonaPatch.setId( dto.getId() );
        favPersonaPatch.setFavorite( dto.getFavorite() );

        return favPersonaPatch;
    }
}
