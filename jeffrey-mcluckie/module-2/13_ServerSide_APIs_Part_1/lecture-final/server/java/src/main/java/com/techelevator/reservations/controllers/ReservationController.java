package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Tells Spring that this class will listen for requests at specific paths
@RestController
public class ReservationController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    // Constructor - setting up our Daos - No Spring stuff in here
    public ReservationController(){
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }


    /**
     * Creates a new reservation
     * @param reservation
     * @return newly created reservation with id
     */
    @RequestMapping(path="/reservations", method = RequestMethod.POST)
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationDao.create(reservation, reservation.getHotelID());
    }

    @RequestMapping(path="/reservations", method = RequestMethod.GET)
    public List<Reservation> getReservations() {
        return reservationDao.findAll();
    }

}
