package com.techelevator.dao;

import com.techelevator.model.Song;

import java.util.List;

public interface SongDao {

    List<Song> getAllSongs();

    Song getSong(int id);

    // TODO - Add Create, Update, Delete

}
