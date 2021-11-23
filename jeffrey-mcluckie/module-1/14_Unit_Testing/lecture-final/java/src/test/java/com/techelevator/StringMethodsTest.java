package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringMethodsTest {

    // Holds common variable for test class instance so we don't need to make it each time
    private StringMethods stringMethods;
    @Before
    public void setup(){
        stringMethods = new StringMethods();
    }


    @Test
    public void helloName_returns_message_with_correct_name() {
        // Set up variables for what to pass in & what the return will be
        // Arrange - setup the things you need and want to check against
        String name = "Bob";
        String expectedMessage = "Hello Bob!";

        // Can setup instance here or in @Before - depends on whether or no you want to share
        // the same instance across all tests. For this class one instance is fine.
        // Other times you may need a new instance with different properties for each test.
        //StringMethods stringMethods = new StringMethods();

        // Act - call the method you are testing
        String message = stringMethods.helloName(name);

        // Assert - check that the results are what you expect
        Assert.assertEquals(expectedMessage, message);
    }

    // This should trigger a question on is this method behavior correct
    // to the requirements team. (Should it instead return "Hello!")
    @Test
    public void helloName_returns_message_with_empty_name() {
        // Set up variables for what to pass in & what the return will be
        // Arrange - setup the things you need and want to check against
        String name = "";
        String expectedMessage = "Hello !";
        //StringMethods stringMethods = new StringMethods();

        // Act - call the method you are testing
        String message = stringMethods.helloName(name);

        // Assert - check that the results are what you expect
        Assert.assertEquals(expectedMessage, message);
    }


    @Test
    public void hello_name_with_null(){
        //Arrange
        // done by @Before StringMethods stringMethods = new StringMethods();
        String nullStr = null; //not "null"
        //Act
        String result = stringMethods.helloName(nullStr);
        //Assert - can optionally add custom message 
        Assert.assertEquals("that's not how i expected null to work",
                "Hello null!",result);;
    }

    @Test
    public void left2_with_2_character_input(){
        // Arrange - Setup stuff
        String input = "Hi";
        String expectedOutput = "Hi";

        // Act - call my method to test
        String result = stringMethods.left2(input);

        // Assert - check that my output is correct
        Assert.assertEquals(expectedOutput, result);
    }


    // Note that some places will ask for all test methods to start with "test"...
    @Test
    public void test_make_Abba() {
        // No setup needed thanks to @Before
        //Act - can pass in input values directly
        String result = stringMethods.makeAbba("a","b");
        //Assert - can put in expected result directly
        Assert.assertEquals("abba",result);
    }

    @Test
    public void test_make_Abba_same_input_for_both() {
        // No setup needed thanks to @Before
        // Can pass in values directly
        String result = stringMethods.makeAbba("a","a");
        // Can put in expected result directly
        Assert.assertEquals("aaaa",result);
    }

    // Make sure you cover all code paths AND test edge/boundary cases!
    @Test
    public void frontTimes_repeat2() {
        // No setup needed thanks to @Before
        // Can pass in values directly
        String result = stringMethods.frontTimes("Chocolate", 2);
        // Can put in expected result directly
        Assert.assertEquals("ChoCho",result);
    }

    @Test
    public void frontTimes_repeat3() {
        // No setup needed thanks to @Before
        // Can pass in values directly
        String result = stringMethods.frontTimes("Chocolate", 3);
        // Can put in expected result directly
        Assert.assertEquals("ChoChoCho",result);
    }

    @Test
    public void frontTimes_repeat1() {
        // No setup needed thanks to @Before
        // Can pass in values directly
        String result = stringMethods.frontTimes("Chocolate", 1);
        // Can put in expected result directly
        Assert.assertEquals("Cho",result);
    }

    @Test
    public void frontTimes_repeat0() {
        // No setup needed thanks to @Before
        // Can pass in values directly
        String result = stringMethods.frontTimes("Chocolate", 0);
        // Can put in expected result directly
        Assert.assertEquals("",result);
    }

    @Test
    public void frontTimes_length3() {
        // No setup needed thanks to @Before
        // Can pass in values directly
        String result = stringMethods.frontTimes("Abc", 3);
        // Can put in expected result directly
        Assert.assertEquals("AbcAbcAbc",result);
    }

    @Test
    public void frontTimes_length_less_than_3() {
        // No setup needed thanks to @Before
        // Can pass in values directly
        String result = stringMethods.frontTimes("Ab", 2);
        // Can put in expected result directly
        Assert.assertEquals("AbAb",result);
    }


}
