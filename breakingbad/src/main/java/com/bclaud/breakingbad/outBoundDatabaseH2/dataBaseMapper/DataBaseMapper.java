package com.bclaud.breakingbad.outBoundDatabaseH2.dataBaseMapper;

import com.bclaud.breakingbad.core.models.FavPersona;
import com.bclaud.breakingbad.outBoundDatabaseH2.entities.FavPersonaEntity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataBaseMapper {
    
    FavPersonaEntity favPersonaToFavPersonaEntity(FavPersona model);

    FavPersona favPersonaEntityToFavPersona(FavPersonaEntity entity);

}
