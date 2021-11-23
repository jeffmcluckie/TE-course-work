package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.
		 * It provides methods to inspect and modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use
		 * of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		// Get a path for a file from the user
		System.out.println("Please enter a directory path: ");
		String path = userInput.nextLine();
		File fileObj = new File(path);

		// Check to see if that exists
		if (fileObj.exists()) {
			// get general info from the file object
			System.out.println("name:" + fileObj.getName());
			System.out.println("path:" + fileObj.getPath());
			System.out.println("absolute path:" + fileObj.getAbsolutePath());

			// If it exists is that a file or directory
			if (fileObj.isDirectory()) {
				System.out.println("This is a directory");
			} else if (fileObj.isFile()) {
				System.out.println("Oh no... This is a file!");
				return; // End if it is not a directory
			} else {
				System.out.println("Not a file or directory!!!");
				return; // End if it is not a directory
			}
		} else {
			System.out.println("Sorry that path does not exist.");
			return; // End if path does not exist
		}

		/***********************************************
		 * Make a directory! Woot!
		 ***********************************************/
		System.out.println("You entered a valid directory that exists!");
		// Make a new directory for output in the previous path

		// Make a new File using the old path + "output"
		String userPath = fileObj.getAbsolutePath();
		File outputDirectory = new File(userPath + "/output");
		// We don't expect this to exist, but let's check then remove it if there
		if (outputDirectory.exists()) {
			System.out.println("Output directory already exists...");
			// Get rid of it if it already exists! Woot!
			// This only works if it is empty... poo...
			outputDirectory.delete();
		}

		// Make the directory cuz we know it doesn't exist...
		if (outputDirectory.mkdir()) {
			System.out.println("New directory created at " + outputDirectory.getAbsolutePath());
		} else {
			System.out.println("Sorry, could not create the output directory...");
			// Exit if the directory does not exist
			if (!outputDirectory.exists()) {
				// return exits with a good status ONLY because this is in main
				//return; // Couldn't create our output directory so exit
				System.exit(1); // exit with a 1 means something bad happened
			}
		}

		/*************************************************************
		 *  Make a file
		 *************************************************************/
		System.out.println("Enter a new file name: ");
		String fileName = userInput.nextLine();
		String newFilePath = outputDirectory.getAbsolutePath() + "/" + fileName;
		File newFileObj = new File(newFilePath);
		System.out.println("New file location is: " + newFileObj.getAbsolutePath());

		// Before we do anything, does that file exist?
		if (newFileObj.exists()){
			System.out.println("That file already exists... delete it!!!");
			// Delete it!
			newFileObj.delete();
		}
		// Does not exist, so let's make it!
		newFileObj.createNewFile();


		/*****************************************************
		 * Write something to the file! Woot!
		 *****************************************************/
		// To write to a file, we'll use the PrintWriter class
		// using the try-with-resource to make sure that is closed/cleaned up
		// when we are done using it (or the block ends)
		try (PrintWriter writer = new PrintWriter(newFileObj)) {
			writer.format("Test %d Woot...%n", 123);
			writer.println("Hello new file! Woot!");
		}

		// Can we get rid of stuff too?
		// Yes, updated code above to delete and remake.

		/*************************************************
		 * Use a FileOutputStream...
		 ************************************************/
		// Can we append to a file? No, not with PrintWriter, but...
		System.out.println("Enter another new file name: ");
		// reusing variables because we are done with them and I don't wanna think up new names
		fileName = userInput.nextLine();
		newFilePath = outputDirectory.getAbsolutePath() + "/" + fileName;
		newFileObj = new File(newFilePath);
		// Try to make it if not there
		newFileObj.createNewFile();

		System.out.println("New file location is: " + newFileObj.getAbsolutePath());

		// Can't write strings to the output stream OH NO!!!
		//FileOutputStream outputStream = new FileOutputStream(newFileObj);
		//outputStream.write("ARGH!!!");

		// BUT what I can do is wrap the OutputStream with a PrintWriter
		try (PrintWriter streamPrintWriter = new PrintWriter(new FileOutputStream(newFileObj, true))) {
			// Try appending to the stream through the PrintWriter...
			streamPrintWriter.println("Hello, I was here...");
		}
	}
}
