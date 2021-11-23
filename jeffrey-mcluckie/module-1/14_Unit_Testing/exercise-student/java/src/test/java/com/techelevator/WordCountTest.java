package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {
    private WordCount wordCount;

    @Before
    public void setup() {
        wordCount = new WordCount();
    }

    //test return map with values corresponding to number of time key appears in array
    @Test
    public void getCount_returns_map_with_values_matching_number_of_times_key_appears_in_array() {
        String[] arrayOne = {"ba", "ba", "black", "sheep"};
        Map<String, Integer> expectedResultOne = new HashMap<>();
        expectedResultOne.put("ba", 2);
        expectedResultOne.put("black", 1);
        expectedResultOne.put("sheep", 1);
        Map<String, Integer> resultOne = wordCount.getCount(arrayOne);
        Assert.assertEquals(resultOne, expectedResultOne);
        String[] arrayTwo = {"a", "b", "a", "c", "b"};
        Map<String, Integer> expectedResultTwo = new HashMap<>();
        expectedResultTwo.put("a", 2);
        expectedResultTwo.put("b", 2);
        expectedResultTwo.put("c", 1);
        Map<String, Integer> resultTwo = wordCount.getCount(arrayTwo);
        Assert.assertEquals(resultTwo, expectedResultTwo);
        //tested two examples to be safe
    }

    //test empty array returns empty map
    @Test
    public void getCount_returns_empty_map_if_array_is_empty() {
        String[] array = {};
        Map<String, Integer> expectedResult = new HashMap<>();
        Map<String, Integer> result = wordCount.getCount(array);
        Assert.assertEquals(result, expectedResult);

    }
}
