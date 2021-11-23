package com.techelevator;

/**
 * This type of auction allows a buyout price, which anyone can bid at any time
 * to win the auction. If no one meets that price, then the highest bidder wins
 * at the end.
 */
public class BuyoutAuction extends Auction {

    private int buyoutPrice;

    /**
     * Constructor - Must know the item for sale when the Auction is created.
     *       Once created, the item for sale cannot be changed.
     * @param itemForSale
     */
    public BuyoutAuction(String itemForSale) {
        super(itemForSale);
    }

    /**
     * Constructor - Allows a buyout price to be set that will immediately end
     *       the auction if met.
     * @param itemForSale
     * @param buyoutPrice
     */
    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
        System.out.println("Creating instance of BuyoutAuction...");
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isWinningBid = false;
        // Check the winning bin on "this" auction, if it is less than the buyout
        // we are still taking bids.
        if( this.getHighBid().getBidAmount() < this.buyoutPrice ){
            isWinningBid = super.placeBid(offeredBid);
        }

        return isWinningBid;
    }
}
