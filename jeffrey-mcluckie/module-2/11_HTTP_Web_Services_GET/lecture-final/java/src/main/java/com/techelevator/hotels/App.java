package com.techelevator.hotels;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HotelService;

public class App {

    private final ConsoleService consoleService = new ConsoleService();
    private final HotelService hotelService = new HotelService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;

        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();
            if (menuSelection == 1) {
                // System.out.println("Not implemented");

                // Get the list of hotels via the hotel Service
                Hotel[] hotels = hotelService.listHotels();
                // Use the console service to display the list we get back
                consoleService.printHotels(hotels);
            } else if (menuSelection == 2) {
                // System.out.println("Not implemented");
                Review[] reviews = hotelService.listReviews();
                consoleService.printReviews(reviews);
            } else if (menuSelection == 3) {
                //System.out.println("Not implemented");
                Hotel hotel1 = hotelService.getHotelById(1);
                consoleService.printHotel(hotel1);
            } else if (menuSelection == 4) {
                // System.out.println("Not implemented");
                consoleService.printReviews(hotelService.getReviewsByHotelId(1));
            } else if (menuSelection == 5) {
                //System.out.println("Not implemented");
                consoleService.printHotels(hotelService.getHotelsByStarRating(3));
            } else if (menuSelection == 6) {
                System.out.println("Not implemented - Create a custom Web API query here");
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

}
