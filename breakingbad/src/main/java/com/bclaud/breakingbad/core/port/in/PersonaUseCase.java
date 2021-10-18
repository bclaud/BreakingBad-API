package com.bclaud.breakingbad.core.port.in;

import java.util.List;

import com.bclaud.breakingbad.core.models.FavPersona;
import com.bclaud.breakingbad.core.models.Persona;

public interface PersonaUseCase {
    
    List<Persona> findAll();

    Persona findById(Long id);

    FavPersona saveFavorite(Long id);

    List<FavPersona> findAllFav();

    FavPersona findFavById(Long id);

    FavPersona changeFavorite(FavPersona favPersona);
}
