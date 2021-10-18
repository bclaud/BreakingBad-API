package com.bclaud.breakingbad.outBoundDatabaseH2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.bclaud.breakingbad.core.models.FavPersona;
import com.bclaud.breakingbad.outBoundDatabaseH2.dataBaseMapper.DataBaseMapper;
import com.bclaud.breakingbad.outBoundDatabaseH2.entities.FavPersonaEntity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DatabaseAdapterTest {

    @InjectMocks
    DatabaseAdapter adapter;

    @Mock
    SpringDataFavPersonaRepository repository;

    @Mock
    DataBaseMapper databaseMapper;

    FavPersona favPersona = new FavPersona();
    FavPersonaEntity favPersonaEntity = new FavPersonaEntity();

    @BeforeEach
    public void init() {
        List<String> occupation = Arrays.asList("professor", "test");

        favPersona.setId(1L);
        favPersona.setName("test");
        favPersona.setOccupation(occupation);
        favPersona.setFavorite(true);

        favPersonaEntity.setId(1L);
        favPersonaEntity.setName("test");
        favPersonaEntity.setOccupation(occupation);
        favPersonaEntity.setFavorite(true);
    }

    @Test
    void testFindAll() {
        when(repository.findAll()).thenReturn(List.of(favPersonaEntity));
        when(databaseMapper.favPersonaEntityToFavPersona(favPersonaEntity)).thenReturn(favPersona);

        assertEquals(favPersona, adapter.findAll().get(0));
    }

    @Test
    void testFindById() {
        when(repository.findById(1L)).thenReturn(Optional.of(favPersonaEntity));
        when(databaseMapper.favPersonaEntityToFavPersona(favPersonaEntity)).thenReturn(favPersona);

        assertEquals(favPersona, adapter.findById(1L).get());
    }

    @Test
    void testSave() {
        assertEquals(favPersona, adapter.save(favPersona));
    }
}
