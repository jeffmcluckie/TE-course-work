package com.techelevator.controller;

import com.techelevator.dao.MemorySongDao;
import com.techelevator.dao.SongDao;
import com.techelevator.model.Lyrics;
import com.techelevator.model.Song;
import com.techelevator.services.LyricsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongController {

    private SongDao songDao;
    private LyricsService lyricsService;

    // Spring dependency injection
    // The MemorySongDao has the @Component annotation to mark it
    public SongController(SongDao songDao, LyricsService lyricsService) {
        this.songDao = songDao;
        this.lyricsService = lyricsService;
    }

    @RequestMapping(path = "/song", method = RequestMethod.GET)
    public List<Song> getAllSongs() {
        return songDao.getAllSongs();
    }

    @RequestMapping(path = "/song/{id}", method = RequestMethod.GET)
    public Song getSong(@PathVariable int id) {

        // Get the song from the database...
        Song song = songDao.getSong(id);

        // Then use the lyrics service to add the lyrics
        Lyrics songLyrics = lyricsService.getLyrics(song.getArtist(), song.getTitle());
        song.setLyrics(songLyrics.getText());

        // Send back the full song w/ Lyrics
        return song;
    }
}
