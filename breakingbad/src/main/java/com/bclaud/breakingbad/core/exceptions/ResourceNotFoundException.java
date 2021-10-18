package com.bclaud.breakingbad.core.exceptions;

public class ResourceNotFoundException extends PersonaExceptions {
    
    public ResourceNotFoundException(Long id){
        super("Resource not found id: " + id);
    }
}
