package com.bclaud.breakingbad.application.ports;

import java.util.List;

import com.bclaud.breakingbad.application.domain.FavPersona;

public interface FavPersonaRepositoryPort {
    
    FavPersona save(FavPersona favPersona);

    List<FavPersona> findAll();

    FavPersona findById(Long id);
}
