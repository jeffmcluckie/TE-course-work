package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTest {
    private CigarParty cigarParty;
    @Before
    public void setup() { cigarParty = new CigarParty();}
    // test if cigars are between 40 and 60 inc, not a weekend > successful
    @Test
    public void haveParty_is_true_for_weekday_with_cigars_in_range() {
        int numberOfCigarsLow = 40;
        int numberOfCigarsHigh = 60;
        boolean isWeekend = false;
        boolean expectedResult = true;
        boolean successfulLow = cigarParty.haveParty(numberOfCigarsLow, isWeekend);
        boolean successfulHigh = cigarParty.haveParty(numberOfCigarsHigh, isWeekend);
        Assert.assertEquals(expectedResult, successfulLow);
        Assert.assertEquals(expectedResult, successfulHigh);
    }
    // test if cigars over 40 inc, weekend > successful
    @Test
    public void haveParty_is_true_for_weekend_with_cigars_in_range() {
        int numberOfCigarsLow = 40;
        int numberOfCigarsHigh = 1000;
        boolean isWeekend = true;
        boolean expectedResult = true;
        boolean successfulLow = cigarParty.haveParty(numberOfCigarsLow, isWeekend);
        boolean successfulHigh = cigarParty.haveParty(numberOfCigarsHigh, isWeekend);
        Assert.assertEquals(expectedResult, successfulLow);
        Assert.assertEquals(expectedResult, successfulHigh);
    }
    // test if cigars below 40 or above 60, not weekend > not successful
    @Test
    public void haveParty_is_false_for_weekday_with_cigars_out_of_range() {
        int numberOfCigarsLow = 39;
        int numberOfCigarsHigh = 61;
        boolean isWeekend = false;
        boolean expectedResult = false;
        boolean successfulLow = cigarParty.haveParty(numberOfCigarsLow, isWeekend);
        boolean successfulHigh = cigarParty.haveParty(numberOfCigarsHigh, isWeekend);
        Assert.assertEquals(expectedResult, successfulLow);
        Assert.assertEquals(expectedResult, successfulHigh);
    }
    // test if cigars below 40, weekend > not successful
    @Test
    public void haveParty_is_false_for_weekend_with_cigars_out_of_range() {
        int numberOfCigarsLow = 0;
        int numberOfCigarsHigh = 39;
        boolean isWeekend = true;
        boolean expectedResult = false;
        boolean successfulLow = cigarParty.haveParty(numberOfCigarsLow, isWeekend);
        boolean successfulHigh = cigarParty.haveParty(numberOfCigarsHigh, isWeekend);
        Assert.assertEquals(expectedResult, successfulLow);
        Assert.assertEquals(expectedResult, successfulHigh);
    }
}
