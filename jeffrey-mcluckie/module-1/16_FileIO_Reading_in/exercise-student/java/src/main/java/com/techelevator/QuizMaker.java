package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Enter the fully qualified name of the file to read in: ");
		Scanner userInput = new Scanner(System.in);
		boolean isNotValid = true;
		File inputFile = null;

		while (isNotValid) {
			String path = userInput.nextLine();
			inputFile = new File(path);
			if (inputFile.exists() == false) {
				System.out.println(path + " does not exist");
			} else if (inputFile.isFile() == false) {
				System.out.println(path + " is not a file");
			} else {
				isNotValid = false;
			}
		}

		Scanner fileScanner = new Scanner(inputFile);
		System.out.println(fileScanner);

	}

}
