package com.techelevator;

// Need to either import or use fully qualified class name
//import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("   LIST REVIEW");
		System.out.println("####################");
		System.out.println();

		// Declaring a new ArrayList
		// Using fully qualified class name for List, using import for ArrayList
		java.util.List<String> colorList = new ArrayList<String>();

		colorList.add("red");
		colorList.add(0, "blue");

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		// Using generic Map type in variable declaration (on the left)
		// Specifically HashMap when creating instance (on the right)
		// You don't need to repeat the types in the <> on the right
		Map<Integer, String> employeeMap = new HashMap<>();

		// Add some employees
		employeeMap.put(1000, "Mary Mosman");
		employeeMap.put(1010, "Christopher Flores");
		employeeMap.put(1020, "Austen Greenwell");
		employeeMap.put(1030, "Thwin Zan");

		// Get some things back out

		System.out.println("Get an employee from the map, using a variable as the key...");

		// Creating a variable to hold the key...
		int employeeNumber = 1000;
		// Get the employee name from the map by giving it the key
		String employee = employeeMap.get(employeeNumber);

		// Show the results - with a super cool formatted string!
		// Printf allows us to format a string and replace the %d (integer) and %s (string)
		// with different values - there's a whole lot of the format specifiers or %<somethings>
		System.out.printf("Employee %d is %s.%n", employeeNumber, employee);

		// printf & format are two methods that do the same thing
		// You don't have to use a variable for the key, here I get it more directly
		System.out.format("Employee 1020 is %s.%n", employeeMap.get(1020));

		// Update or replace an item
		// Put something at a key that already exists, it replaces the value that was there.
		System.out.println("Updating employee 1000...");
		employeeMap.put(1000, "Mary Beth Mosman");
		System.out.format("Employee 1000 is now %s.%n", employeeMap.get(1000));

		// Remove an employee - remove by key not value
		System.out.println("Removing employee 1020 (Austen Greenwell)...");
		employeeMap.remove(1020);
		System.out.format("Employee 1020 is now %s.%n", employeeMap.get(1020));

		// Show everything in the Map
		System.out.println("Show all the employees...");
		// Step 1 - get the keys
		// Step 2 - iterate or loop over the keys, asking for each value one at a time

		// This was the original code - 3 steps in the for each loop
		// 1. Get the keys of the employeeMap
		Set<Integer> employeeNumbers = employeeMap.keySet();
		// 2. Looping over the keys
		for (Integer empNum : employeeNumbers) {
			// 3. Get the value using the key
			System.out.println("Employee " + empNum + " is " + employeeMap.get(empNum));
		}

<<<<<<< HEAD
=======
		// This is the approach used in the quiz
		for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
			// Get the key & the value from the entry
			System.out.println("Employee " + entry.getKey() + " is " + entry.getValue());
		}
>>>>>>> 8e60ab105ec767c928a144bb5d2cceef1a03e571
	}

}
