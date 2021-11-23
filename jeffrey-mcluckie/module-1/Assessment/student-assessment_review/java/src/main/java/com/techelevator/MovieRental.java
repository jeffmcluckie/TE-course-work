package com.techelevator;

import java.math.BigDecimal;

public abstract class MovieRental {

    protected String title;
    protected String format;
    private boolean premium;

    public MovieRental(String title, boolean premium) {
        this.title = title;
        this.premium = premium;
    }

    public abstract BigDecimal getRentalPrice();

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract String getFormat();

    public BigDecimal getLateFee(int daysLate) {

        BigDecimal lateFee = BigDecimal.ZERO;

        if(daysLate == 1) {
            lateFee = new BigDecimal("1.99");
        } else if (daysLate == 2) {
           lateFee = new BigDecimal("3.99");
        } else if (daysLate >= 3) {
            lateFee = new BigDecimal("19.99");
        }

        return lateFee;
    }

    @Override
    public String toString() {
        // "MOVIE - {title} - {format} {rental price}"
        return "MOVIE - " + getTitle() + " - " + getFormat() + " " + getRentalPrice();
    }
}
