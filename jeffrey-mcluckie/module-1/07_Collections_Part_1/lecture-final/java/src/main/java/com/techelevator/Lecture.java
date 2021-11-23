package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("   Array Review");
		System.out.println("####################");

		// Create new arrays - both have fixed size
		// shorthand (with values)
		String[] catNames = {"Abby", "Fred", "Kyo"};

		// longer syntax (default values)
		String[] petNames = new String[5];
		petNames[0] = "Professor Trouble";
		petNames[1] = "Juni B";
		petNames[2] = "Hobbs";
		petNames[3] = "Convoy";
		petNames[4] = "Tsuki";

		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		// Creates an ArrayList with the default size of 10
		List<String> studentNames = new ArrayList<String>();
		studentNames.add("Thwin");
		studentNames.add("Garrett");
		studentNames.add("Carson");
		studentNames.add("Ashley");
		studentNames.add("Carly");
		studentNames.add("ORyan");
		studentNames.add("Katie");
		studentNames.add("Anthony");
		studentNames.add("Akil");
		studentNames.add("Danny");
		// If we add more than 10, the ArrayList just gets bigger! Woot!
		studentNames.add("Ryan");

		// Can insert things anywhere you like
		studentNames.add(0, "Jeffrey"); // will put at beginning, index 0
		studentNames.add(5, "Rebecca"); // will put at index 5
		
		// put in the middle (get size (number of items), then divide by 2)
		int middleIndex = studentNames.size() / 2;
		studentNames.add(middleIndex, "Jordan");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		// Both arrays & ArrayLists are ordered by index/position
		// Can iterate over both with a for loop

		System.out.println("Loop over petNames array");
		for (int i = 0; i < petNames.length; i++) {
			System.out.println("petNames[" + i + "]: " + petNames[i]);
		}

		// ArrayList - studentNames
		// arrayList does not have length property, use size method instead
		System.out.println("Loop over studentNames array");
		for (int i = 0; i < studentNames.size(); i++) {
			System.out.println("student name " + i + ": " + studentNames.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		System.out.println("Adding a 2nd Ryan to the end...");
		studentNames.add("Ryan"); // add a second Ryan

		// We'll talk more about why/how this works later, but this works on an
		// ArrayList of Strings, but not an array of Strings
		System.out.println(studentNames);

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		// put in the middle (get size (number of items), then divide by 2)
		System.out.println("Adding Tyler to the middle");
		middleIndex = studentNames.size() / 2;
		studentNames.add(middleIndex, "Tyler");
		System.out.println(studentNames);

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		System.out.println("Remove student at index 3");
		String removedStudent = studentNames.remove(3);
		System.out.println("Removed " + removedStudent);
		System.out.println(studentNames);

		// Remove if present
		System.out.println("Remove Jordan");
		boolean wasItemRemoved = studentNames.remove("Jordan");
		System.out.println("Student removed? " + wasItemRemoved);
		System.out.println(studentNames);

		System.out.println("Remove John");
		wasItemRemoved = studentNames.remove("John");
		System.out.println("Student removed? " + wasItemRemoved);
		System.out.println(studentNames);

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		System.out.println("Does the list contain Jordan? " + studentNames.contains("Jordan"));
		System.out.println("Does the list contain Carly? " + studentNames.contains("Carly"));


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		System.out.println("At what position in the list is Jordan? " + studentNames.indexOf("Jordan"));
		System.out.println("At what position in the list is Carly? " + studentNames.indexOf("Carly"));


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// Take my ArrayList of studentNames & make it a fixed size ordinary array
		// This means we aren't going to be adding removing any more
		String[] studentNamesArray = studentNames.toArray(new String[studentNames.size()]);
		System.out.println("We have an array of Strings...");
//		System.out.println(studentNamesArray); // can't do this now, it just shows the reference

		for (int i = 0; i < studentNamesArray.length; i++) {
			System.out.println(studentNamesArray[i]);
		}

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		System.out.println("Student names is: " + studentNames);
		Collections.sort(studentNames);
		System.out.println("After reverse, we have: " + studentNames);

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		System.out.println("Student names is: " + studentNames);
		Collections.reverse(studentNames);
		System.out.println("After reverse, we have: " + studentNames);


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		// Really great shorthand for loop, BUT you don't get an index or position number
		// Can do this with any of the Collection classes like ArrayList

		System.out.println("Show student names:");
		for (String name : studentNames) {
			System.out.println(name);
		}

		// Can also do this for an array
		System.out.println("Show cat names:");
		for (String cat : catNames) {
			System.out.println(cat);
		}

	}
}
