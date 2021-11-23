package com.techelevator.dao;

import com.techelevator.model.Reservation;
import com.techelevator.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class JdbcReservationDao implements ReservationDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcReservationDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int createReservation(int siteId, String name, LocalDate fromDate, LocalDate toDate) {
        String sql = "INSERT INTO reservation (site_id, name, from_date, to_date, create_date) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING reservation_id;";
        return jdbcTemplate.queryForObject(sql, int.class, siteId, name, fromDate, toDate, LocalDate.now());
    }

    @Override
    public List<Reservation> getReservationsByParkId(int parkId) {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservation r " +
                "JOIN site s ON s.site_id = r.site_id " +
                "JOIN campground c ON c.campground_id = s.campground_id " +
                "JOIN park p ON p.park_id = c.park_id " +
                "WHERE p.park_id = ? AND r.from_date > ? AND r.from_date <= ? " +
                "ORDER BY r.name;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId, LocalDate.now(), LocalDate.now().plusDays(30));
        while (results.next()) {
            Reservation reservation = mapRowToReservation(results);
            reservations.add(reservation);
        }
        return reservations;
    }

    private Reservation mapRowToReservation(SqlRowSet results) {
        Reservation r = new Reservation();
        r.setReservationId(results.getInt("reservation_id"));
        r.setSiteId(results.getInt("site_id"));
        r.setName(results.getString("name"));
        r.setFromDate(results.getDate("from_date").toLocalDate());
        r.setToDate(results.getDate("to_date").toLocalDate());
        r.setCreateDate(results.getDate("create_date").toLocalDate());
        return r;
    }


}
