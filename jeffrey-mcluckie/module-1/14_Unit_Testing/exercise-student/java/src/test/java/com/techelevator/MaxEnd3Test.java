package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MaxEnd3Test {
    private MaxEnd3 maxEnd3;

    @Before
    public void setup() {
        maxEnd3 = new MaxEnd3();
    }

    //test when last element of array is larger, array values change to that value
    @Test
    public void makeArray_becomes_array_of_larger_last_elements_value() {

        int[] intArray = {1, 2, 3};
        int[] expectedResult = {3, 3, 3};
        int[] result = maxEnd3.makeArray(intArray);
        boolean test = Arrays.equals(expectedResult, result);
        boolean expectedTest = true;
        Assert.assertEquals(test, expectedTest);
    }

    //test when first element of array is larger, array values change to that value
    @Test
    public void makeArray_becomes_array_of_larger_first_elements_value() {

        int[] intArray = {4, 2, 3};
        int[] expectedResult = {4, 4, 4};
        int[] result = maxEnd3.makeArray(intArray);
        boolean test = Arrays.equals(expectedResult, result);
        boolean expectedTest = true;
        Assert.assertEquals(test, expectedTest);
    }
    //test when first and last values equal,array values change to that value
    @Test
    public void makeArray_becomes_array_of_first_and_last_element_values_if_equal() {

        int[] intArray = {4, 10, 4};
        int[] expectedResult = {4, 4, 4};
        int[] result = maxEnd3.makeArray(intArray);
        boolean test = Arrays.equals(expectedResult, result);
        boolean expectedTest = true;
        Assert.assertEquals(test, expectedTest);
    }
}