package com.techelevator;

public class FunStuff {
    public static void  main(String[] args) {

        // Best practice for array declaration
        int[] scores = new int[4]; // 4 is the size/length of the array

        // try some stuff - other ways to declare
        int weights[] = new int[4];
        // int[4] ages = new int[]; // DOES NOT WORK

        // shorthand initialization if you know the values
        int[] ages = {12, 13, 15, 8};

        // change first value
        int fredsAge = 21;
        ages[0] = fredsAge;
        ages[1] = fredsAge - 1;
    }
}
