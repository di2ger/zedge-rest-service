package com.di2ger.zedge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistSearchResultsWrapper {
    private int resultCount;
    private List<Artist> results;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<Artist> getResults() {
        return results;
    }

    public void setResults(List<Artist> results) {
        this.results = results;
    }
}
