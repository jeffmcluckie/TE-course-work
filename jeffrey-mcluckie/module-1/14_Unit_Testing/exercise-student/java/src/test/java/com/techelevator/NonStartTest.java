package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NonStartTest {
    private NonStart nonStart;

    @Before
    public void setup() {
        nonStart = new NonStart();
    }

    //test if 2 string return concatenation omitting first characters
    @Test
    public void getPartialString_removes_first_chars_and_concatenates() {
        String one = "Hello";
        String two = "World";
        String expectedResult = "elloorld";
        String result = nonStart.getPartialString(one, two);
        Assert.assertEquals(result, expectedResult);
    }
    //test is either string is length 1, other string is returned without first character
    @Test
    public void getPartialString_removes_first_char_from_one_string_when_other_is_length_1() {
        String one = "Hello";
        String two = "A";
        String expectedResult = "ello";
        String result = nonStart.getPartialString(one, two);
        Assert.assertEquals(result, expectedResult);
    }
    //test if both strings are length 1, empty string is returned
    @Test
    public void getPartialString_returns_empty_if_both_strings_length_1() {
        String one = "H";
        String two = "A";
        String expectedResult = "";
        String result = nonStart.getPartialString(one, two);
        Assert.assertEquals(result, expectedResult);
    }
}
