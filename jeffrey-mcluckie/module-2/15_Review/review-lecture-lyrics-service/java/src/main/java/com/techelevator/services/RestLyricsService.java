package com.techelevator.services;

import com.techelevator.model.Lyrics;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component // Allows Spring to autowire this in
public class RestLyricsService implements LyricsService {

    private static final String API_BASE_URL = "https://api.lyrics.ovh/v1/";
    private RestTemplate restTemplate;

    public RestLyricsService() {
        restTemplate = new RestTemplate();
    }

    @Override
    public Lyrics getLyrics(String artist, String songTitle) {
        String path = API_BASE_URL + "/" + artist + "/" + songTitle;
        return restTemplate.getForObject(path, Lyrics.class);
    }
}
