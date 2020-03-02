package com.di2ger.zedge;

import com.di2ger.zedge.model.Album;
import com.di2ger.zedge.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

	@Autowired
	private ItunesProvider itunes;

	@GetMapping("/artist_search")
	public List<Artist> artistSearch(@RequestParam(value = "s") String s) {
		return itunes.getArtists(s);
	}

	@GetMapping("/album_search")
	public List<Album> albumSearch(@RequestParam(value = "id") String id) {
		return itunes.getAlbums(Integer.parseInt(id));
	}
}
