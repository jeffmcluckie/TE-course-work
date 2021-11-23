package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {
        Hotel[] hotelList = restTemplate.getForObject(API_BASE_URL + "hotels/", Hotel[].class);
        return hotelList;
    }

    public Review[] listReviews() {
        return restTemplate.getForObject(API_BASE_URL + "reviews/",
                Review[].class);
    }

    public Hotel getHotelById(int id) {
        Hotel hotel = restTemplate.getForObject(API_BASE_URL + "hotels/" + id,
                Hotel.class);
        return hotel;
    }

    public Review[] getReviewsByHotelId(int hotelID) {
        return restTemplate.getForObject(API_BASE_URL + "hotels/1/reviews",
                Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        String url = String.format("%shotels?stars=%s",API_BASE_URL, stars);
        System.out.println("URL="+url);
        return restTemplate.getForObject(url,
                Hotel[].class);
//        return restTemplate.getForObject(API_BASE_URL + "hotels?stars=" + stars,
//                Hotel[].class);
    }

    public City getWithCustomQuery(){
        return null;
    }

}
