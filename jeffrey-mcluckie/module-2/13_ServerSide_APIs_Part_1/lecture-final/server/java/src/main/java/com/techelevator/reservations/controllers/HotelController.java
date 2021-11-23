package com.techelevator.reservations.controllers;

// The * will import all classes from a package, so this imports
// HotelDao, MemoryHotelDao, MemoryReservationDao, ReservationDao
import com.techelevator.reservations.dao.*;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Annotations are what makes Spring work
// This one says that this class is a controller, which means it will
// listen for HTTP Requests at specific URLs (RequestMapping annotations)
@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list() {
        return hotelDao.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDao.get(id);
    }

    /**
     * Return reservations for a hotel
     * @param id the id of the hotel
     * @return all reservations for a given hotel
     */
    @RequestMapping(path="/hotels/{id}/reservations", method = RequestMethod.GET)
    // id in the URL above is a URL parameter - they come after/between / in the url path
    public List<Reservation> getReservationsByHotel(@PathVariable int id) {
        return reservationDao.findByHotel(id);
    }

    /**
     * Get hotels based on state and city search criteria (case insensitive)
     * @param state - state the hotel must be in (required)
     * @param city - city the hotel must be in (optional)
     * @return list of matching hotels
     */
    @RequestMapping(path="/hotels/filter", method = RequestMethod.GET)
    // Request parameter & query parameter both mean the same thing
    //   - part of the query string (part after the ?) on the url
    //   - URL will look like this: /hotels/filter?state={state}&city={city}
    public List<Hotel> getHotelsByState(@RequestParam String state,
                                        @RequestParam(required = false) String city) {
        return hotelDao.listByState(state, city);
    }

}
