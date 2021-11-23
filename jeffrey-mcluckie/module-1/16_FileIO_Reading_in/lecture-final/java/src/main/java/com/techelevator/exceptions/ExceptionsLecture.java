package com.techelevator.exceptions;

import java.util.Scanner;

public class ExceptionsLecture {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		/* What happens when we try to access an array item that doesn't exist? */
		// An Exception is thrown...
		System.out.println("The following cities: ");
		String[] cities = new String[] { "Cleveland", "Columbus", "Cincinatti" };


		/* By default, when an Exception is thrown, it will "bubble up" through the call stack until
		 * it reaches the main method and then will cause the program to exit and print a stacktrace
		 * to the standard output
		 *
		 * By using try/catch blocks, you can stop the Exception from exiting the method and provide
		 * code to handle it. */
		try {
			/*
			 * When we do something that can't run, like access an array index that doesn't exist
			 * an exception is thrown. If we wrap that code with a try block, we can catch those
			 * Exceptions and handle them. (Give a polite error message or try something else.)
			 */
			System.out.println(cities[0]);
			System.out.println(cities[1]);
			System.out.println(cities[2]);
			System.out.println(cities[3]);  // This statement will throw an ArrayIndexOutOfBoundsException
			System.out.println("are all in Ohio."); // This line won't execute because the previous statement throws an Exception
		} catch (ArrayIndexOutOfBoundsException e) {
			// Program picks up here if there is an exception with the "try" code
			System.out.println("Sorry, something went wrong.");
		}


		System.out.println("********************* Woot! **************************");
		
		/* Do something dangerous... */
		/* try/catch blocks will also catch Exceptions that are thrown from method calls further down the stack */
		try {
			System.out.println("Hey ya'll, watch this!");
			doSomethingDangerous();  // throws an ArrayIndexOutOfBoundsException
			System.out.println("See, I told you nothing would go wrong!");
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Sorry, something went wrong inside the method.");
		}
		
		System.out.println("Really???");
		
		/* Getting input can be dangerous... */
		/* catch statements can take advantage of polymorphism. The catch block will handle any Exception that
		 * matches the declared Exception type, including subclasses of the declared type */
		try {
			System.out.println("The standard work week is 40 hours.");
			System.out.print("How many hours did you work this week? >>> ");
			int hoursWorked = Integer.valueOf(scan.nextLine());
			int overtimeHours = hoursWorked - 40;
			System.out.println("You worked " + overtimeHours + " hours of overtime.");
		} // You can catch a higher type of general Exception instead of a specific subclass
		catch (NumberFormatException e) {
			// If you want a specific message or behavior for a specific type of error,
			// catch that specific type...
			System.out.println("You need to enter a number...");
		} catch (Exception e) {
			// If you have multiple types of Exceptions that can occur, you might catch Exception
			// more generally at the end to make sure you don't miss anything
			System.out.println("Sorry something bad happened...");
		}

		System.out.println("****************** Woot! Woot! ************************");
				
		/* Our code can have its own problems... */
		/* we can throw our own Exceptions in response to exceptional cases
		 * see the source code of calculateHotelRoomCharges for an example */
		int nights = -3;
		int numberOfGuests = 2;
		try {
			double amountOwed = calculateHotelRoomCharges(nights, numberOfGuests);
			//System.out.println("Total owed for "+numberOfGuests+" guests for "+nights+" nights is $"+amountOwed);
		} catch (IllegalArgumentException e) {
			System.out.println("You need to enter positive numbers...");
			System.out.println(e.getMessage());
		}

		System.out.println("****************** Woot! Woot! Woot! ******************");
		
		
		/* Above we looked at Runtime issues... We are not required to handle those in our code. */
		/* Some issues are more likely to occur & we want to make sure that we handle them... */
		double currentBalance = 250;
		double amountToWithdraw = 300;

		/* The withdraw method can throw a checked exception (i.e. OverdraftException) so we need to catch it since
		 * the main method does not declare that it throws any exceptions. */
		try {
			double newBalance = withdraw(currentBalance, amountToWithdraw);
			System.out.println("new balance is " + newBalance);
		} catch (OverdraftException e) {
			System.out.println("Sorry, there is not enough money in the account");
			// can access the specific properties on our custom exception type IF we
			// catch the specific type of Exception.
			System.out.println("The overdraft amount is " + e.getOverdraftAmount());
		}
		

		System.out.println("************************ Woot! **************************");
		
		/* if we try to call the withdraw method outside of a try/catch, it will cause a compiler error */
		try {
			withdraw(currentBalance, amountToWithdraw);
		} catch (OverdraftException e) {
			e.printStackTrace();
		}


		/* every Exception contains a "stacktrace" that can be extremely useful in debugging.
		 * The stacktrace contains a record of where the Exception was thrown and all of the 
		 * method calls that lead up to the Exception being thrown. */
		 try {
		 	doSomethingDangerous(); // throws an ArrayIndexOutOfBoundsException
		 } catch (ArrayIndexOutOfBoundsException e) {
		 	System.out.println("AN EXAMPLE OF A STACKTRACE:");
		 	e.printStackTrace(); // will print the Exception stacktrace to the terminal
		 }
		 System.out.println();
	}
	
	/* this method does not need to declare that it throws an IllegalArgumentException because
	 * it is a subclass of RuntimeException.  These are known as "unchecked exceptions" because
	 * the compiler does not force us to catch them. */
	private static double calculateHotelRoomCharges(int nights, int numberOfGuests) {
		final double EXTRA_GUEST_CHARGE = 20;
		final double ROOM_RATE = 85;
		
		/* The throw statements below demonstrate how to throw a new Exception. */
		if(nights < 1) {
			throw new IllegalArgumentException("Minimum number of nights is 1");
		} else if(numberOfGuests < 1) {
			throw new IllegalArgumentException("Minimum number of guests is 1");
		}
		
		int numberOfExtraGuests = 0;
		if(numberOfGuests > 4) {
			numberOfExtraGuests = numberOfGuests - 4;
		}
		
		double dailyRate = ROOM_RATE + (EXTRA_GUEST_CHARGE * numberOfExtraGuests);
		return dailyRate * nights;
	}
	
	/* OverdraftException is a "checked exception" (i.e. it is a subclass of java.lang.Exception)
	 * so we need to either catch it or declare that it is thrown.  This method declares that 
	 * it can throw an OverdraftException using the "throws" keyword */
	public static double withdraw(double currentBalance, double amountToWithdraw)
			throws OverdraftException {
		double newBalance = 0;
		if(amountToWithdraw <= currentBalance) {
			newBalance = currentBalance - amountToWithdraw;
		} else {
			throw new OverdraftException("The requested withdrawal amount is greater than the current balance", Math.abs(currentBalance - amountToWithdraw));
		}
		return newBalance;		
	}

	private static void doSomethingDangerous() {
		int[] numbers = new int[5];
		for(int i = 0; i < 10; i++) {
			numbers[i] = i;  // this line will throw an Exception once i reaches 5
		}
		System.out.println("Look Ma, no Exceptions!");  // This line will not execute because an Exception will be thrown inside the for loop
	}

}
