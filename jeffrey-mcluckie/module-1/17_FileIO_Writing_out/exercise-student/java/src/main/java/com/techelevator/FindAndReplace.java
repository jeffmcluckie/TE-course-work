package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What is the search word? ");
        String word = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String replacementWord = userInput.nextLine();

        System.out.println("What is the source file?");
        String path = userInput.nextLine();
        File dataFile = new File(path);
        try(Scanner dataInput = new Scanner(dataFile)) {
        } catch (FileNotFoundException e) {
            System.err.println("The file does not exist");
        }


        System.out.println("What is the destination file?");
        String path2 = userInput.nextLine();
        File fileOut = new File(path2);

        try (
                Scanner dataInput = new Scanner(dataFile);
                PrintWriter dataOutput = new PrintWriter(fileOut);
                ) {
            while (dataInput.hasNext()) {
                String lineOfInput = dataInput.nextLine();
                dataOutput.println(lineOfInput.replace(word, replacementWord));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Can not open the file for writing");
        }
    }
}





