package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class CardGame {

    public static void main(String[] args) {
        System.out.println("Welcome to my fun with cards");

        // Test some cards
        Card h1 = new Card("H", 1);
        Card h2 = new Card("H", 2);

        // Because the Card class has a toString method I can do the following
        System.out.println("First card: " + h1);

        System.out.println("What is the rank on card h1: " + h1.getRank());
        System.out.println("What is the suit on card h1: " + h1.getSuit());

        // Make a deck of cards
        Deck gameDeck = new Deck();
        System.out.println("The deck is: " + gameDeck);

        System.out.format("We have %d cards in the deck.%n", gameDeck.getCardCount());

        gameDeck.shuffle();

        System.out.println("The deck is now:" + gameDeck);

        System.out.println("Get a card from the deck...");
        Card card = gameDeck.dealOneCard();
        System.out.println("Got the card: " + card);
        System.out.format("The deck now has %d cards.%n", gameDeck.getCardCount());

        List<Card> player1Hand = new ArrayList<>();
        List<Card> player2Hand = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            player1Hand.add( gameDeck.dealOneCard() );
            player2Hand.add( gameDeck.dealOneCard() );
        }

        System.out.println("Player 1's hand is " + player1Hand);
        System.out.println("Player 2's hand is " + player2Hand);

        System.out.format("The deck now has %d cards.%n", gameDeck.getCardCount());
    }
}
