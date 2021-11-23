package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarTest {
    private Car car;
    @Before
    public void setup() { car = new Car(2020, "Honda", false);}

    @Test
    public void ageCheck_returns_proper_age(){
        int year = 1985;
        int expectedValue = 36;
        //int value = car.ageCheck();
       //Assert.assertEquals(expectedValue, value);
    }

    @Test
    public void mustReceiveCheck_returns_false_if_age_lessthan_four(){
        //int expectedResult =
    }

    // didnt have time for unit tests :((
}
