package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		//Declaring a new ArrayList
		List<String> colorList = new ArrayList<String>();

		colorList.add("red");
		colorList.add(0, "blue");

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		Map<Integer, String> employeeMap = new HashMap<>();

		//Add some employees
		employeeMap.put(1000, "Mary mosman");
		employeeMap.put(1010, "Christopher Flores");
		employeeMap.put(1020, "Greenwell");
		employeeMap.put(1030, "Thwin Zan");

		// Get some things back out
		int employeeNumber = 1000;
	}

}
