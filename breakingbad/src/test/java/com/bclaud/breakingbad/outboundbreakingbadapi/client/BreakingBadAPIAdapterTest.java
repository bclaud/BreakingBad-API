package com.bclaud.breakingbad.outboundbreakingbadapi.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.bclaud.breakingbad.core.models.Persona;
import com.bclaud.breakingbad.outboundbreakingbadapi.client.ClientMapper.ClientMapper;
import com.bclaud.breakingbad.outboundbreakingbadapi.client.dtos.PersonaDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BreakingBadAPIAdapterTest {

    @InjectMocks
    BreakingBadAPIAdapter adapter;

    @Mock
    PersonaClient client;
    
    @Mock
    ClientMapper clientMapper;

    Persona persona = new Persona();
    PersonaDto dto = new PersonaDto();

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

        dto.setChar_id(1L);
        dto.setName("test");
        dto.setBirthday("1990-01-01");
        dto.setOccupation(occupation);
        dto.setImg("imagepath");
        dto.setStatus("teste status");
        dto.setNickname("test nickname");
        dto.setAppearance(Arrays.asList(1, 2, 3));
        dto.setPortrayed("portrayed");
        dto.setCategory("Breaking bad");
    }
    

    @Test
    void testFindAll() {
        when(client.findAll()).thenReturn(List.of(dto));
        when(clientMapper.personaDtoToPersona(dto)).thenReturn(persona);

        assertEquals(persona, adapter.findAll().get(0));
    }

    @Test
    void testFindById() {
        when(client.findById(1L)).thenReturn(List.of(dto));
        when(clientMapper.personaDtoToPersona(dto)).thenReturn(persona);

        assertEquals(persona, adapter.findById(1L).get());
    }
}
