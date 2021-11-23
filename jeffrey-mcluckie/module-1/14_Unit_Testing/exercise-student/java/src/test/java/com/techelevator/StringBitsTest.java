package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringBitsTest {
    private StringBits stringBits;

    @Before
    public void setup() {
        stringBits = new StringBits();
    }

    //test if string returned is made up of every other character
    @Test
    public void getBits_returns_string_made_up_of_every_other_character_in_entered_string(){
        String one = "a";
        String two = "ab";
        String three = "longerword";
        String expectedResultOne = "a";
        String expectedResultTwo = "a";
        String expectedResultThree = "lnewr";
        String resultOne = stringBits.getBits(one);
        String resultTwo = stringBits.getBits(two);
        String resultThree = stringBits.getBits(three);
        Assert.assertEquals(resultOne, expectedResultOne);
        Assert.assertEquals(resultTwo, expectedResultTwo);
        Assert.assertEquals(resultThree, expectedResultThree);

    }
    //test if string is empty, return empty string
    @Test
    public void getBits_returns_empty_string_if_input_is_empty(){
        String test = "";
        String expectedResult = "";
        String result = stringBits.getBits(test);
        Assert.assertEquals(result, expectedResult);
    }
}
