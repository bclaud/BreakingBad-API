package com.bclaud.breakingbad.inboundRest.inboundDto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaOutPutDto {
    
    private Long id;
    private String name;
    private String birthday;
    private List<String> occupation;
    private String img;
    private String status;
    private String nickname;
    private List<Integer> appearance;
    private String portrayed;
    private String category;
}
