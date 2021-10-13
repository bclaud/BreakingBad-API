package com.bclaud.breakingbad.outboundbreakingbadapi.client.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonaDto {
    private Long char_id;
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
