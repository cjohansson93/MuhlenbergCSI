/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        04/03/2021
Instructor:  Dr. Helsing
Description: This program acts as a menu generator for book title storage, removal,
             checking and printing of titles. Uses Node.java and Library.java
*/

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // create a LinkedList object to manipulate internal Node with titles
        LinkedList list = new LinkedList();

        // Switch control variable
        int choice = 0;

        // Kills menu when Switch is 5
        while ( choice != 5 ) {

            // Menu controlled by simple number switch
            System.out.println("1. Add book to library");
            System.out.println("2. Check for book in library");
            System.out.println("3. Remove book from library");
            System.out.println("4. Print out library");
            System.out.println("5. Quit and Leave");
            System.out.println("Enter the number corresponding to what you'd like to do: ");
            choice = keyboard.nextInt();

            if (choice == 1 || choice == 2 || choice == 3 || choice == 4|| choice == 5) {
                switch (choice) {
                    case 1: // Add book
                        keyboard.nextLine();
                        System.out.println("What is the name of the book to add:");
                        list.storeTitle(keyboard.nextLine());
                        break;
                    case 2: // Check for book
                        keyboard.nextLine();
                        System.out.println("What is the name of the book to check for:");
                        if (list.findTitle(keyboard.nextLine())) {
                            System.out.println("The book is in the library");
                        }
                        else {
                            System.out.println("That book is not in the library");
                        }
                        break;
                    case 3: // Remove book
                        keyboard.nextLine();
                        System.out.println("What is the name of the book to remove:");
                        if (list.removeTitle(keyboard.nextLine())) {
                            System.out.println("The book is now removed");
                        }
                        else {
                            System.out.println("That book is no longer in the library");
                        }
                        break;
                    case 4: // Print all books
                        list.printTitle();
                        break;
                    case 5: // End program
                        System.out.println("Good bye.");
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
