/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        03/26/2021
Instructor:  Dr. Helsing
Description: This program allows a user order a number of products, to name the products
             and order a specified quantity of that product.
             Individual product orders are then printed out, along with a grand total.
             Products are made using SmartProduct file.
*/

import java.util.Scanner;

public class SmartOrderSystem {
    public static void main(String[] args) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Create SmartProduct object array of user entered size
        System.out.println("How many products do you wish to order?:");
        SmartProduct[] products = new SmartProduct[keyboard.nextInt()];
        keyboard.nextLine();

        // Loop to fill products with user entered name and quantity.
        // ID number starts at 1 and goes up, all unit prices are $9.99
        for(int i = 0; i < products.length; i++) {
            System.out.println("What is the name of the product?:");
            String holdName = keyboard.nextLine();
            System.out.println("How many units of this product are being ordered?:");
            int holdUnit= keyboard.nextInt();
            keyboard.nextLine();
            products[i] = new SmartProduct(i+1,holdName,holdUnit,9.99);
        }

        // Printing out of individual products info: name,ID,units,unit price,total
        System.out.println("Order breakdown and grand total:");
        for (int i = 0; i < products.length; i++) {
            System.out.println("\nProduct: " + products[i].getProductName());
            System.out.println("Product ID: " + products[i].getProductID());
            System.out.println("Number of product units: " + products[i].getProductUnits());
            System.out.format("Product unit price: $%.2f", products[i].getPerUnitPrice());
            System.out.format("\nProduct order total: $%.2f", products[i].getTotalOrderCost());
            System.out.println("");

        }
        // Grand total of whole order
        System.out.format("\nGrand Total of all products: $%.2f", calcTotal(products));

        /*
        // Create Product Object
        SmartProduct onlyProduct = new SmartProduct();
        // Get Product name
        System.out.println("What is the name of the product?: ");
        onlyProduct.setProductName(keyboard.nextLine());
        // Get Product unit count
        System.out.println("How many units are to be ordered?: ");
        onlyProduct.setProductUnits(keyboard.nextInt());
        // Set Product unit cost
        onlyProduct.setPerUnitPrice(9.99);
        // Set Product total cost
        calcTotal(onlyProduct);

        // Print out product
        System.out.println("Product order statement:" +
                "\nProduct name: " + onlyProduct.getProductName() +
                "\nProduct price: $" + onlyProduct.getPerUnitPrice() +
                "\nProduct units ordered: " + onlyProduct.getProductUnits());
        System.out.format("Total order cost: $%.2f", onlyProduct.getTotalOrderCost());*/

    }

    /**
     * This method totals up all individual product totals from an array of
     * product objects.
     *
     * @param products array of product objects from which to get individual product
     *                 totals from.
     * @return returns a final grand total of the sum of all product totals
     */
    private static double calcTotal( SmartProduct[] products ) {
        double finalTotal = 0;
        for(int i = 0; i < products.length; i++) {
            finalTotal += products[i].getTotalOrderCost();
        }
        return finalTotal;
    }
}