
package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SameFirstLastTest {
    private SameFirstLast sameFirstLast;

    @Before
    public void setup() {
        sameFirstLast = new SameFirstLast();
    }

    //test returns true if array length over 1 and first/last elements equal
    @Test
    public void isItTheSame_true_if_length_greater_than_0_and_first_last_elements_equal() {
        int[] array1 = {2};
        int[] array2 = {3, 0, 3};
        boolean expectedResult = true;
        boolean result1 = sameFirstLast.isItTheSame(array1);
        boolean result2 = sameFirstLast.isItTheSame(array2);
        Assert.assertEquals(result1, expectedResult);
        Assert.assertEquals(result2, expectedResult);
    }

    //test returns false if array length 0
    @Test
    public void isItTheSame_false_if_length_less_than_1() {
        int[] array = {};
        boolean expectedResult = false;
        boolean result = sameFirstLast.isItTheSame(array);
        Assert.assertEquals(result, expectedResult);
    }

    //test returns false if first/last array elements are different
    @Test
    public void isItTheSame_false_if_first_and_last_elements_differ() {
        int[] array = {1, 2};
        boolean expectedResult = false;
        boolean result = sameFirstLast.isItTheSame(array);
        Assert.assertEquals(result, expectedResult);
    }
}
