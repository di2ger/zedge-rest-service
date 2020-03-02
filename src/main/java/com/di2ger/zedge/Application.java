package com.di2ger.zedge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class Application {

    @Value("${itunes.artist.search.url.template}")
    private String artistSearchTemplate;

    @Value("${itunes.album.search.url.template}")
    private String albumSearchTemplate;

    @Value("${itunes.album.limit}")
    private Integer numberOfAlbums;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ItunesProvider itunes() {
        return new Itunes(artistSearchTemplate, albumSearchTemplate, numberOfAlbums);
    }

}
