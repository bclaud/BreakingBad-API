package com.bclaud.breakingbad.inboundRest.errorhandler;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter
@Builder
public class StandardError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String errorDescription;
    private String path;

}
