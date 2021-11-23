package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateFashionTest {
    private DateFashion dateFashion;

    @Before
    public void setup() { dateFashion = new DateFashion(); }

    // test when one 8+ stylish, other is 3+ stylish, 2
    @Test
    public void getATable_is_2_when_either_over_8_neither_under_3(){
        int you = 8;
        int date = 3;
        int you2 = 3;
        int date2 = 8;
        int expectedResult = 2;
        int result = dateFashion.getATable(you, date);
        int result2 = dateFashion.getATable(you2, date2);
        Assert.assertEquals(expectedResult, result2);
        Assert.assertEquals(expectedResult, result);
    }
    // test when both between 3 and 7, 1
    @Test
    public void getATable_is_1_when_both_between_8_and_2_noninclusive(){
        int you = 7;
        int date = 3;
        int you2 = 3;
        int date2 = 7;
        int expectedResult = 1;
        int result = dateFashion.getATable(you, date);
        int result2 = dateFashion.getATable(you2, date2);
        Assert.assertEquals(expectedResult, result2);
        Assert.assertEquals(expectedResult, result);
    }
    // test when one is 2-, other is any, 0
    @Test
    public void getATable_is_0_when_either_under_2(){
        int you = 8;
        int date = 2;
        int you2 = 2;
        int date2 = 8;
        int expectedResult = 0;
        int result = dateFashion.getATable(you, date);
        int result2 = dateFashion.getATable(you2, date2);
        Assert.assertEquals(expectedResult, result2);
        Assert.assertEquals(expectedResult, result);
    }

}