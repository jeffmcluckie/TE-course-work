package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lucky13Test {
    private Lucky13 lucky13;

    @Before
    public void setup() { lucky13 = new Lucky13(); }

    //test true if array has no 1s or 3s
    @Test
    public void getLucky_true_if_given_array_has_no_1s_or_3s() {
        int intArray[] = {0, 2, 4};
        boolean expectedResult = true;
        boolean result = lucky13.getLucky(intArray);
        Assert.assertEquals(result, expectedResult);
    }

    //test false if array has any 1s
    @Test
    public void getLucky_false_if_given_array_has_any_1s() {
        int intArray[] = {1, 2, 4, 5, 6};
        boolean expectedResult = false;
        boolean result = lucky13.getLucky(intArray);
        Assert.assertEquals(result, expectedResult);
    }
    //test false if array has any 3s
    @Test
    public void getLucky_false_if_given_array_has_any_3s() {
        int intArray[] = {3, 2, 4, 10, 100};
        boolean expectedResult = false;
        boolean result = lucky13.getLucky(intArray);
        Assert.assertEquals(result, expectedResult);
    }
    //test false if array has both 1s and 3s just in case
    @Test
    public void getLucky_false_if_given_array_has_both_1s_and_3s() {
        int intArray[] = {1, 3, 4, 1000};
        boolean expectedResult = false;
        boolean result = lucky13.getLucky(intArray);
        Assert.assertEquals(result, expectedResult);
    }
}
