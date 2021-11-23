package com.techelevator.cipher;

import java.util.Arrays;

public class CaesarCipher implements Cipher {

    private int shift;
    private char[] alphabet;
    private char[] shiftedAlphabet;

    public CaesarCipher(int shift) {
        this.shift = shift;
        this.alphabet = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                            'X', 'Y', 'Z'};
        // Make the shifted alphabet based on the shift int provided
        this.shiftedAlphabet = new char[alphabet.length];
        for (int i = 0; i < alphabet.length; i++) {
            if (i + shift < alphabet.length) {
                shiftedAlphabet[i] = alphabet[i + shift];
            } else {
                shiftedAlphabet[i] = alphabet[(i + shift) % alphabet.length];
            }
        }
        System.out.println("shifting " + shift);
        System.out.print("alphabet: ");
        for (int i = 0; i < alphabet.length; i++) {
            System.out.print( alphabet[i] );
        }
        System.out.print("\n");
        System.out.print("shifted:  ");
        for (int i = 0; i < shiftedAlphabet.length; i++) {
            System.out.print( shiftedAlphabet[i] );
        }
        System.out.print("\n");
    }

    /**
     * This will use the shift value set in the Caesar Cipher to encrypt the message.
     * @param message
     */
    public String encrypt(String message) {
        System.out.println("Encrypting message:" + message);

        String encryptedMessage = "";
        for (char current : message.toUpperCase().toCharArray()) {
            // Search for the character to encrypt in the alphabet, we need the position
            int charPosition = Arrays.binarySearch(alphabet, current);
            //System.out.format("Found letter %s at position %d%n", current, charPosition);
            // Get the encrypted character from the shifted alphabet using the position
            char newCharacter = shiftedAlphabet[charPosition];
            //System.out.println("Replacing with the letter " + newCharacter);
            encryptedMessage += newCharacter;
        }
        return encryptedMessage;
    }

    @Override
    public String decrypt(String message) {
        // TODO - reverse encrypt algorithm
        return "decrypted";
    }
}
