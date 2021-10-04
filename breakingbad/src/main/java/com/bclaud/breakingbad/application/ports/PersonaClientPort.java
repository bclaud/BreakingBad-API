package com.bclaud.breakingbad.application.ports;

import java.util.List;

import com.bclaud.breakingbad.application.domain.Persona;

public interface PersonaClientPort {
    
    List<Persona> findAll();

    List<Persona> findById(Long char_id);
}
