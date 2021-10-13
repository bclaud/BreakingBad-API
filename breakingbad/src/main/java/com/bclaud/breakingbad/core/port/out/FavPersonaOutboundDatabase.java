package com.bclaud.breakingbad.core.port.out;

import java.util.List;
import java.util.Optional;

import com.bclaud.breakingbad.core.models.FavPersona;

public interface FavPersonaOutboundDatabase {
    FavPersona save(FavPersona favPersona);

    List<FavPersona> findAll();

    Optional<FavPersona> findById(Long id);
}
