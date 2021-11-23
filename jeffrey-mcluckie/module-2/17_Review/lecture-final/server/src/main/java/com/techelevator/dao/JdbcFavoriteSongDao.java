package com.techelevator.dao;

import com.techelevator.model.FavoriteSong;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component // Allows Spring to find this and put it in our controller
public class JdbcFavoriteSongDao implements FavoriteSongDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcFavoriteSongDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<FavoriteSong> getAllSongs(String userName) {
        List<FavoriteSong> songList = new ArrayList<>();

        String sql = "SELECT favorite_song.* FROM favorite_song " +
                "JOIN users ON users.user_id = favorite_song.user_id " +
                "WHERE username = ? ORDER BY favorite_id;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userName);

        while(rowSet.next()) {
            FavoriteSong favoriteSong = mapRowToFavoriteSong(rowSet);
            songList.add(favoriteSong);
        }

        return songList;
    }


    @Override
    public FavoriteSong getSong(long songId) {
        return null;
    }

    @Override
    public FavoriteSong create(FavoriteSong favoriteSong) {
        return null;
    }

    @Override
    public FavoriteSong update(FavoriteSong favoriteSong) {
        return null;
    }

    @Override
    public void delete(long songId) {

    }

    private FavoriteSong mapRowToFavoriteSong(SqlRowSet rowSet) {
        FavoriteSong favoriteSong = new FavoriteSong();
        favoriteSong.setId(rowSet.getLong("favorite_id"));
        favoriteSong.setUser_id(rowSet.getLong("user_id"));
        favoriteSong.setTitle(rowSet.getString("song_name"));
        return favoriteSong;
    }
}
