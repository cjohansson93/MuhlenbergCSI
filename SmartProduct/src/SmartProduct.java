/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        03/26/2021
Instructor:  Dr. Helsing
Description: This file is used to make SmartProduct objects for use by file SmartOrderSystem.
*/

public class SmartProduct {

    // Private variable used as qualities of SmartProduct object
    private String productName; // product's name
    private int productUnits; // how many of the products to be ordered
    private double perUnitPrice; // price per unit of product $
    private double totalOrderCost; // total order cost $
    private int productID; // product's ID number

    // Constructor needs: ID, name, unit amount, unit price
    public SmartProduct( int numID, String name, int numUnits, double unitPrice) {
        this.productName = name;
        this.productUnits = numUnits;
        this.perUnitPrice = unitPrice;
        this.productID = numID;
        this.totalOrderCost = numUnits * unitPrice;

    }


    //Getter and Setters for the various qualities of the product variables
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductUnits() {
        return productUnits;
    }

    public void setProductUnits(int productUnits) {
        this.productUnits = productUnits;
    }

    public double getPerUnitPrice() {
        return perUnitPrice;
    }

    public void setPerUnitPrice(double perUnitPrice) {
        this.perUnitPrice = perUnitPrice;
    }

    public double getTotalOrderCost() {
        return totalOrderCost;
    }

    public void setTotalOrderCost(double totalOrderCost) {
        this.totalOrderCost = totalOrderCost;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
