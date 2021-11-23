package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(long parkId) {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                "FROM park WHERE park_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
        // Getting only 1 value back (park_id is unique)
        if ( results.next() ) {
            park = mapRowToPark(results);
        }
        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        List<Park> parkList = new ArrayList<>();
        String sql = "SELECT park.park_id, park_name, date_established, area, has_camping FROM park " +
                "JOIN park_state ON park_state.park_id = park.park_id " +
                "WHERE state_abbreviation = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        // Getting potentially many results, so loop
        while (results.next()) {
            Park park = mapRowToPark(results);
            parkList.add(park);
        }

        return parkList;
    }

    @Override
    public Park createPark(Park park) {
        String sql = "INSERT INTO park (park_name, date_established, area, has_camping) " +
                "VALUES (?, ?, ?, ?) RETURNING park_id;";
        Long parkId = jdbcTemplate.queryForObject(sql, Long.class,
                    park.getParkName(), park.getDateEstablished(), park.getArea(), park.getHasCamping());
        // By fetching from the database again, any updates from other users (not relevant on insert)
        // or default values will be set in the object
        return getPark(parkId);
    }

    @Override
    public void updatePark(Park park) {
        String sql = "UPDATE park SET park_name = ?, date_established = ?, area = ?, " +
                    "has_camping = ? WHERE park_id = ?;";
        jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(), park.getArea(),
                park.getHasCamping(), park.getParkId());
    }

    @Override
    public void deletePark(long parkId) {
        // Shouldn't leave anything in the park_state table or we can't delete the park
        // Make sure we remove from park_state first!
        String sqlParkState = "DELETE FROM park_state WHERE park_id = ?;";
        jdbcTemplate.update(sqlParkState, parkId);
        // Once the rows from park_state are gone, OK to delete from park
        String sqlPark = "DELETE FROM park WHERE park_id = ?;";
        jdbcTemplate.update(sqlPark, parkId);
    }

    @Override
    public void addParkToState(long parkId, String stateAbbreviation) {
        String sql = "INSERT INTO park_state (park_id, state_abbreviation) VALUES (?, ?);";
        jdbcTemplate.update(sql, parkId, stateAbbreviation);
    }

    @Override
    public void removeParkFromState(long parkId, String stateAbbreviation) {
        String sql = "DELETE FROM park_state WHERE park_id = ? AND state_abbreviation = ?;";
        jdbcTemplate.update(sql, parkId, stateAbbreviation);
    }

    // Object Relational Mapping - taking row/column from the database & setting values in Java object
    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();
        // Going through each of the Park setters & getting the value from the row set
        Long parkId = rowSet.getLong("park_id");
        park.setParkId( parkId );

        // short-hand by putting all in one line
        park.setParkName( rowSet.getString("park_name") );
        park.setArea( rowSet.getDouble("area") );
        park.setDateEstablished( rowSet.getDate("date_established").toLocalDate() );
        park.setHasCamping( rowSet.getBoolean("has_camping"));

        return park;
    }
}
