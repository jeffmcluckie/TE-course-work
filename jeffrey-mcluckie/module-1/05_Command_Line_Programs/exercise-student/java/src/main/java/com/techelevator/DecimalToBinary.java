package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner((System.in));
		System.out.println("Please enter decimal values to be converted to binary: ");
		String enteredDecimal = scanner.nextLine();
		String[] decimalArray = enteredDecimal.split(" ");

		for (int i = 0; i < decimalArray.length; i++) {
			int number = Integer.parseInt(decimalArray[i]);
			String result = Integer.toBinaryString(number);
			System.out.println(result);
		}


	}
}
