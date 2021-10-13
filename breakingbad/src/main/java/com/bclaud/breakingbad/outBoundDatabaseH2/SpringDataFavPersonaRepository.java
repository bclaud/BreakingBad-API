package com.bclaud.breakingbad.outBoundDatabaseH2;

import com.bclaud.breakingbad.outBoundDatabaseH2.entities.FavPersonaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataFavPersonaRepository extends JpaRepository<FavPersonaEntity, Long> {
    
}
