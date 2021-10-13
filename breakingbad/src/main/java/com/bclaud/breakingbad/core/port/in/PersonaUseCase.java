package com.bclaud.breakingbad.core.port.in;

import java.util.List;
import java.util.Optional;

import com.bclaud.breakingbad.core.models.FavPersona;
import com.bclaud.breakingbad.core.models.Persona;

public interface PersonaUseCase {
    
    List<Persona> findAll();

    Optional<Persona> findById(Long id);

    FavPersona saveFavorite(Long id);

    List<FavPersona> findAllFav();

    Optional<FavPersona> findFavById(Long id);

    FavPersona changeFavorite(FavPersona favPersona);
}
