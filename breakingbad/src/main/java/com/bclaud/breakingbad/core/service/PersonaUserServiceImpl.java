package com.bclaud.breakingbad.core.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bclaud.breakingbad.core.models.FavPersona;
import com.bclaud.breakingbad.core.models.Persona;
import com.bclaud.breakingbad.core.port.in.PersonaUseCase;
import com.bclaud.breakingbad.core.port.out.FavPersonaOutboundDatabase;
import com.bclaud.breakingbad.core.port.out.PersonaOutBoundClient;

public class PersonaUserServiceImpl implements PersonaUseCase {

    private final FavPersonaOutboundDatabase favoritesRepository;
    private final PersonaOutBoundClient personaClient;

    public PersonaUserServiceImpl(final FavPersonaOutboundDatabase repository,
    PersonaOutBoundClient client){
        this.favoritesRepository = repository;
        this.personaClient = client;
    }

    @Override
    public List<Persona> findAll() {
        return personaClient.findAll();
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return personaClient.findById(id);
    }

    @Override
    public FavPersona saveFavorite(Long id) {
        //TODO Teria como utilizar esse optional de forma mais declarativa?
        FavPersona favPersona = new FavPersona(findById(id).get());
        favPersona.setFavorite(true);
        favoritesRepository.save(favPersona);
        return favPersona;
    }

    @Override
    public List<FavPersona> findAllFav() {
        return favoritesRepository.findAll().stream()
        .filter(persona -> persona.getFavorite().equals(true))
        .collect(Collectors.toList());
    }

    @Override
    public Optional<FavPersona> findFavById(Long id) {
        return favoritesRepository.findById(id).stream()
        .filter(persona -> persona.getFavorite().equals(true))
        .findFirst();
    }

    @Override
    public FavPersona changeFavorite(FavPersona favPersona) {
        //TODO Melhorar este codigo
        FavPersona personaToPatch = favoritesRepository.findById(favPersona.getId()).get();
        personaToPatch.setFavorite(false);
        favoritesRepository.save(personaToPatch);
        return personaToPatch;
    }
    
}
