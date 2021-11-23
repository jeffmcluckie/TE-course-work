package com.techelevator.cipher;

import java.util.Scanner;

/**
 * Command Line application to encrypt and decrypt messages so they are harder
 * for someone to read and understand.
 */
public class MessageApp {

    // Task List
    // [ ] Ask user which algorithm/cipher (start w/ CC - Caesar Cipher)
    // These things are specific to the cipher, separate out?
    //  [X] For CC: We'll need to know how many characters to shift (ask user for #)
    //  [X] For CC: We'll need a unshifted & shifted alphabet (array or other data structure?)
    // These things are all more generic - maybe part of the Message App?
    // [ ] We'll need to ask if we are encrypting or decrypting.
    // [X] We'll need to ask user for the message to encrypt/decrypt.
    // [ ] Ask user where to output to - start w/ command line & options later
    public static void main(String[] args) {

        // Shared scanner - pass into other methods as needed
        Scanner userInput = new Scanner(System.in);

        // ToDo - Ask for algorithm later, but for now assume Caesar Cipher

        // Using the generic Interface type here in main allows us the option
        // to use different cipher subclasses later.
        // All will have an encrypt & decrypt method that will behave differently. (polymorphism)
        Cipher cipher = createCipher(userInput);

        // TODO - ask user for encrypt or decrypt assume encrypt for now

        // Get the message and either encrypt or decrypt
        String message = getMessageFromUser(userInput);
        String output = cipher.encrypt(message);

        // TODO - ask where to output, for now assume command line
        System.out.println("Translated message is: " + output);
    }

    private static void displayWelcome(Scanner scanner) {
        System.out.println("Welcome to the secret message application!");
        System.out.println();
        System.out.println("This application will allow you to encrypt or decrypt messages.");
        System.out.println("Currently the application uses the Caesar Cipher, but other ciphers will be added in the future.");
        System.out.println();
    }

    private static String getMessageFromUser(Scanner scanner) {
        System.out.println("Please enter a message: ");
        String message = scanner.nextLine();
        return message;
    }

    /**
     * Gather some extra information for my specific type of cipher
     */
    private static Cipher createCipher(Scanner scanner) {
        // TODO - Assuming Caesar Cipher for now, but could create others later on
        // For CC need number of characters to shift
        boolean haveAllInfo = false;
        int shift = 0;
        while ( !haveAllInfo ){
            try {
                System.out.println("Please enter a number for the Caesar Cipher shift: ");
                shift = Integer.parseInt( scanner.nextLine() );
                System.out.println("Thank you!");
                haveAllInfo = true;
            } catch (NumberFormatException e) {
                System.out.println("Sorry, that's not a number!");
            }
        }

        return new CaesarCipher(shift);
    }
}
