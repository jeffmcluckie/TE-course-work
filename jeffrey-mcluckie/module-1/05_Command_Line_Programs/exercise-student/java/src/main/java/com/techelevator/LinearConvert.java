package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner((System.in));

		System.out.print("Enter a length: ");
		String enteredLength = scanner.nextLine();
		double parsedLength = Double.parseDouble(enteredLength);

		System.out.print("Enter 'ft' for feet, Enter 'm' for meters: ");
		String enteredUnit = scanner.nextLine();

		if(enteredUnit.equals("ft")){
			double lengthM = parsedLength * .3048;
			System.out.println(parsedLength + "ft is equal to " + lengthM + "m");
		}
		else if(enteredUnit.equals("m")){
			double lengthFt = (parsedLength * 3.2808399);
			System.out.println(parsedLength + "m is equal to " + lengthFt + "ft");
		}
		else System.out.println("Please check your inputs and try again.");

	}

}
