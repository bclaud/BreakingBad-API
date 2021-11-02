package com.bclaud.breakingbad.outBoundDatabaseH2;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bclaud.breakingbad.core.models.FavPersona;
import com.bclaud.breakingbad.core.port.out.FavPersonaOutboundDatabase;
import com.bclaud.breakingbad.core.service.dto.FavPersonaPatch;
import com.bclaud.breakingbad.outBoundDatabaseH2.dataBaseMapper.DataBaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseAdapter implements FavPersonaOutboundDatabase {
    @Autowired
    SpringDataFavPersonaRepository repository;

    @Autowired
    DataBaseMapper databaseMapper;
    
    @Override
    public FavPersona save(FavPersona favPersona) {
        repository.save(databaseMapper.favPersonaToFavPersonaEntity(favPersona));
        return favPersona;
    }

    @Override
    public List<FavPersona> findAll() {
        return repository.findAll().stream()
        .map(entity -> databaseMapper.favPersonaEntityToFavPersona(entity))
        .collect(Collectors.toList());
    }

    @Override
    public Optional<FavPersona> findById(Long id) {
        return repository.findById(id).stream()
        .map(entity -> databaseMapper.favPersonaEntityToFavPersona(entity))
        .findFirst();
    }

    @Override
    public void updateFavPersonaFavorite(FavPersonaPatch patch) {
        repository.updateFavPersonaFavorite(patch.getId(), patch.getFavorite());
    }
}
