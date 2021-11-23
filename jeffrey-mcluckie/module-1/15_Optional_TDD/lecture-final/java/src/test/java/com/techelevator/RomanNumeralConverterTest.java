package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralConverterTest {

    @Test
    //make sure 1 returns I
    public void one_should_return_I(){
        //act
        String result = RomanNumeralConverter.convertIntToRomanNumeral(1);
        //assert
        Assert.assertEquals("I",result);
    }
    @Test
    public void two_should_return_II(){
        String result = RomanNumeralConverter.convertIntToRomanNumeral(2);
        Assert.assertEquals("II",result);
    }
    @Test
    public void three_should_return_III(){
        String result = RomanNumeralConverter.convertIntToRomanNumeral(3);
        Assert.assertEquals("III",result);
    }
    @Test
    public void four_should_return_IV(){
        String result = RomanNumeralConverter.convertIntToRomanNumeral(4);
        Assert.assertEquals("IV",result);
    }
    @Test
    public void test_five_thru_ten(){
        String result = RomanNumeralConverter.convertIntToRomanNumeral(5);
        Assert.assertEquals("V",result);
        result  = RomanNumeralConverter.convertIntToRomanNumeral(6);
        Assert.assertEquals("VI",result);
        result  = RomanNumeralConverter.convertIntToRomanNumeral(7);
        Assert.assertEquals("VII",result);
        result  = RomanNumeralConverter.convertIntToRomanNumeral(8);
        Assert.assertEquals("VIII",result);
        result  = RomanNumeralConverter.convertIntToRomanNumeral(9);
        Assert.assertEquals("IX",result);
    }
    @Test
    public void ten_thru_twenty() {
        String result = RomanNumeralConverter.convertIntToRomanNumeral(10);
        Assert.assertEquals("X", result);
        result = RomanNumeralConverter.convertIntToRomanNumeral(14);
        Assert.assertEquals("XIV", result);
        result = RomanNumeralConverter.convertIntToRomanNumeral(15);
        Assert.assertEquals("XV", result);
        result = RomanNumeralConverter.convertIntToRomanNumeral(17);
        Assert.assertEquals("XVII", result);
        result = RomanNumeralConverter.convertIntToRomanNumeral(19);
        Assert.assertEquals("XIX", result);
        result = RomanNumeralConverter.convertIntToRomanNumeral(20);
        Assert.assertEquals("XX", result);
    }
    @Test
    public void twenty_up_to_thirty_nine(){
        String result = RomanNumeralConverter.convertIntToRomanNumeral(25);
        Assert.assertEquals("XXV", result);
        result = RomanNumeralConverter.convertIntToRomanNumeral(29);
        Assert.assertEquals("XXIX", result);
        result = RomanNumeralConverter.convertIntToRomanNumeral(30);
        Assert.assertEquals("XXX", result);
        result = RomanNumeralConverter.convertIntToRomanNumeral(39);
        Assert.assertEquals("XXXIX", result);
    }
    @Test
    public void forty_thru_something(){
        String result = RomanNumeralConverter.convertIntToRomanNumeral(40);
        Assert.assertEquals("XL", result);
        result = RomanNumeralConverter.convertIntToRomanNumeral(41);
        Assert.assertEquals("XLI", result);
        result = RomanNumeralConverter.convertIntToRomanNumeral(49);
        Assert.assertEquals("XLIX", result);
        result = RomanNumeralConverter.convertIntToRomanNumeral(50);
        Assert.assertEquals("L", result);
        result = RomanNumeralConverter.convertIntToRomanNumeral(60);
        Assert.assertEquals("LX", result);
    }
}
