/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        05/14/2021
Instructor:  Dr. Helsing
Description: This program is for creation of Item type objects for use by DataManager.java
*/

public class Item {
    private int itemID;       // The items ID number
    private String itemType;  // The items type (movie,music,book)
    private String itemName;  // The item's name
    private String itemGenre; // The item's genre
    private int itemCopies;   // The number of copies of the same item stored

    // Item constructor
    public Item( int itemID,String itemType, String itemName, String itemGenre, int itemCopies) {
        this.itemID = itemID;
        this.itemType = itemType;
        this.itemName = itemName;
        this.itemGenre = itemGenre;
        this.itemCopies = itemCopies;
    }

    // Getters and Setters

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemGenre() {
        return itemGenre;
    }

    public void setItemGenre(String itemGenre) {
        this.itemGenre = itemGenre;
    }

    public int getItemCopies() {
        return itemCopies;
    }

    public void setItemCopies(int itemCopies) {
        this.itemCopies = itemCopies;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}
