package com.bclaud.breakingbad.outBoundDatabaseH2.entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class FavPersonaEntity {
    @Id
    private Long id;
    private String name;
    @ElementCollection
    private List<String> occupation;
    private Boolean favorite;
}
