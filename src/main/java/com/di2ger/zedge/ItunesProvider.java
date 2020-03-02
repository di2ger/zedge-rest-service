package com.di2ger.zedge;

import com.di2ger.zedge.model.Album;
import com.di2ger.zedge.model.Artist;

import java.util.List;

public interface ItunesProvider {
    List<Artist> getArtists(String searchString);
    List<Album> getAlbums(Integer id);
}
