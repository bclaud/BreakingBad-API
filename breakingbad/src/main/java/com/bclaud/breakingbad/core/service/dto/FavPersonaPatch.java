package com.bclaud.breakingbad.core.service.dto;

public class FavPersonaPatch {
    private Long id;
    private Boolean favorite;

    public FavPersonaPatch() {
    }

    public FavPersonaPatch(Long id, Boolean favorite) {
        this.id = id;
        this.favorite = favorite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

}
