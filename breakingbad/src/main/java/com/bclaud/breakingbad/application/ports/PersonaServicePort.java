package com.bclaud.breakingbad.application.ports;

import java.util.List;

import com.bclaud.breakingbad.application.domain.FavPersona;
import com.bclaud.breakingbad.application.domain.Persona;

public interface PersonaServicePort {
    
    List<Persona> findAll();

    List<Persona> findById(Long char_id);

    FavPersona saveFavorite(Long char_id);
    
    List<FavPersona> findAllFav();

    FavPersona findFavById(Long id);
}
