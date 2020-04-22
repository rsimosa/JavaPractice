package auction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AuctionModel {

    ArrayList<Auction> itemsList = new ArrayList<>();

    public AuctionModel() {
    }

    public void readFileItemsAvailable() {
        try {
            Scanner itemsAvailableFile = new Scanner(new File("itemsAvailable.txt"));

            while (itemsAvailableFile.hasNext()) {

                String stringRead = itemsAvailableFile.nextLine();
                Scanner parse = new Scanner(stringRead);
                parse.useDelimiter(" ");

                String iName = parse.next();
                String iBid = parse.next();
                String iLocation = parse.next();
                String bName = parse.next();

                itemsList.add(new Auction(iName, iBid, iLocation, bName));
            }
        } catch (FileNotFoundException ex) {
            System.out.print(ex);
        }
    }

    public ArrayList getArrayListItemsList() {
        return itemsList;
    }

    public String getItemName(int index) {
        return itemsList.get(index).itemName;
    }

    public String getItemBid(int index) {
        return itemsList.get(index).itemBid;
    }

    public String getItemLocation(int index) {
        return itemsList.get(index).itemLocation;
    }

    public String getBiddersName(int index) {
        return itemsList.get(index).biddersName;
    }

    public void setBiddersName(int index, String name) {
        itemsList.get(index).biddersName = name;
    }

    public void setItemBid(int index, String amount) {
        itemsList.get(index).itemBid = amount;
    }

    public int getArrayListItemsSize() {
        return itemsList.size();
    }
}
