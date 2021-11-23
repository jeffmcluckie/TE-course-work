package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner((System.in));
		System.out.print("Please enter a number: ");
		String enteredNumber = scanner.nextLine();
		int intNumber = Integer.parseInt(enteredNumber);
				String fibString = "0, 1 ";
		if(intNumber == 0){
			System.out.println(fibString);
		}


		int num1 = 0;
		int num2 = 1;
		int sum = num1 + num2;
		while(sum <= intNumber) {
			sum = num1 + num2;
			int tempNumber = num2;
			num2 = sum;
			num1 = tempNumber;
			if((num1 + num2) <= intNumber){
				fibString += ", " + (num1 + num2);
			}
		}
		System.out.println(fibString);


			
		}
	}


