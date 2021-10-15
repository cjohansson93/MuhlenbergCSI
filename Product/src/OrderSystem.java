/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        03/26/2021
Instructor:  Dr. Helsing
Description: This program allows a user to name a product and order a specified quantity of said product.
             Product order is then printed out.
*/

import java.util.Scanner;

public class OrderSystem {
    public static void main(String[] args) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Create Product Object
        Product onlyProduct = new Product();
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
        System.out.format("Total order cost: $%.2f", onlyProduct.getTotalOrderCost());

    }

    /**
     * This method is used to set the total cost of a Product class object using
     * the objects per unit price times its ordered units.
     *
     * @param onlyProduct Takes Product object onlyProduct, product has name,price,quantity and total cost
     */
    private static void calcTotal( Product onlyProduct ) {
        onlyProduct.setTotalOrderCost(onlyProduct.getProductUnits() * onlyProduct.getPerUnitPrice());
    }
}
