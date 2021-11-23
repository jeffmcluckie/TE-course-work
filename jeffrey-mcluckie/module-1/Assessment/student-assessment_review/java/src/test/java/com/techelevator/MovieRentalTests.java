package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MovieRentalTests {

    @Test
    public void testBluRayRentalPrice() {
        MovieRental movie= new BluRayRental("Test", false);
        Assert.assertEquals(new BigDecimal("2.99"), movie.getRentalPrice());

        MovieRental premium = new BluRayRental("Test", true);
        Assert.assertEquals(new BigDecimal("3.99"), premium.getRentalPrice());
    }

    @Test
    public void testDVDRentalPrice() {
        MovieRental movie= new DVDRental("Test", false);
        Assert.assertEquals(new BigDecimal("1.99"), movie.getRentalPrice());

        MovieRental premium = new DVDRental("Test", true);
        Assert.assertEquals(new BigDecimal("2.99"), premium.getRentalPrice());
    }

    @Test
    public void testVHSRentalPrice() {
        MovieRental movie= new VHSRental("Test", false);
        Assert.assertEquals(new BigDecimal("0.99"), movie.getRentalPrice());

        MovieRental premium = new VHSRental("Test", true);
        Assert.assertEquals(new BigDecimal("1.99"), premium.getRentalPrice());
    }

    @Test
    public void testLateFee() {
        MovieRental movie = new VHSRental("Test", false);

        Assert.assertEquals(new BigDecimal("0"), movie.getLateFee(-1));
        Assert.assertEquals(new BigDecimal("0"), movie.getLateFee(0));
        Assert.assertEquals(new BigDecimal("1.99"), movie.getLateFee(1));
        Assert.assertEquals(new BigDecimal("3.99"), movie.getLateFee(2));
        Assert.assertEquals(new BigDecimal("19.99"), movie.getLateFee(3));
        Assert.assertEquals(new BigDecimal("19.99"), movie.getLateFee(1000));
    }
}
