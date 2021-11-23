package com.techelevator.dao;

import com.techelevator.model.Campground;
import com.techelevator.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcSiteDao implements SiteDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcSiteDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Site> getSitesThatAllowRVs(int parkId) {
        List<Site> sites = new ArrayList<>();
        String sql = "SELECT * FROM site s " +
                "JOIN campground c ON s.campground_id = c.campground_id " +
                "JOIN park p ON c.park_id = p.park_id " +
                "WHERE p.park_id = ? AND s.max_rv_length > 0 " +
                "ORDER BY s.site_number;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
        while (results.next()) {
            Site site = mapRowToSite(results);
            sites.add(site);
        }
        return sites;
    }

    @Override
    public List<Site> getSitesAvailableByParkId(int parkId) {
        List<Site> sitesDq = new ArrayList<>();
        String sql = "SELECT * from site s " +
                "JOIN campground c ON s.campground_id = c.campground_id " +
                "JOIN park p ON c.park_id = p.park_id " +
                "JOIN reservation r ON s.site_id = r.site_id " +
                "WHERE p.park_id = ? AND ('10/22/2021' BETWEEN r.from_date AND r.to_date);";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId, LocalDate.now());
        while (results.next()) {
            Site site = mapRowToSite(results);
            sitesDq.add(site);
        }
        List<Site> sites = new ArrayList<>();
        sql = "SELECT * from site s " +
                "JOIN campground c ON s.campground_id = c.campground_id " +
                "JOIN park p ON c.park_id = p.park_id " +
                "WHERE p.park_id = ?;";

        results = jdbcTemplate.queryForRowSet(sql, parkId);
        while (results.next()) {
            Site site = mapRowToSite(results);
            sites.add(site);
        }
        sites.removeIf(sitesDq::contains);
        return sites;
    }

    private Site mapRowToSite(SqlRowSet results) {
        Site site = new Site();
        site.setSiteId(results.getInt("site_id"));
        site.setCampgroundId(results.getInt("campground_id"));
        site.setSiteNumber(results.getInt("site_number"));
        site.setMaxOccupancy(results.getInt("max_occupancy"));
        site.setAccessible(results.getBoolean("accessible"));
        site.setMaxRvLength(results.getInt("max_rv_length"));
        site.setUtilities(results.getBoolean("utilities"));
        return site;
    }
}
