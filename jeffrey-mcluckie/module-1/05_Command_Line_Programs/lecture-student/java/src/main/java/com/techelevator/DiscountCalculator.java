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
        String discountIn = scanner.nextLine();
        double discountPercentage = Double.parseDouble(discountIn) / 100;


        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String pricesIn = scanner.nextLine();

        String[] priceArray = pricesIn.split(" ");
        double priceDouble = Double.parseDouble(discountIn);
        for (int i = 0; i < priceArray.length; i++) {
            System.out.println("Price " + (i+1) + ": " + priceArray[i]);
            double price = Double.parseDouble(priceArray[i]);
            double amountSaved = discountPercentage * price;
            double salePrice = price - amountSaved;
            System.out.println("Original price was: " + price + " Sale price is: " + salePrice + " You saved: " + amountSaved);
        }





    }

}