package com.bclaud.breakingbad.outBoundDatabaseH2.dataBaseMapper;

import com.bclaud.breakingbad.core.models.FavPersona;
import com.bclaud.breakingbad.core.service.dto.FavPersonaPatch;
import com.bclaud.breakingbad.outBoundDatabaseH2.entities.FavPersonaEntity;
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
public class DataBaseMapperImpl implements DataBaseMapper {

    @Override
    public FavPersonaEntity favPersonaToFavPersonaEntity(FavPersona model) {
        if ( model == null ) {
            return null;
        }

        FavPersonaEntity favPersonaEntity = new FavPersonaEntity();

        favPersonaEntity.setId( model.getId() );
        favPersonaEntity.setName( model.getName() );
        List<String> list = model.getOccupation();
        if ( list != null ) {
            favPersonaEntity.setOccupation( new ArrayList<String>( list ) );
        }
        favPersonaEntity.setFavorite( model.getFavorite() );

        return favPersonaEntity;
    }

    @Override
    public FavPersonaEntity favPersonaPatchToFavPersonaEntity(FavPersonaPatch patch) {
        if ( patch == null ) {
            return null;
        }

        FavPersonaEntity favPersonaEntity = new FavPersonaEntity();

        favPersonaEntity.setId( patch.getId() );
        favPersonaEntity.setFavorite( patch.getFavorite() );

        return favPersonaEntity;
    }

    @Override
    public FavPersona favPersonaEntityToFavPersona(FavPersonaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        FavPersona favPersona = new FavPersona();

        favPersona.setId( entity.getId() );
        favPersona.setName( entity.getName() );
        List<String> list = entity.getOccupation();
        if ( list != null ) {
            favPersona.setOccupation( new ArrayList<String>( list ) );
        }
        favPersona.setFavorite( entity.getFavorite() );

        return favPersona;
    }
}
