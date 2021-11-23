/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        10/30/2021
Instructor:  Professor Silveyra
Description: The menu for converting infix to postfix & vice versa,
             also menu to evaluate postfix numerical expressions.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class StackMenu {
    public static void main(String[] args) {

        // Call InfixPostfix constructor and make object
        InfixPostfix i;
        i = new InfixPostfix();

        // Control variable for switch main menu
        int choice = 0;
        // Control variable for switch postfix to infix submenu
        int type = 0;
        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Menu loop
        while ( choice != 3 ) {

            // Menu controlled by simple number switch
            System.out.println("---------------------- Main Menu -----------------------");
            System.out.println("1. Convert infix to postfix");
            System.out.println("2. Convert postfix to infix");
            System.out.println("3. Exit");
            System.out.println("Enter the number corresponding to the desired operation: ");

            // try catch for inputting the wrong type of entry
            try {
                choice = keyboard.nextInt();
            }catch (InputMismatchException e){
                choice = 0;
                keyboard.nextLine();
            }

            if (choice == 1 || choice == 2 || choice == 3) {
                switch (choice) {
                    case 1: // Convert infix to postfix
                        keyboard.nextLine();
                        System.out.println("Please enter the infix you'd like to convert to postfix: ");
                        System.out.println(i.infixToPostfix(keyboard.nextLine()));
                        break;
                    case 2: // Enter postfix submenu
                        // Menu loop
                        while ( type != 3 ) {

                            // Menu controlled by simple number switch
                            System.out.println("---------------- Postfix to Infix Menu -----------------");
                            System.out.println("1. Convert postfix to infix");
                            System.out.println("2. Evaluate postfix expression");
                            System.out.println("3. Exit to main menu");
                            System.out.println("Enter the number corresponding to the desired operation: ");

                            // try catch for inputting the wrong type of entry
                            try {
                                type = keyboard.nextInt();
                            }catch (InputMismatchException e){
                                type = 0;
                                keyboard.nextLine();
                            }

                            if (type == 1 || type == 2) {
                                switch (type) {
                                    case 1: // Convert postfix to infix
                                        keyboard.nextLine();
                                        System.out.println("Please enter the postfix you'd like to convert to infix: ");
                                        System.out.println(i.postfixToInfix(keyboard.nextLine(), false));
                                        break;
                                    case 2: // evaluate postfix expression
                                        keyboard.nextLine();
                                        System.out.println("Please enter the postfix you'd like to evaluate: ");
                                        System.out.println(i.postfixToInfix(keyboard.nextLine(), true));
                                        break;
                                    case 3: // Exit submenu
                                        type = 3;
                                        break;
                                }
                            }
                            else {
                                // Check to stop invalid menu inputs
                                System.out.println("That is an invalid entry! Try again.'" +
                                        "");
                            }

                        }
                        type = 0;
                        break;
                    case 3: // Exit program
                        choice = 3;
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
