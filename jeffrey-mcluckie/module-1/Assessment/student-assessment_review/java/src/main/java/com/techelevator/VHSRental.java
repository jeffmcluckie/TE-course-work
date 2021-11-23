package com.techelevator;

import java.math.BigDecimal;

public class VHSRental extends MovieRental{

    public static final String VHS = "VHS";

    public VHSRental(String title, boolean premium) {
        super(title, premium);
    }

    @Override
    public BigDecimal getRentalPrice() {
        BigDecimal rentalPrice = new BigDecimal(".99");

        if(isPremium()) {
            rentalPrice = rentalPrice.add(new BigDecimal("1.00"));
        }

        return rentalPrice;
    }

    @Override
    public String getFormat() {
        return VHS;
    }
}
