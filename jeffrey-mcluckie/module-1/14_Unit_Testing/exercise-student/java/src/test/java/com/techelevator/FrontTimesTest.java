package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrontTimesTest {
    private FrontTimes frontTimes;

    @Before
    public void setup() { frontTimes = new FrontTimes(); }

    //test if length is less than 3, returns n copies of string
    @Test
    public void generateAString_returns_n_copies_of_string_if_length_less_than_3(){
        String two = "ab";
        String one = "a";
        String zero = "";
        int n = 3;
        String resultTwo = frontTimes.generateString(two, n);
        String resultOne = frontTimes.generateString(one, n);
        String resultZero = frontTimes.generateString(zero, n);
        String expectedResultTwo = "ababab";
        String expectedResultOne = "aaa";
        String expectedResultZero = "";
        Assert.assertEquals(resultTwo, expectedResultTwo);
        Assert.assertEquals(resultOne, expectedResultOne);
        Assert.assertEquals(resultZero, expectedResultZero);
    }
    //test if length 3 or more, returns n copies of first 3 characters
    @Test
    public void generateAString_returns_n_copies_of_first_3_characters() {
        String test = "test";
        int n = 3;
        String result = frontTimes.generateString(test, n);
        String expectedResult = "testestes";
        Assert.assertEquals(result, expectedResult);
    }

    // test if n = 0, return ""
    @Test
    public void generateAString_returns_empty_string_if_n_is_0(){
        String test = "test";
        int n = 0;
        String result = frontTimes.generateString(test, n);
        String expectedResult = "";
        Assert.assertEquals(result, expectedResult);

        // not sure if this is necessary based on problem wording
    }

}
