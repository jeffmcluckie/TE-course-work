package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BluRayRental extends MovieRental {

    public BluRayRental(String title, boolean premium) {
        super(title, premium);
    }

    @Override
    public BigDecimal getRentalPrice() {
        BigDecimal rentalPrice = new BigDecimal("2.99");

        if(isPremium()) {
            rentalPrice = rentalPrice.add(new BigDecimal("1.00"));
        }

        return rentalPrice;
    }

    @Override
    public String getFormat() {
        return "Blu-Ray";
    }
}
