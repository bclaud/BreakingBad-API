package com.bclaud.breakingbad.outBoundDatabaseH2;

import com.bclaud.breakingbad.outBoundDatabaseH2.entities.FavPersonaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SpringDataFavPersonaRepository extends JpaRepository<FavPersonaEntity, Long> {
    
    @Transactional
    @Modifying
    @Query(value = "update FavPersonaEntity u set u.favorite = :favorite where u.id = :id")
    public void updateFavPersonaFavorite(@Param("id") long id, @Param("favorite") boolean favorite);
}
