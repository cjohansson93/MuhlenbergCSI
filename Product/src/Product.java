/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        03/26/2021
Instructor:  Dr. Helsing
Description: This program acts as a storage location for information pertaining to a product and is used
             in the program Ordersystem
*/

public class Product {

    private String productName; // product's name
    private int productUnits; // how many of the products to be ordered
    private double perUnitPrice; // price per unit of product $
    private double totalOrderCost; // total order cost $


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
}
