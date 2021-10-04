package com.bclaud.breakingbad.application.services;

import java.util.List;

import com.bclaud.breakingbad.application.domain.FavPersona;
import com.bclaud.breakingbad.application.domain.Persona;
import com.bclaud.breakingbad.application.ports.FavPersonaRepositoryPort;
import com.bclaud.breakingbad.application.ports.PersonaClientPort;
import com.bclaud.breakingbad.application.ports.PersonaServicePort;

public class PersonaServiceImpl implements PersonaServicePort {

    private PersonaClientPort personaClientPort;
    private FavPersonaRepositoryPort favPersonaRepositoryPort;

    public PersonaServiceImpl(PersonaClientPort personaClientPort,
        FavPersonaRepositoryPort favPersonaRepositoryPort){
            this.personaClientPort = personaClientPort;
            this.favPersonaRepositoryPort = favPersonaRepositoryPort;
    }

    @Override
    public List<Persona> findAll() {
       
        return personaClientPort.findAll();
    }

    @Override
    public List<Persona> findById(Long char_id) {
        return personaClientPort.findById(char_id);
    }

    @Override
    public FavPersona saveFavorite(Long char_id) {
        Persona persona = findById(char_id).get(0);

        FavPersona newFavorite = new FavPersona(persona);
        newFavorite.setFavorite(true);

        return favPersonaRepositoryPort.save(newFavorite);
    }

    @Override
    public List<FavPersona> findAllFav() {
        return favPersonaRepositoryPort.findAll();
    }

    @Override
    public FavPersona findFavById(Long id) {
        return favPersonaRepositoryPort.findById(id);
    }
    
}
