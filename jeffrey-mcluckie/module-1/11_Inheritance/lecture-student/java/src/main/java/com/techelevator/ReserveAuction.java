package com.techelevator;

public class ReserveAuction extends Auction{

    //min price item can sell for
    private int reservePrice;

    public ReserveAuction(String itemForSale) {
        super(itemForSale);
    }
}
