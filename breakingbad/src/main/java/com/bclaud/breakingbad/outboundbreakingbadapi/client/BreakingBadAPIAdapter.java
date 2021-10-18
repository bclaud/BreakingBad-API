package com.bclaud.breakingbad.outboundbreakingbadapi.client;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bclaud.breakingbad.core.models.Persona;
import com.bclaud.breakingbad.core.port.out.PersonaOutBoundClient;
import com.bclaud.breakingbad.outboundbreakingbadapi.client.ClientMapper.ClientMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BreakingBadAPIAdapter implements PersonaOutBoundClient {

    @Autowired
    PersonaClient client;
    
    @Autowired
    ClientMapper clientMapper;
    
    @Override
    public List<Persona> findAll() {
        return client.findAll().stream()
        .map(dto -> clientMapper.personaDtoToPersona(dto))
        .collect(Collectors.toList());
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return client.findById(id).stream()
        .map(dto -> clientMapper.personaDtoToPersona(dto))
        .findFirst();
    }
}
