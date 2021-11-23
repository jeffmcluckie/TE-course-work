package com.techelevator;

public class Card {
    // Suit is single character
    // H=hearts, D=diamonds, C=clubs, S=spades
    private String suit;

    // Ace = 1, 2-10, Jack=11, Queen=12, King=13
    private int rank;

    // Constructor - setting properties when created
    public Card(String suit, int rank) {
        this.rank = rank;
        this.suit = suit;
    }

    /*
     * By only providing getter methods, the properties cannot be
     * changed outside of the Card class.
     */
    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    // Get a String representation of our Card

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", rank=" + rank +
                '}';
    }
}
