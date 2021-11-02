package com.bclaud.breakingbad.inboundRest.inboundDto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Getter
public class FavPersonaInputDto {
    
    private Long id;
    private Boolean favorite;
}
