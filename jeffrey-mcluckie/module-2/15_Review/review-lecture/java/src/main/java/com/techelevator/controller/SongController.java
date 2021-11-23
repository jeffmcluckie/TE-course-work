package com.techelevator.controller;

import com.techelevator.dao.MemorySongDao;
import com.techelevator.dao.SongDao;
import com.techelevator.model.Song;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongController {

    private SongDao songDao;

    // Not dependency injected by Spring
//    public SongController() {
//        this.songDao = new MemorySongDao();
//    }

    // Spring dependency injection
    // The MemorySongDao has the @Component annotation to mark it
    public SongController(SongDao songDao) {
        this.songDao = songDao;
    }

    @RequestMapping(path = "/song", method = RequestMethod.GET)
    public List<Song> getAllSongs() {
        return songDao.getAllSongs();
    }

    @RequestMapping(path = "/song/{id}", method = RequestMethod.GET)
    public Song getSong(@PathVariable int id) {
        return songDao.getSong(id);
    }
}
