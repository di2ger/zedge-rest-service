package com.di2ger.zedge;

import com.di2ger.zedge.model.Album;
import com.di2ger.zedge.model.AlbumSearchResultsWrapper;
import com.di2ger.zedge.model.Artist;
import com.di2ger.zedge.model.ArtistSearchResultsWrapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Itunes implements ItunesProvider {
    private final String artistSearchTemplate;
    private final String albumSearchTemplate;
    private final Integer numberOfAlbums;
    private final AtomicLong requestsCounter = new AtomicLong(0);

    private final RestTemplate restTemplate;

    public Itunes(String artistSearchTemplate, String albumSearchTemplate, Integer numberOfAlbums) {
        this.artistSearchTemplate = artistSearchTemplate;
        this.albumSearchTemplate = albumSearchTemplate;
        this.numberOfAlbums = numberOfAlbums;
        this.restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, new MediaType("text", "javascript")));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
    }

    @Override
    @Cacheable("artists")
    public List<Artist> getArtists(String searchString) {
        requestsCounter.incrementAndGet();
        String url = String.format(artistSearchTemplate, searchString);
        ArtistSearchResultsWrapper res = restTemplate.getForObject(url, ArtistSearchResultsWrapper.class);
        return res.getResults();
    }

    @Override
    @Cacheable("albums")
    public List<Album> getAlbums(Integer id) {
        requestsCounter.incrementAndGet();
        String url = String.format(albumSearchTemplate, id, numberOfAlbums);
        AlbumSearchResultsWrapper res = restTemplate.getForObject(url, AlbumSearchResultsWrapper.class);
        return res.getResults().stream().filter(a -> "collection".equals(a.getWrapperType())).collect(Collectors.toList());
    }

    public Long getRequestsCount() {
        return requestsCounter.get();
    }

}
