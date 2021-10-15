/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        03/26/2021
Instructor:  Dr. Helsing
Description: This program acts as a storage location for information pertaining to a product and is used
             in the program Ordersystem
*/

import java.util.Scanner;

public class Manager {
    public static void main(String[] args) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        Warehouse homeOfTheGoods = new Warehouse( 0 );

        int choice = 0;

        while ( choice != 4 ) {

            // Menu controlled by simple number switch
            System.out.println("1. Add goods to warehouse");
            System.out.println("2. Remove goods from warehouse");
            System.out.println("3. Check current warehouse goods quantity");
            System.out.println("4. Quit and Leave");
            System.out.println("Enter the number corresponding to what you'd like to do: ");
            choice = keyboard.nextInt();

            if (choice == 1 || choice == 2 || choice == 3 || choice == 4) {
                switch (choice) {
                    case 1: // Add goods
                        homeOfTheGoods.addGoods();
                        break;
                    case 2: // Remove goods
                        homeOfTheGoods.removeGoods();
                        break;
                    case 3: // Status of current goods
                        System.out.println("Current goods quantity: " + homeOfTheGoods.getWarehouseGoods());
                        break;
                    case 4: // End program
                        break;
                }
            }
            else {
                // Check to stop invalid menu inputs
                System.out.println("That is an invalid entry! Try again.'" +
                        "");
            }

        }
    }
}

