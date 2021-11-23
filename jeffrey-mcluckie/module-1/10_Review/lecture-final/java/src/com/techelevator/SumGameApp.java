package com.techelevator;

import java.util.Scanner;

public class SumGameApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Let's play the sum game!");

        SumGame game = new SumGame();

        boolean playerCountValid = false;
        int playerCount = 0;

        while (!playerCountValid) {
            System.out.format("How many players are there? (Enter a number %d-%d) ",
                        SumGame.MIN_PLAYERS, SumGame.MAX_PLAYERS);
            String countIn = scanner.nextLine();
            int count = Integer.parseInt(countIn);
            // By using a constant for MAX_PLAYERS, if this changes we only have to update 1 spot
            if (count >= SumGame.MIN_PLAYERS && count <= SumGame.MAX_PLAYERS) {
                playerCountValid = true;
                playerCount = count;
            }
        }

        boolean playAgain = true;
        while (playAgain) {
            // Initialize the game
            game.setUpGame();

            // Add players
            for (int i = 0; i < playerCount; i++) {
                game.addPlayer();
            }

            System.out.println("Woot! We're ready to play. Let's deal the cards...");
            game.dealCards();

            System.out.println("Press Enter to continue.");
            scanner.nextLine();
            game.showPlayerHands();

            System.out.println("Ready to see the winner???");
            System.out.println("Press Enter to continue.");
            scanner.nextLine();

            game.showPlayerResults();
            System.out.println("Would you like to quit? (q=quit, any other key to play again)");
            playAgain = !scanner.nextLine().equalsIgnoreCase("q");
        }
    }
}
