/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        11/23/2021
Instructor:  Professor Silveyra
Description: The menu for Dijkstras algorithm, BFS & DFS, and loading a text file.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class DijkstrasAlgorithm {
    public static void main(String[] args) {
        // Call to Hash and Heap constructors
        AdjacencyList theAdjacencyList;
        Heap theHeap = new Heap();

        // Create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        int choice = 0;
        while ( choice != 4 ) {

            // Menu controlled by simple number switch
            System.out.println("------------------------ Main Menu ------------------------");
            System.out.println("1. Find the shortest path");
            System.out.println("2. DFS and BFS");
            System.out.println("3. Load new file");
            System.out.println("4. Exit Program");
            System.out.println("Enter the number corresponding to operation to be preformed: ");
            try {
                choice = keyboard.nextInt();
            }catch (InputMismatchException e){
                choice = 5;
            }

            if (choice == 1 || choice == 2 || choice == 3 || choice == 4) {
                switch (choice) {
                    case 1: // Hash Menu
                        break;
                    case 2: // Make Integer List
                        break;
                    case 3: // Make Integer List
                        break;
                    case 4: // Exit program
                        break;
                }
            }
            else {
                // Check to stop invalid menu inputs
                keyboard.nextLine();
                System.out.println("That is an invalid entry! Try again.");
            }

        }
    }
}
