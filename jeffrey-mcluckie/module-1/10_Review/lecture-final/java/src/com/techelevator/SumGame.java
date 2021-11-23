package com.techelevator;

import java.util.ArrayList;
import java.util.List;

/*
 * This is a game with 2-4 players. Each player gets 5 cards, then each player sums their cards.
 * Ace counts as 1, Jack as 11, Queen as 12, King as 13. The player with the highest sum wins.
 */
public class SumGame {

    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 4;
    private static final int CARDS_IN_HAND = 5;

    // List of player hands, each hand will be an array of 5 cards
    private List<List<Card>> playerHands;
    private Deck deck;

    // Constructor creates the deck & empty list of player hands to start a game.
    public SumGame() {
        setUpGame();
    }


    public void setUpGame() {
        // make a new deck so we have 52 cards, then shuffle them
        this.deck = new Deck();
        deck.shuffle();
        this.playerHands = new ArrayList<>();
    }

    public void addPlayer() {
        if (playerHands.size() < MAX_PLAYERS) {
            playerHands.add(new ArrayList<Card>());
        }
    }

    public int getPlayerCount() {
        return playerHands.size();
    }

    public void dealCards() {
        // Deal 5 cards - cardCount will be the number of cards in each players hand
        for (int cardCount = 0; cardCount < 5; cardCount++) {
            // to each player sequentially...
            for (int playerNum = 0; playerNum < this.getPlayerCount(); playerNum++) {
                List<Card> hand = playerHands.get(playerNum);
                hand.add( deck.dealOneCard() );
            }
        }
    }

    public void showPlayerHands() {
        for (int playerNum = 0; playerNum < this.getPlayerCount(); playerNum++) {
            List<Card> hand = playerHands.get(playerNum);
            System.out.format("Player %d's hand is: %s%n", playerNum+1, hand);
        }
    }

    public void showPlayerResults() {
        int maxScore = 0;
        int winningPlayer = 0;
        for (int playerNum = 0; playerNum < this.getPlayerCount(); playerNum++) {
            List<Card> hand = playerHands.get(playerNum);
            int total = totalHand(hand);
            System.out.format("Player %d's hand totals to %d points.%n", playerNum+1, total);
            if ( total > maxScore) {
                maxScore = total;
                winningPlayer = playerNum;
            }
        }
        System.out.format("Player %d is the winner with %d points.%n", winningPlayer+1, maxScore);
    }

    // Nothing outside this game class should be able to sum the player's hand
    // This is often called a helper method.
    private int totalHand(List<Card> hand) {
        int sum = 0;
        for( Card card : hand) {
            sum += card.getRank();
        }
        return sum;
    }
}
