package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("What is the fully qualified name of the file that should be searched?");
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
		System.out.println("What is the search word you are looking for?");
		String word = userInput.nextLine();
		System.out.println("Should the search be case sensitive?");
		String cases = userInput.nextLine();
		if(cases.equals("Y")) {
			try (Scanner fileScanner = new Scanner(inputFile)) {
				int count = 0;
				while (fileScanner.hasNextLine()) {
					count++;
					String line = fileScanner.nextLine();
					if (line.contains(word)) {
						System.out.println(count + ") " + line);
					}
				}

			}
		}
		else if(cases.equals("N")){
			try (Scanner fileScanner = new Scanner(inputFile)) {
				int count = 0;
				while (fileScanner.hasNextLine()) {
					count++;
					String line = fileScanner.nextLine();
					String newLine = line.toLowerCase(Locale.ROOT);
					if (newLine.contains(word.toLowerCase(Locale.ROOT))) {
						System.out.println(count + ") " + line);
					}
				}

			}
		}
	}
	}

