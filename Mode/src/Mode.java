/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        03/12/2021
Instructor:  Dr. Helsing
Description: This program makes a user sized 2D array filled with random numbers 0-10, displays it,
             then finds the mode(s) and prints those as well.
*/

import java.util.Scanner;
import java.util.Random;

public class Mode {
    public static void main(String[] args) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // create a Random object to create random numbers
        Random rand = new Random();

        // how many rows and columns for rand2DArray
        System.out.println("How many rows in the array?");
        int rows = keyboard.nextInt();
        System.out.println("How many columns in the array?");
        int columns = keyboard.nextInt();

        // array with random numbers 0-10 inclusively
        int[][] rand2DArray = new int[rows][columns] ;

        // array to keep track of number frequency in rand2DArray
        int[] frequencyArray = new int[11];

        // for loop to fill in rand2DArray with random number 0-10
        // and increment frequencyArray by one at each index that matches the random number.
        // Prints rand2DArray into table format
        System.out.println("Numbers in array:");
        for( int row = 0 ; row < rand2DArray.length ; row++) {

            for( int col = 0 ; col < rand2DArray[row].length ; col++) {
                rand2DArray[row][col] = rand.nextInt(11);
                frequencyArray[rand2DArray[row][col]] += 1;
                System.out.print("\t" + rand2DArray[row][col]);
            }
            System.out.print("\n");
        }

        // for loop to find the mode
        int theMode = 0;
        for( int i = 0 ; i < frequencyArray.length ; i++) {
            if (theMode <= frequencyArray[i]) {
                theMode = frequencyArray[i];
            }
        }

        // for loop to print out individual mode(s) as they correspond to index
        System.out.print("The mode(s) are: ");
        for( int i = 0 ; i < frequencyArray.length ; i++) {
            if (theMode == frequencyArray[i]) {
                System.out.print(i + "  ");
            }
        }

    }
}