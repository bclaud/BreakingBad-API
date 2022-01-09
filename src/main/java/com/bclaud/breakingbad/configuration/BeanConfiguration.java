package com.bclaud.breakingbad.configuration;

import com.bclaud.breakingbad.BreakingbadApplication;
import com.bclaud.breakingbad.core.port.out.FavPersonaOutboundDatabase;
import com.bclaud.breakingbad.core.port.out.PersonaOutBoundClient;
import com.bclaud.breakingbad.core.service.PersonaUserServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = BreakingbadApplication.class)
public class BeanConfiguration {
    
    @Bean
    PersonaUserServiceImpl personaUserServiceImpl(FavPersonaOutboundDatabase repository,
    PersonaOutBoundClient client){
        return new PersonaUserServiceImpl(repository, client);
    }
}