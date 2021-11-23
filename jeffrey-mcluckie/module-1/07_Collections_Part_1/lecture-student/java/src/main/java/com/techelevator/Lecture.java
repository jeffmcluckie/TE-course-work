package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("       Array Review");
		System.out.println("####################");

		// Create new arrays - shorthand (with values), longer (defaults)
		String[] catNames = {"Abby", "Fred", "Kyo"};

		String[] petNames = new String[5];
		petNames[0] = "Professor Trouble";
		petNames[1] = "Juni B";
		petNames[2] = "Hobbs";
		petNames[3] = "Convoy";
		petNames[4] = "Tsuki";

		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		// Creates an array list with the default size of 10
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
		// If we add more than 10, the ArrayList just gets bigger.
		studentNames.add("Ryan");

		//Can insert things anywhere you like
		studentNames.add(0, "Jeffrey"); // will put at beginning, index 0
		studentNames.add(5, "Rebecca");

		// put in the middle (get size, then divide by 2
		int middleIndex = studentNames.size() / 2;
		studentNames.add(middleIndex, "Jordan");


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		// Both arrays & ArrayLists are ordered by index/position
		// Can iterate over both with a for loop

		System.out.println("Loop over petNames array");
		for (int i = 0; i < petNames.length; i++) {
			System.out.println(petNames[i]);
		}

		// ArrayList - studentNames
		// ArrayList does not have length property, use size
		for (int i = 0; i < studentNames.size(); i++) {
			System.out.println(studentNames.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		studentNames.add("Ryan"); // add a second Ryan

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		//Refer to the "Jordan" example

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		// Remove student at index 3
		String removedStudent = studentNames.remove(3);
		System.out.println(removedStudent);

		// Remove if present
		boolean wasItemRemoved = studentNames.remove("Jordan);"); //true, will return false if person isnt there

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		boolean listContains = studentNames.contains("Jordan"); //true if hes there, false because removed

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		System.out.println("At what position in the list is Jeffrey?" + studentNames.indexOf("Jeffrey")); //0, if not in list -1

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// Take my ArrayList of studentNames and make it a fixed sized ordinary array
		// This means we are not going to be adding removing any more
		String[] studentNamesArray = studentNames.toArray(new String[studentNames.size()]);
		System.out.println("We have an array of strings...");
		for (int i = 0; i < studentNamesArray.length; i++) {
			System.out.println(studentNamesArray[i]);

		}

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(studentNames); //sorts alphabetically, cant unsort after sorting


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(studentNames);


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		// Great shorthand for  loop, BUT no index or position number
		for(String name : studentNames){
			System.out.println(name);
		}


	}
}
