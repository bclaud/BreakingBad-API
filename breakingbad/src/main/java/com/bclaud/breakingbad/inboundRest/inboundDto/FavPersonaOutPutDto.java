package com.bclaud.breakingbad.inboundRest.inboundDto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FavPersonaOutPutDto {
    
    private Long id;
    private String name;
    private List<String> occupation;
    private Boolean favorite;
}
