/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        10/08/2021
Instructor:  Professor Silveyra
Description: The tester file for a generic doubly LinkedList using a switch menu
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class TesterSortedDoubleList {
    public static void main(String[] args) {

        // Control variable for switch
        int choice = 0;
        // Control variable for String or Integer choice
        int type = 0;
        // Integer and String doubly LinkedList
        SortedDoubleList<String> stringList = new SortedDoubleList<String>();
        SortedDoubleList<Integer> intList = new SortedDoubleList<Integer>();

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Menu loop
        while ( choice != 1 && choice != 2 ) {

            // Menu controlled by simple number switch
            System.out.println("----------------------- Type Menu ------------------------");
            System.out.println("1. String");
            System.out.println("2. Integer");
            System.out.println("Enter the number corresponding to data type to be entered: ");
            choice = keyboard.nextInt();

            if (choice == 1 || choice == 2) {
                switch (choice) {
                    case 1: // Make String List
                        type = 1;
                        break;
                    case 2: // Make Integer List
                        type = 2;
                        break;
                }
            }
            else {
                // Check to stop invalid menu inputs
                System.out.println("That is an invalid entry! Try again.'" +
                        "");
            }

        }

        // Resetting switch variable for new switch
        choice = 0;

        // Store user input, either String or Integer
        String valueString;
        int valueInt;

        // Loop for main menu
        while ( choice != 10 ) {

            // Menu controlled by simple number switch
            System.out.println("----------------------- Main Menu ------------------------");
            System.out.println("1.  Insert element");
            System.out.println("2.  Print list size");
            System.out.println("3.  Is the list empty?");
            System.out.println("4.  Print first element");
            System.out.println("5.  Print last element");
            System.out.println("6.  Count elements with a particular value");
            System.out.println("7.  Remove first");
            System.out.println("8.  Remove last");
            System.out.println("9.  Remove all elements with a particular value");
            System.out.println("10. Quit and leave");
            System.out.println("Enter the number corresponding to what you'd like to do: ");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            // Each switch case is separated into processing into the String or Integer LinkedList
            if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6 || choice == 7 || choice == 8 || choice == 9 || choice == 10) {
                switch (choice) {
                    case 1: // Insert element
                        if (type == 1){
                            System.out.println("Enter the String to insert: ");
                            valueString = keyboard.next();
                            stringList.insert(valueString);
                            keyboard.nextLine();
                        }
                        else{
                            System.out.println("Enter the Integer to insert: ");
                            // Catches if the user tries to input the wrong data type
                            try{
                                valueInt = keyboard.nextInt();
                            }catch (InputMismatchException e){
                                keyboard.nextLine();
                                System.out.println("No Integer detected, returning to main menu");
                                break;
                            }
                            intList.insert(valueInt);
                        }
                        break;
                    case 2: // Print list size
                        if (type == 1){
                            System.out.println("The list size is "+stringList.size());
                        }
                        else {
                            System.out.println("The list size is "+intList.size());
                        }
                        break;
                    case 3: // Is the list empty?
                        if (type == 1){
                            if (stringList.empty()){
                                System.out.println("The list is empty");
                            }
                            else {
                                System.out.println("The list is not empty");
                            }
                        }
                        else {
                            if (intList.empty()){
                                System.out.println("The list is empty");
                            }
                            else {
                                System.out.println("The list is not empty");
                            }
                        }
                        break;
                    case 4: // Print first element
                        if (type == 1){
                            if (stringList.front() == null){
                                System.out.println("The list is empty");
                            }
                            else{
                                System.out.println("The first element is "+stringList.front());
                            }
                        }
                        else {
                            if (intList.front() == null){
                                System.out.println("The list is empty");
                            }
                            else{
                                System.out.println("The first element is "+intList.front());
                            }
                        }
                        break;
                    case 5: // Print last element
                        if (type == 1){
                            if (stringList.back() == null){
                                System.out.println("The list is empty");
                            }
                            else{
                                System.out.println("The last element is "+stringList.back());
                            }
                        }
                        else {
                            if (intList.back() == null){
                                System.out.println("The list is empty");
                            }
                            else{
                                System.out.println("The last element is "+intList.back());
                            }
                        }
                        break;
                    case 6: // Count elements with a particular value
                        if (type == 1){
                            System.out.println("Enter the String to count in the list: ");
                            valueString = keyboard.next();
                            System.out.println("There are "+stringList.count(valueString)+" that match that input");
                            keyboard.nextLine();
                        }
                        else{
                            System.out.println("Enter the Integer to count in the list: ");
                            // Catches if the user tries to input the wrong data type
                            try{
                                valueInt = keyboard.nextInt();
                            }catch (InputMismatchException e){
                                keyboard.nextLine();
                                System.out.println("No Integer detected, returning to main menu");
                                break;
                            }
                            System.out.println("There are "+intList.count(valueInt)+" that match that input");
                        }
                        break;
                    case 7: // Remove first
                        if (type == 1){
                            String data = stringList.pop_front();
                            // Informs the user if the list is empty
                            if (data == null){
                                System.out.println("The list is empty, there is nothing to remove");
                            }
                            else {
                                System.out.println("The first element \""+data+"\" has been removed");
                            }
                        }
                        else {
                            Integer data = intList.pop_front();
                            // Informs the user if the list is empty
                            if (data == null){
                                System.out.println("The list is empty, there is nothing to remove");
                            }
                            else {
                                System.out.println("The first element \""+data+"\" has been removed");
                            }
                        }
                        break;
                    case 8: // Remove last
                        if (type == 1){
                            String data = stringList.pop_back();
                            // Informs the user if the list is empty
                            if (data == null){
                                System.out.println("The list is empty, there is nothing to remove");
                            }
                            else {
                                System.out.println("The last element \""+data+"\" has been removed");
                            }
                        }
                        else {
                            Integer data = intList.pop_back();
                            // Informs the user if the list is empty
                            if (data == null){
                                System.out.println("The list is empty, there is nothing to remove");
                            }
                            else {
                                System.out.println("The last element \""+data+"\" has been removed");
                            }
                        }
                        break;
                    case 9: // Remove all elements with a particular value
                        if (type == 1){
                            System.out.println("Enter the String to erase: ");
                            valueString = keyboard.next();
                            System.out.println("The String "+"\""+valueString+"\" was erased "+stringList.erase(valueString)+" times");
                            keyboard.nextLine();
                        }
                        else{
                            System.out.println("Enter the Integer to erase: ");
                            // Catches if the user tries to input the wrong data type
                            try{
                                valueInt = keyboard.nextInt();
                            }catch (InputMismatchException e){
                                keyboard.nextLine();
                                System.out.println("No Integer detected, returning to main menu");
                                break;
                            }
                            System.out.println("The Integer "+"\""+valueInt+"\" was erased "+intList.erase(valueInt)+" times");
                        }
                        break;
                    case 10: // End program
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
