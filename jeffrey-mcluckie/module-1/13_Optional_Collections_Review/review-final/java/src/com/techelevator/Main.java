package com.techelevator;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        /******************** List / ArrayList Stuff *****************************/

        // Review List/ArrayList - list of colors
        // Use the generic type on the left of the =
        List<String> colors = new ArrayList<>();


        // add items as needed, not a fixed size
        colors.add("red");
        colors.add("green");
        // can insert at a specific position
        colors.add(0, "yellow");
        colors.add("brown");
        colors.add("orange");

        // How many in list?
        int colorCount = colors.size();
        System.out.format("We have %d colors right now!%n", colorCount);

        //Iterate and print the colors
        System.out.println("The colors are: ");
        for (String item : colors) {
            System.out.println(item);
        }

        // Remove a color
        System.out.println("Remove orange...");
        colors.remove("orange");

        //Iterate and print the colors
        System.out.println("The colors are now: ");
        for (String item : colors) {
            System.out.println(item);
        }

        // Do we have a specific color
        System.out.println("Do we have mauve? " + colors.contains("mauve"));
        System.out.println("Do we have yellow? " + colors.contains("yellow"));

        /******************** Set / TreeSet Stuff *****************************/

        Set<String> animals = new TreeSet<>();

        // Add some items
        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Bear");
        animals.add("Porcupine");

        // Sets don't allow duplicates
        // I can try to add it, but it is ignored
        animals.add("Lion");

        // Get the size
        int animalCount = animals.size();
        System.out.format("We have %d animals.%n", animalCount);

        // Iterate
        System.out.println("Animals are currently: ");
        for (String item : animals) {
            System.out.println(item);
        }

        // Remove something
        System.out.println("Removing the bear...");
        animals.remove("Bear");

        // Contains something?
        System.out.println("Do I have a Cat?" + animals.contains("Cat"));
        System.out.println("Do I have a Lion?" + animals.contains("Lion"));

        //************************ Map **************************/

        // I wanna track people by their student number
        // key is student number, value is the Person object
        //Map<String, Person> students = new HashMap<>();

        // Change from a HashMap to a LinkedHashMap...
        // ONLY difference is that LinkedHashMap has a predictable order when iterating.
        Map<String, Person> students = new LinkedHashMap<>();

        // Add some stuff - put for Map vs add for Collection stuff
        students.put("10001", new Person("Buffy", "Summers"));
        students.put("10002", new Person("Willow", "Rosenberg"));
        students.put("10003", new Person("Xander", "Harris"));

        // Get the size
        int studentCount = students.size();
        System.out.format("We have %d students.%n", studentCount);

        // Iterate - uses an entrySet to get key & value together
        System.out.println("Students are now: ");
        for (Map.Entry<String, Person> item : students.entrySet()) {
            System.out.format("Student %s is %s.%n", item.getKey(), item.getValue());
        }


        // What if we use the same key?! - Updates the item
        System.out.println("Update student 10001...");
        students.put("10001", new Person("Rupert", "Giles"));

        // Note the update to 10001
        // Also note the order shown MAY be the same, but
        // HashMap DOES NOT guarantee ordering remains the same over time
        System.out.println("Students are now: ");
        for (Map.Entry<String, Person> item : students.entrySet()) {
            System.out.format("Student %s is %s.%n", item.getKey(), item.getValue());
        }


        //********************** Exercise Part 2 #1 *******************

        // Note here I am calling the function passing animal w/ various capitalization
        // keys in the map are lowercase.
        System.out.format("Group of %s animals is a %s%n", "rhino", animalGroupName("rhino"));
        System.out.format("Group of %s animals is a %s%n", "rhino", animalGroupName("Rhino"));
        System.out.format("Group of %s animals is a %s%n", "rhino", animalGroupName("RHINO"));

    }

    public static String animalGroupName(String animalName) {
        //Map<String, String> animals = new HashMap<String, String>();

        // TreeMap allows us to specify a comparator,
        // the String class has one to ignore case!
        Map<String, String> animals = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        animals.put("rhino", "Crash");
        animals.put("giraffe", "Tower");
        animals.put("elephant", "Herd");
        animals.put("lion", "Pride");
        animals.put("crow", "Murder");
        animals.put("pigeon", "Kit");
        animals.put("flamingo", "Pat");
        animals.put("deer", "Herd");
        animals.put("dog", "Pack");
        animals.put("crocodile", "Float");

        // Old code using HashMap
//        if (animalName != null && animals.containsKey(animalName.toLowerCase())) {
//            return animals.get(animalName.toLowerCase());
//        } else {
//            return "unknown";
//        }

        // New code w/ case insensitive comparator in TreeMap
        if (animalName != null && animals.containsKey(animalName)) {
            return animals.get(animalName);
        } else {
            return "unknown";
        }
    }
}
