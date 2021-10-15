/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        05/14/2021
Instructor:  Dr. Helsing
Description: This program takes in a txt file with movie, music or book information, and stores it in an interactive storage.
*/

import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) throws FileNotFoundException {

        DataManager manager = new DataManager();

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        boolean quit = false;
        while ( !quit ) {
            // Menu controlled by simple number switch.
            System.out.println("-------------------------Menu------------------------");
            System.out.println("1. Check-out an item");
            System.out.println("2. Check-in an item");
            System.out.println("3. Checking item availability");
            System.out.println("4. List all information for a particular type of item");
            System.out.println("5. Load the inventory file");
            System.out.println("6. Save the inventory file");
            System.out.println("7. Exit the program");
            System.out.println("Enter the number corresponding to what you'd like to do: ");
            int menuChoice = keyboard.nextInt();

            if (menuChoice == 1 || menuChoice == 2 || menuChoice == 3 || menuChoice == 4 || menuChoice == 5 || menuChoice == 6 || menuChoice == 7) {
                switch (menuChoice) {

                    case 1: // Check-out an item
                        DataManager.checkOutItem(manager.entireInventory, manager.books, manager.musics, manager.movies);
                        break;
                    case 2: // Check-in an item
                        DataManager.checkInItem(manager.entireInventory, manager.books, manager.musics, manager.movies);
                        break;
                    case 3: // Checking item availability
                        DataManager.checkForCopies(manager.entireInventory, manager.books, manager.musics, manager.movies);
                        break;
                    case 4: // List all information for a particular type of item
                        DataManager.checkItemType(manager.entireInventory, manager.books, manager.musics, manager.movies);
                        break;
                    case 5: // Load the inventory file
                        DataManager.loadFromFile(manager.entireInventory, manager.books, manager.musics, manager.movies);
                        break;
                    case 6: // Save the inventory file
                        DataManager.saveToFile(manager.entireInventory, manager.books, manager.musics, manager.movies);
                        break;
                    case 7: // Exit the program
                        quit = true;
                        break;
                }
            } else {
                // Check to stop invalid menu inputs
                System.out.println("That is an invalid entry! Try again.'" +
                        "");
            }
        }
    }
}
