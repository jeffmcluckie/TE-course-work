package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTest {
    private AnimalGroupName animalGroupName;
    @Before
    public void setup() { animalGroupName = new AnimalGroupName();}
    @Test
    // test for "return group name of that animal"
    public void getHerd_returns_value_of_key_lower_case() {

        String animal = "elephant";
        String expectedValue = "Herd";
        String value = animalGroupName.getHerd(animal);
        Assert.assertEquals(expectedValue, value);
    }
    @Test
    // test for "animal name should be case insensitive"
    public void getHerd_returns_value_of_key_ignoring_case() {

        String animal1 = "GirAfFe";
        String expectedValue = "Tower";
        String value = animalGroupName.getHerd(animal1);
        Assert.assertEquals(expectedValue, value);
    }
    @Test
    // test for "if animal is not found, return unknown"
    public void getHerd_animal_name_is_not_found() {
        String animal = "jeffmcluckie";
        String expectedValue = "unknown";
        String value = animalGroupName.getHerd(animal);
        Assert.assertEquals(expectedValue, value);
    }
    @Test
    // test for "if animal is null, return unknown"
    public void getHerd_animal_name_is_null() {
        String animal = null;
        String expectedValue = "unknown";
        String value = animalGroupName.getHerd(animal);
        Assert.assertEquals(expectedValue, value);
    }
    @Test
    // test for "if animal is empty, return unknown"
    public void getHerd_animal_name_is_empty() {
        String animal = "";
        String expectedValue = "unknown";
        String value = animalGroupName.getHerd(animal);
        Assert.assertEquals(expectedValue, value);
    }
    // only any one of these last 3 tests is necessary??
}
