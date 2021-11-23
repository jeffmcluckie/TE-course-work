package com.techelevator.crm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PetTests {
    private Pet pet;
    @Before
    public void setup(){
        pet = new Pet("Cody", "dog");
    }
    @Test
    public void listVaccinations_returns_strings_with_commas(){
        List<String> input = Arrays.asList("Rabies", "Distemper", "Parvo");
        String expectedResult = "Rabies, Distemper, Parvo";
        pet.setVaccinations(input);
        String result = pet.listVaccinations();
        Assert.assertEquals(expectedResult, result);
    }
}
