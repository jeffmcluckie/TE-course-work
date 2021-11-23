package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");

        // Scanner.nextLine() always gives a String
        String discountIn = scanner.nextLine();
        //System.out.println("You entered: " + discountIn);
        double discountPercentage = Double.parseDouble(discountIn) / 100;
        System.out.println("You entered: " + discountPercentage);

        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String pricesIn = scanner.nextLine();
        System.out.println("You entered:" + pricesIn);

        // Break the string into an array
        String[] priceArray = pricesIn.split(" ");

        // Process each string price:
        //  -- turn into double price (to do math)
        //  -- multiply that double price by discount percentage (this gives the amount saved)
        //  -- subtract amount saved from the price & show that to the user
        for (int i = 0; i < priceArray.length; i++) {
            //System.out.println("Price " + (i+1) + ": " + priceArray[i]);
            double price = Double.parseDouble(priceArray[i]);
            double amountSaved = discountPercentage * price;
            double salePrice = price - amountSaved;
            System.out.println("Original price was: " + price + " Sale price is: " + salePrice + " You save:" + amountSaved );
        }






    }

}