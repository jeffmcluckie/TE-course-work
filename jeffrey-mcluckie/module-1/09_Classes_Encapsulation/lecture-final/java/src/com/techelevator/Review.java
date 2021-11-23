package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Review {

    public static void main(String[] args) {
        System.out.println("Good morning - we made a new project");

        // Arrays - pets
        String[] petArray = new String[3];
        petArray[0] = "Abby";
        petArray[1] = "Fred";
        System.out.println("3rd Pet is " + petArray[2]);
        petArray[2] = "Kyo";

        System.out.println("Mary's pets...");
        for (String name : petArray) {
            System.out.println("My pet is " + name );
        }

        // Array List - dragon colors
        List<String> dragonArray = new ArrayList<>();
        dragonArray.add("green dragon");
        dragonArray.add("maroon dragon");
        dragonArray.add("blue dragon");
        dragonArray.add(0, "fuscia dragon");

        for (int i = 0; i < dragonArray.size(); i++) {
            System.out.println(dragonArray.get(i));
        }

        // Checking for a value
        System.out.println("Does the list contain a green dragon? "
                + dragonArray.contains("green dragon"));
        if (dragonArray.contains("yellow dragon")) {
            System.out.println("There's a yellow dragon");
        } else {
            System.out.println("Sorry, no yellow dragon");
        }

        // Remove or delete the blue dragon
        dragonArray.remove("blue dragon");
        System.out.println("Dragon list is " + dragonArray);

        // What position in the array is the maroon dragon
        int index = dragonArray.indexOf("maroon dragon");
        System.out.println("Maroon dragon is at " + index);

        index = dragonArray.indexOf("blue dragon");
        System.out.println("Blue dragon is at " + index);

        // Put the blue dragon back
        dragonArray.add("blue dragon");
        System.out.println("Dragon list is " + dragonArray);

        // Add another blue dragon back
        dragonArray.add("blue dragon");
        System.out.println("Dragon list is " + dragonArray);
    }
}
