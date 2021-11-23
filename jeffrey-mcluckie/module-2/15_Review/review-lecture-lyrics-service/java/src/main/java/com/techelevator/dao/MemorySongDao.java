package com.techelevator.dao;

import com.techelevator.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class MemorySongDao implements SongDao {

    List<Song> songList;

    public MemorySongDao() {
        this.songList = new ArrayList<>();
        songList.add( new Song(1, "BTS", "Permission to Dance"));
        songList.add( new Song(2, "Smashmouth", "All Star"));
        songList.add( new Song(3, "Rebecca Black", "Friday"));
        songList.add( new Song( 4, "Rick Astley", "Never Gonna Give You Up"));
    }

    @Override
    public List<Song> getAllSongs() {
        return songList;
    }

    @Override
    public Song getSong(int id) {
        Song match = null;
        for (Song song : songList) {
            if( song.getId() == id ) {
                match = song;
                break;
            }
        }
        return match;
    }
}
