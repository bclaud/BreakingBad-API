package com.bclaud.breakingbad.outBoundDatabaseH2.dataBaseMapper;

import com.bclaud.breakingbad.core.models.FavPersona;
import com.bclaud.breakingbad.core.service.dto.FavPersonaPatch;
import com.bclaud.breakingbad.outBoundDatabaseH2.entities.FavPersonaEntity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataBaseMapper {
    
    FavPersonaEntity favPersonaToFavPersonaEntity(FavPersona model);
    
    FavPersonaEntity favPersonaPatchToFavPersonaEntity(FavPersonaPatch patch);

    FavPersona favPersonaEntityToFavPersona(FavPersonaEntity entity);

}
