package com.techelevator.cipher;

/**
 * Generic class for a Cipher algorithm that allows us
 * to encrypt & decrypt a String message.
 */
public interface Cipher {
    String encrypt(String message);
    String decrypt(String message);
}
