package com.techelevator.cipher;

import java.util.Scanner;

/**
 * Command Line application to encrypt and decrypt messages so they are harder
 * for someone to read and understand.
 */
public class MessageApp {


    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        // Ask for algorithm later, but for now assume Caesar Cipher

        // Ask user which algorithm/cipher (start w/ CC - Caesar Cipher)
        //  - These things are specific to the cipher, separate out?
        //  - For CC: We'll need to know how many characters to shift (ask user for #)
        //  - For CC: We'll need a unshifted & shifted alphabet (array or other data structure?)
        // Using the generic Interface type here in main
        // allows us the option to use different cipher subclasses later.
        // They will all have an encrypt & decrypt method that will behave differently.
        Cipher cipher = createCipher(userInput);

        // These things are all more generic - maybe part of the Message App?
        // We'll need to ask if we are encrypting or decrypting.
        // TODO - ask, assume encrypt for now

        // We'll need to ask user for the message to encrypt/decrypt.
        String message = getMessageFromUser(userInput);
        String output = cipher.encrypt(message);
        System.out.println("Translated message is: " + output);

        // Ask user where to output to - start w/ command line & options later
        // TODO - ask, for now assume command line
    }

    private static String getMessageFromUser(Scanner userInput) {
        System.out.println("Please enter a message: ");
        String message = userInput.nextLine();
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
