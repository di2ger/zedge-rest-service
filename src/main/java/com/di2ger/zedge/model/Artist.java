package com.di2ger.zedge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {
    private String artistType;
    private String artistName;
    private String artistLinkUrl;
    private Integer artistId;
    private Integer amgArtistId;
    private String primaryGenreName;
    private Integer primaryGenreId;

    public String getArtistType() {
        return artistType;
    }

    public void setArtistType(String artistType) {
        this.artistType = artistType;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistLinkUrl() {
        return artistLinkUrl;
    }

    public void setArtistLinkUrl(String artistLinkUrl) {
        this.artistLinkUrl = artistLinkUrl;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Integer getAmgArtistId() {
        return amgArtistId;
    }

    public void setAmgArtistId(Integer amgArtistId) {
        this.amgArtistId = amgArtistId;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public Integer getPrimaryGenreId() {
        return primaryGenreId;
    }

    public void setPrimaryGenreId(Integer primaryGenreId) {
        this.primaryGenreId = primaryGenreId;
    }
}
