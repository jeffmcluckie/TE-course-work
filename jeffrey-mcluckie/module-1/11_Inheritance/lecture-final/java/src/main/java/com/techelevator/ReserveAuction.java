package com.techelevator;
/**
 * This type of Auction has a minimum selling price that must be
 * met before the item is sold. If no bid meets the minimum or
 * reserve price by the end of the auction, then the item remains unsold.
 */
public class ReserveAuction extends Auction {

    // Minimum price the item can sell for
    private int reservePrice;

    /**
     * Constructor - Must know the item for sale when the Auction is created.
     *   Once created, the item for sale cannot be changed.
     * @param itemForSale
     */
    // Class constructor - needs to say what item we are auctioning
    // That is required by our parent class
    public ReserveAuction(String itemForSale) {
        // super = parent class constructor
        super(itemForSale);
        System.out.println("Creating reserve auction instance...");
    }

    /**
     * Constructor - Allows us to both set the auction item & set a reserve price.
     * @param itemForSale
     * @param reservePrice
     */
    // Overloaded constructor - takes a different set of input parameters than the one above
    public ReserveAuction(String itemForSale, int reservePrice) {
        super(itemForSale);
        this.reservePrice = reservePrice;
        System.out.println("Creating reserve auction instance...");
    }

    /**
     * Will take a bid for the item on auction, but will not allow the bid to
     * win unless it meets the reserve price.
     *
     * @param offeredBid Bid for the item
     * @return Returns true if this is a winning bid, false otherwise
     */
    @Override // This is an annotation - changing the behavior of a method
              // in your parent class.
    public boolean placeBid(Bid offeredBid) {
        boolean isWinningBid = false;
        if (this.reservePrice < offeredBid.getBidAmount()) {
            isWinningBid = super.placeBid(offeredBid);
        }
        return isWinningBid;
    }

    /**
     * Gets the reserve price for the item
     * @return the reserve price for the item
     */
    public int getReservePrice() {
        return reservePrice;
    }

    /**
     *  Sets the reserve price for the item
     * @param reservePrice
     */
    public void setReservePrice(int reservePrice) {
        this.reservePrice = reservePrice;
    }
}
