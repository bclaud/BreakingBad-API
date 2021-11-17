package com.bclaud.breakingbad.outBoundDatabaseH2.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@DynamicUpdate
public class FavPersonaEntity {
    @Id
    private Long id;
    @Column
    private String name;
    @ElementCollection
    private List<String> occupation;
    @Column
    private Boolean favorite;
}
