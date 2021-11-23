package com.techelevator;

import java.util.Scanner;

public class FunStuff {
    public static void main(String[] args) {
        int x = 10;
        System.out.println("x is " + x);
        x = 20;
        System.out.println("x is now " + x);

        String message = "hello";
        System.out.println("message is " + message);
        String oldMessage = message;
        message = "good-bye";
        String oldMessage2 = message;
        System.out.println("message is now " + message);
        message = "good afternoon";

        int[] scores = new int[3];
        System.out.println("scores reference is " + scores);
        //Show values from array
        for (int i = 0; i < scores.length; i++) {
            System.out.println("scores[" + i + "] is " + scores[i]);
        }

        Integer[] scoresInt = new Integer[3];
        System.out.println("scores reference is " + scoresInt);
        //Show values from array
        for (int i = 0; i < scoresInt.length; i++) {
            System.out.println("scoresInt[" + i + "] is " + scoresInt[i]);
        }

        String[] msgArray = new String[3];
        System.out.println("msgArray reference is " + msgArray);
        //Show values from array
        for (int i = 0; i < msgArray.length; i++) {
            System.out.println("msgArray[" + i + "] is " + msgArray[i]);
        }

        // Remember Mary says with not using == with Strings, reference types is why
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a String");
        String firstString = scanner.nextLine();

        System.out.println("Enter another String");
        String secondString = scanner.nextLine();


        System.out.println("Testing equality with ==");
        if (firstString == secondString) {
            System.out.println("They were the same String!!!");
        } else {
            System.out.println("The Strings were different!!!");
        }

        System.out.println("Testing equality with .equals");
        if (firstString.equals(secondString)) {
            System.out.println("They were the same String!!!");
        } else {
            System.out.println("The Strings were different!!!");
        }
    }
}
