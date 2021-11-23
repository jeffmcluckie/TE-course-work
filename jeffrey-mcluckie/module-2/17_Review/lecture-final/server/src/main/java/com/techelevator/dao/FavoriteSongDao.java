package com.techelevator.dao;

import com.techelevator.model.FavoriteSong;

import java.util.List;

public interface FavoriteSongDao {

    List<FavoriteSong> getAllSongs(String userName);

    FavoriteSong getSong(long songId);

    FavoriteSong create(FavoriteSong favoriteSong);

    FavoriteSong update(FavoriteSong favoriteSong);

    void delete(long songId);

}
