package com.bclaud.breakingbad.core.port.out;

import java.util.List;
import java.util.Optional;

import com.bclaud.breakingbad.core.models.Persona;

public interface PersonaOutBoundClient {
    List<Persona> findAll();

    Optional<Persona> findById(Long id);
}
