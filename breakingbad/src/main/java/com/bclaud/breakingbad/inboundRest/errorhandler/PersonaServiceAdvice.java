package com.bclaud.breakingbad.inboundRest.errorhandler;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.bclaud.breakingbad.core.exceptions.PersonaExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonaServiceAdvice {

    @ExceptionHandler(PersonaExceptions.class)
    public ResponseEntity<StandardError> personaExceptionsHandler(PersonaExceptions e, HttpServletRequest request){
        String error = "Persona exception";
        HttpStatus status = HttpStatus.NOT_FOUND;
        var err = StandardError.builder()
            .timestamp(Instant.now())
            .status(status.value())
            .error(error)
            .errorDescription(e.getMessage())
            .path(request.getRequestURI())
            .build();

        return ResponseEntity.status(status).body(err);
    }
}
