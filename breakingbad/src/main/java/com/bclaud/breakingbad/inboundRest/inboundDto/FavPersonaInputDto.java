package com.bclaud.breakingbad.inboundRest.inboundDto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Getter
public class FavPersonaInputDto {
    
    @ApiModelProperty(value = "valid ID of an favorited character", example = "1") private Long id;
    @ApiModelProperty(value = "False to unfavorite and false to refavorite", example = "false")private Boolean favorite;
}
