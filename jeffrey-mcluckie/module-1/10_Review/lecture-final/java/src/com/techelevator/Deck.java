package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cardList;

    // Default make a normal 52 card deck
    public Deck() {
        this.cardList = new ArrayList<Card>();

        // have 4 suits
        String[] suitArray = {"H", "D", "C", "S"};
        for (String suit : suitArray ) {
            for (int rank = 1; rank < 14; rank++) {
                Card newCard = new Card(suit, rank);
                this.cardList.add(newCard);
            }
        }
    }

    public int getCardCount() {
        return this.cardList.size();
    }

    public void shuffle() {
        Collections.shuffle(this.cardList);
    }

    // Return the first card unless the deck is empty in which case will return null
    public Card dealOneCard() {
        if (this.getCardCount() > 0){
            return this.cardList.remove(0);
        }
        return null;
    }

    // Get a String display of my deck
    @Override
    public String toString() {
        return "Deck{" +
                "cardList=" + cardList +
                '}';
    }
}
