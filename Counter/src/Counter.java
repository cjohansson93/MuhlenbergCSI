/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        03/05/2021
Instructor:  Dr. Helsing
Description: This program counts the number of digit, letter, whitespaces and
             special characters in a user inputted string.
*/

import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // identifier declarations
        int isDigit = 0;    // digit counter
        int isLetter = 0; // letter counter
        int isWhitespace = 0; // whitespace counter
        int isSpecial = 0; // special char counter

        // retrieve a string from user
        System.out.println("Enter a string: ");
        String inputLine = keyboard.nextLine();

        // for loop to iterate through each char in string
        // embedded if statements to catch each char type and increment
        // their counter
        for( int i = 0 ; i < inputLine.length() ; i++) {
            if (Character.isDigit(inputLine.charAt(i))) {
                isDigit++;
            } else if (Character.isLetter(inputLine.charAt(i))) {
                isLetter++;
            } else if (Character.isWhitespace(inputLine.charAt(i))) {
                isWhitespace++;
            } else {
                isSpecial++;
            }
        }


        // Print out of number of letters, numbers, spaces and specials
        System.out.println("Your string has "+ isLetter + " letters, " + isDigit + " numbers, "
                            + isWhitespace + " whitespaces and " + isSpecial + " special characters.");

    }
}
