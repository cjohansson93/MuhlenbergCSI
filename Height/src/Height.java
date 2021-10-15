/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        03/05/2021
Instructor:  Dr. Helsing
Description: This program takes the height of 8 people in inches and finds the average
             then prints out the heights and the average.
*/

import java.util.Scanner;

public class Height {
    public static void main(String[] args) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // identifier declarations
        final int people = 8;            // people
        int[] heights = new int[people]; // 8 slot array for heights
        int totalInches = 0;             // total inches
        double avgInches = 0;               // average inches

        // for loop to take heights to fill in array
        // add heights to a total height
        // and calculate the average height.
        for( int i = 0 ; i < heights.length ; i++) {
            if (i == 0) {
                System.out.println("Enter the height in inches of the first person:");
            }
            else if (i == 7) {
                System.out.println("Enter the height in inches of the last person:");
            }
            else {
                System.out.println("Enter the height in inches of the next person:");
            }
            heights[i] = keyboard.nextInt();
            totalInches += heights[i];
            avgInches = totalInches / (double)people;
        }

        // for loop to print out heights and average
        for( int i = 0 ; i < heights.length ; i++) {
            if (i == 0) {
                System.out.print("The heights of the people are: \n" + heights[i] + ", ");
            }
            else if (i < 7) {
                System.out.print( heights[i] + ", ");
            }
            else {
                System.out.print("and " + heights[i] + " inches.\n" +
                                   "They have an average height of " + avgInches + " inches.");
            }
        }
    }
}
