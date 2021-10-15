/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        03/12/2021
Instructor:  Dr. Helsing
Description: This program alphabetizes a character array and prints out iterations
             as it makes progress, and final iteration count.
*/

import java.util.Scanner;

public class Sorted {
    public static void main(String[] args) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // store letters in character array
        // call sorting method
        // display sorted letters and how many iterations to sort
        char[] letters = {'b','f','a','z','m','g'};
        int iterations = bubbleSort(letters);
        System.out.println("The sorted letters " + new String(letters) + "\ntook " + iterations + " iterations to sort.");

    }

    // method takes char array, sorts alphabetically and returns number of sorts.
    public static int bubbleSort(char[] letters) {
        boolean didSort = true; // used as a check for while loop
        int sorts = 0;  // goes up 1 everytime a sorting iteration is done
        while (didSort) {
            didSort = false;
            for (int i = 0; i < letters.length - 1; i++) { // swaps letters based on ASCII value
                if (letters[i] > letters[i + 1]) {
                    char swap1 = letters[i];
                    char swap2 = letters[i + 1];
                    letters[i] = swap2;
                    letters[i + 1] = swap1;
                    didSort = true;
                }
            }
            System.out.println(new String(letters)); // print out of every iteration
            sorts += 1;
        }
        return sorts;
    }
}