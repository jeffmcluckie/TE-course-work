package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		System.out.println("What is the destination file?");
		String path2 = userInput.nextLine();
		File fileOut = new File(path2);

		try(PrintWriter dataOutput = new PrintWriter(fileOut)) {
			for (int i = 1; i <= 300; i++) {
				if(i == 300){
					dataOutput.println("FizzBuzz");
				}
				else if (i % 3 == 0 && i % 5 == 0) {
					dataOutput.println("FizzBuzz");
				} else if (i % 3 == 0) {
					dataOutput.println("Fizz");
				} else if (i % 5 == 0) {
					dataOutput.println("Buzz");
				} else dataOutput.println(i);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Can not open file for writing.");
		}



		}

	}


