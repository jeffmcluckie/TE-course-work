package com.techelevator.dao;

import com.techelevator.model.Song;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSongDao implements SongDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcSongDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Song> getAllSongs() {
        List<Song> songList = new ArrayList<>();

        String sql = "SELECT * FROM song ORDER BY id;";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while (rows.next() ){
            Song song = mapRowToSong(rows);
            songList.add(song);
        }
        return songList;
    }

    @Override
    public Song getSong(int id) {
        Song song = null;

        String sql = "SELECT * FROM song WHERE song.id = ?;";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, id);
        if (rows.next()) {
            song = mapRowToSong(rows);
        }

        return song;
    }

    private Song mapRowToSong(SqlRowSet rows) {
        Song song = new Song();
        song.setId(rows.getInt("id"));
        song.setArtist(rows.getString("artist"));
        song.setTitle(rows.getString("title"));
        return song;
    }
}
