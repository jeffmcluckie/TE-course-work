package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        // Create a Reserve Auction
        System.out.println("Creating a new reserve auction for a cat figurine");
        Auction catAuction = new ReserveAuction("Cat Figurine", 10);

        //Note I can't call the setReservePrice setter on a generic Auction variable
        // myAuction.setReservePrice(10); // DOES NOT WORK!

        System.out.println("Placing a bid for $2 from Joe.");
        catAuction.placeBid(new Bid("Joe", 2));

        System.out.println("Placing a bid for 11 from Julie.");
        catAuction.placeBid(new Bid("Julie", 11));

        System.out.println("Placing a bid for 15 from Sam.");
        catAuction.placeBid(new Bid("Sam", 15));

        System.out.println("All bids: " + catAuction.getAllBids());


        System.out.println("Auction was won by...");
        Bid winner = catAuction.getHighBid();
        System.out.format("%s with a bid of %d", winner.getBidder(), winner.getBidAmount());


        System.out.println("New buyout auction for Fruits Basket sticker");
        Auction fbSticker = new BuyoutAuction("Fruits Basket Sticker", 10);

        System.out.println("Placing a bid from Abby for 3");
        fbSticker.placeBid(new Bid("Abby", 3));

        System.out.println("Placing a bid from Fred for 5");
        fbSticker.placeBid(new Bid("Fred", 5));

        System.out.println("Current winning bid is..." + fbSticker.getHighBid());

        System.out.println("Placing a bid from Kyo for 10");
        fbSticker.placeBid(new Bid("Kyo", 10));

        System.out.println("Current winning bid is..." + fbSticker.getHighBid());

        fbSticker.placeBid(new Bid("Christy", 8));
        System.out.println("Current winning bid is..." + fbSticker.getHighBid());

        fbSticker.placeBid(new Bid("Chris", 18));
        System.out.println("Current winning bid is..." + fbSticker.getHighBid());
    }
}
