package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args) throws FileNotFoundException {

		printApplicationBanner();
		
		File inputFile = getInputFileFromUser();
		try(Scanner fileScanner = new Scanner(inputFile)) {
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String rtn = line.substring(0, 9);

				// Now that we have data from the file, we can do our stuff with it
				// (checking that it is valid or not)
				if(checksumIsValid(rtn) == false) {
					System.out.println(line);
				}
			}
		}
		// We could catch the Exception here, if our file is not found
		// BUT that breaks encapsulation of our method getInputFileFromUser
		// Sometimes there are better ways to handle Exceptions ie prevent them from being thrown
//		catch (FileNotFoundException e){
//
//		}
	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		// Make 1 scanner to get user input
		Scanner userInput = new Scanner(System.in);
		// Loop until the input from the user is valid
		boolean isNotValid = true;
		File inputFile = null;

		while (isNotValid) {
			System.out.print("Please enter path to input file >>> ");
			String path = userInput.nextLine();
			inputFile = new File(path);
			// This code prevents the FileNotFoundException from being thrown
			// We are explicitly checking for the 2 potential things that could go wrong.
			if (inputFile.exists() == false) { // checks for the existence of a file
				System.out.println(path + " does not exist");
				//System.exit(1); // Ends the program
			} else if (inputFile.isFile() == false) {
				System.out.println(path + " is not a file");
				//System.exit(1); // Ends the program
			} else {
				// We have good input so end the loop
				isNotValid = false;
			}
		}
		// Should always be a good file when we leave the loop
		return inputFile;
	}

	private static boolean checksumIsValid(String routingNumber) {
		System.out.format("Checking number %s%n", routingNumber);
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
