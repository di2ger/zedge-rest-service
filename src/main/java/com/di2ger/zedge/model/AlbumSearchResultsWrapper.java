package com.di2ger.zedge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumSearchResultsWrapper {
    private int resultCount;
    private List<Album> results;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<Album> getResults() {
        return results;
    }

    public void setResults(List<Album> results) {
        this.results = results;
    }
}
