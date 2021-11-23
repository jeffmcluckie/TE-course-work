package com.techelevator;

import java.math.BigDecimal;

public class DVDRental extends MovieRental{

    public DVDRental(String title, boolean premium) {
        super(title, premium);
    }

    @Override
    public BigDecimal getRentalPrice() {
        BigDecimal rentalPrice = new BigDecimal("1.99");

        if(isPremium()) {
            rentalPrice = rentalPrice.add(new BigDecimal("1.00"));
        }

        return rentalPrice;
    }

    @Override
    public String getFormat() {
        return "DVD";
    }
}
