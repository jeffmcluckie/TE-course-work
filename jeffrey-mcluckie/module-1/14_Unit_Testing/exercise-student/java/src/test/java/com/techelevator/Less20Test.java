package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Less20Test {
    private Less20 less20;

    @Before
    public void setup() { less20 = new Less20(); }

    //test return true if number 1 less than multiple 20
    @Test
    public void isLessThanMultipleOf20_true_if_1_less_than_20_multiple(){
        int n = 19;
        int m = 399;
        boolean expectedResult = true;
        boolean resultN = less20.isLessThanMultipleOf20(n);
        boolean resultM = less20.isLessThanMultipleOf20(m);
        Assert.assertEquals(resultN, expectedResult);
        Assert.assertEquals(resultM, expectedResult);
    }
    //test return true if number 2 less than multiple 20
    @Test
    public void isLessThanMultipleOf20_true_if_2_less_than_20_multiple() {
        int n = 18;
        int m = 398;
        boolean expectedResult = true;
        boolean resultN = less20.isLessThanMultipleOf20(n);
        boolean resultM = less20.isLessThanMultipleOf20(m);
        Assert.assertEquals(resultN, expectedResult);
        Assert.assertEquals(resultM, expectedResult);
    }
    //test return false for other numbers
    @Test
    public void isLessThanMultipleOf20_false_if_not_1_or_2_less_than_20_multiple() {
        int n = 20;
        int m = 13250;
        boolean expectedResult = false;
        boolean resultN = less20.isLessThanMultipleOf20(n);
        boolean resultM = less20.isLessThanMultipleOf20(m);
        Assert.assertEquals(resultN, expectedResult);
        Assert.assertEquals(resultM, expectedResult);
    }
}
