package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class MapReview {

    public static void main(String[] args) {

        // "101011" -> {1=4, <0=2 }
        System.out.println(countOnesZeros_MapOnly("101011"));
        System.out.println(countOnesZeros_DoubleLoop("101011"));
        System.out.println(countOnesZeros_OneLoop("101011"));
    }

    // Write a method to count the number of 1's & 0's in a string
    // return back a Map<String, Integer> with the "1" or "0" as the key
    //    and the count as the value
    public static Map<String, Integer> countOnesZeros_MapOnly(String input) {
        Map<String, Integer> results = new HashMap<>();
        results.put("1", 0);
        results.put("0", 0);

        // Using split to turn my string into an array to loop over
        // Another option is toCharArray, but that changes my type to char not String
        // Preference is to stick w/ Strings cuz that's what we wanna return
        for (String character : input.split("")) {
            if (character.equals("1")){
                results.put("1", results.get("1") + 1);
            } else {
                results.put("0", results.get("0") + 1);
            }
        }
        return results;
    }

    // Second attempt, loops just once, but uses extra variables
    public static Map<String, Integer> countOnesZeros_OneLoop(String input) {
        Map<String, Integer> results = new HashMap<>();
        int count0 = 0;
        int count1 = 0;

        // Using split to turn my string into an array to loop over
        // Another option is toCharArray, but that changes my type to char not String
        // Preference is to stick w/ Strings cuz that's what we wanna return
        for (String character : input.split("")) {
            if (character.equals("1")){
                count1++;
                results.put("1", count1); //could just use the map to track count instead of variable
            } else {
                count0++;
                results.put("0", count1);
            }
        }
        return results;
    }

    // First attempt, loops through the string a lot... but might be good if we didn't
    // know that there were just 1's and 0's
    public static Map<String, Integer> countOnesZeros_DoubleLoop(String input) {
        Map<String, Integer> results = new HashMap<>();

        // Using split to turn my string into an array to loop over
        for (String character : input.split("")) {
            int count = 0;
            //Loop again to count how many times this character occurs

            for (String ch : input.split("")) {
                if (character.equals(ch)) {
                    count++;
                }
            }
            // The 2nd loop causes us to potentially count the 1's / 0's multiple times
            results.put(character, count);
        }
        return results;
    }
}
