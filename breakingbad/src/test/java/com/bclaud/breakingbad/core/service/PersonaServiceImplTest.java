package com.bclaud.breakingbad.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.bclaud.breakingbad.core.models.FavPersona;
import com.bclaud.breakingbad.core.models.Persona;
import com.bclaud.breakingbad.core.port.out.FavPersonaOutboundDatabase;
import com.bclaud.breakingbad.core.port.out.PersonaOutBoundClient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonaServiceImplTest {

    @InjectMocks
    PersonaUserServiceImpl service;

    @Mock
    FavPersonaOutboundDatabase repository;

    @Mock
    PersonaOutBoundClient client;

    FavPersona favPersona = new FavPersona();
    Persona persona = new Persona();

    @BeforeEach
    public void init() {
        List<String> occupation = Arrays.asList("professor", "test");

        persona.setId(1L);
        persona.setName("test");
        persona.setBirthday("1990-01-01");
        persona.setOccupation(occupation);
        persona.setImg("imagepath");
        persona.setStatus("teste status");
        persona.setNickname("test nickname");
        persona.setAppearance(Arrays.asList(1, 2, 3));
        persona.setPortrayed("portrayed");
        persona.setCategory("Breaking bad");

        favPersona.setId(1L);
        favPersona.setName("test");
        favPersona.setOccupation(occupation);
        favPersona.setFavorite(true);
    }

    // @Test
    // void changeFavorite_ReturnFalseNewFavPersona() {
    //     FavPersona newFavPersona = new FavPersona(persona);
    //     newFavPersona.setFavorite(false);

    //     when(repository.findById(1L)).thenReturn(Optional.of(favPersona));

    //     assertEquals(false, service.changeFavorite(newFavPersona).getFavorite());
    // }

    @Test
    void findAll_ReturnListOfPersona() {
        when(client.findAll()).thenReturn(List.of(persona));

        assertEquals(1, service.findAll().size());
    }

    @Test
    void findAllFav_ReturnListOfFavPersona() {
        when(repository.findAll()).thenReturn(List.of(favPersona));

        assertEquals(1, service.findAllFav().size());
    }

    @Test
    void findById_ReturnPersonaById() {
        when(client.findById(1L)).thenReturn(Optional.of(persona));
        
        assertEquals(client.findById(1L).get(), service.findById(1L));
    }
    
    @Test
    void findFavById_ReturnFavPersonaById() {
        when(repository.findById(1L)).thenReturn(Optional.of(favPersona));

        assertEquals(repository.findById(1L).get(), service.findFavById(1L));
    }

    @Test
    void saveFavorite_ReturnFavPersona() {
        when(client.findById(1L)).thenReturn(Optional.of(persona));
        
        assertEquals(favPersona.getName(), service.saveFavorite(1L).getName());
    }
}
