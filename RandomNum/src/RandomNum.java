/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        02/26/2021
Instructor:  Dr. Helsing
Description: This program calculates the sum of all even numbers between two random numbers.
*/

import java.util.Scanner; //to be able to read from the keyboard
import java.util.Random; //generate random numbers

public class RandomNum {
    public static void main (String [] args) {

        // create a Scanner object to read from the keyboard & Random object
        Scanner keyboard = new Scanner(System.in);
        Random rand = new Random();

        // identifier declarations
        int firstRan; // First random number between 1-10 inclusively
        int secondRan; // Second random number between 11-20 inclusively
        int evenSum = 0; //Sum of even numbers

        // generation of two random numbers
        firstRan = rand.nextInt(10) + 1;
        secondRan = rand.nextInt(10) + 11;

        // for loop starting from first random number going to second and
        // adding all the even numbers together using modulus to sift them out
        for( int i = firstRan; i <= secondRan; i++) {
            if( i % 2 == 0) {
                evenSum += i;
            }
        }

        //Print out of the random numbers and even sum
        System.out.println("Your random numbers are: " + firstRan + "," + secondRan
                            + " and the sum of their even numbers are " + evenSum);
    }
}
