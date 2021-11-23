package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner((System.in));

		System.out.print("Enter a temperature: ");
		String enteredTemp = scanner.nextLine();
		double parsedTemp = Double.parseDouble(enteredTemp);

		System.out.print("Enter 'C' for Celsius, Enter 'F' for Fahrenheit: ");
		String enteredUnit = scanner.nextLine();

		if(enteredUnit.equals("C")){
			double tempC = parsedTemp * 1.8 + 32;
			System.out.println(parsedTemp + " degrees C is " + tempC + " degrees F");
		}
		else if(enteredUnit.equals("F")){
			double tempF = (parsedTemp - 32) / 1.8;
			System.out.println(parsedTemp + " degrees F is " + tempF + " degrees C");
		}
		else System.out.println("Please check your inputs and try again.");

	}

}




