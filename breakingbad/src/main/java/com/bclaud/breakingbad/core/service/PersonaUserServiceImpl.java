package com.bclaud.breakingbad.core.service;

import java.util.List;
import java.util.stream.Collectors;

import com.bclaud.breakingbad.core.exceptions.PersonaExceptions;
import com.bclaud.breakingbad.core.exceptions.ResourceNotFoundException;
import com.bclaud.breakingbad.core.models.FavPersona;
import com.bclaud.breakingbad.core.models.Persona;
import com.bclaud.breakingbad.core.port.in.PersonaUseCase;
import com.bclaud.breakingbad.core.port.out.FavPersonaOutboundDatabase;
import com.bclaud.breakingbad.core.port.out.PersonaOutBoundClient;

public class PersonaUserServiceImpl implements PersonaUseCase {

    private final FavPersonaOutboundDatabase favoritesRepository;
    private final PersonaOutBoundClient personaClient;

    public PersonaUserServiceImpl(final FavPersonaOutboundDatabase repository, PersonaOutBoundClient client) {
        this.favoritesRepository = repository;
        this.personaClient = client;
    }

    @Override
    public List<Persona> findAll() {
        return personaClient.findAll();
    }

    @Override
    public Persona findById(Long id) throws PersonaExceptions {
        return personaClient.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public FavPersona saveFavorite(Long id) throws PersonaExceptions {
        FavPersona favPersona = new FavPersona(findById(id));

        favPersona.setFavorite(true);
        favoritesRepository.save(favPersona);
        return favPersona;
    }

    @Override
    public List<FavPersona> findAllFav() {
        return favoritesRepository.findAll().stream().filter(persona -> persona.getFavorite().equals(true))
                .collect(Collectors.toList());
    }

    @Override
    public FavPersona findFavById(Long id) throws PersonaExceptions {
        return favoritesRepository.findById(id).stream().findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public FavPersona changeFavorite(FavPersona favPersona) throws PersonaExceptions {
        // TODO Melhorar este codigo
        FavPersona personaToPatch = favoritesRepository.findById(favPersona.getId())
                .orElseThrow(() -> new ResourceNotFoundException(favPersona.getId()));

        personaToPatch.setFavorite(favPersona.getFavorite());
        favoritesRepository.save(personaToPatch);
        return personaToPatch;
    }
}
