package com.bclaud.breakingbad.outboundbreakingbadapi.client;

import java.util.List;

import com.bclaud.breakingbad.outboundbreakingbadapi.client.dtos.PersonaDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "Characters", url = "https://breakingbadapi.com/api/")
public interface PersonaClient {
    
    @GetMapping("characters")
    List<PersonaDto> findAll();

    @GetMapping("characters/{id}")
    List<PersonaDto> findById(@PathVariable Long id);
}
