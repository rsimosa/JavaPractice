package auction;

public class Auction {
    
    public String itemName;
    public String itemBid;
    public String itemLocation;
    public String biddersName;
    
    public Auction(String itemName, String itemBid, String itemLocation, String biddersName) {

        this.itemName = itemName;
        this.itemBid = itemBid;
        this.itemLocation = itemLocation;
        this.biddersName = biddersName;
    }
    
}
