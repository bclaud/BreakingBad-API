package com.bclaud.breakingbad.inboundRest.inboundDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FavPersonaInputDto {
    
    private Long id;
    private Boolean favorite;
}
