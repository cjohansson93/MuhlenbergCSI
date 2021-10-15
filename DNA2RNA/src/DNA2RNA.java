/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        03/05/2021
Instructor:  Dr. Helsing
Description: This program takes an input DNA sequence, checks for validity,
             creates RNA version and prints out
*/

import java.util.Scanner;

public class DNA2RNA {
    public static void main(String[] args) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // retrieve a string from user
        String inputDNA = inputSequence();

        // test to see if string only contains A,C,G or T
        boolean goodToGo = typoCheck(inputDNA);

        // End program if string contained invalid characters, if not make RNA and print out all
        if (goodToGo) {
            String inputRNA = sequenceRNA(inputDNA);

            System.out.println("Your DNA sequence of: " + inputDNA
                             + "\nhas a corresponding RNA sequence of: " + inputRNA);
        }
        else {
            System.out.println("That is an invalid DNA sequence! Good bye.");
        }

    }

    public static String inputSequence() {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a string: ");
        return keyboard.nextLine();
    }

    public static boolean typoCheck(String inputDNA) {
        boolean isClear = true;
        for( int i = 0 ; i < inputDNA.length() ; i++) {
            if (inputDNA.charAt(i) != 'A' && inputDNA.charAt(i) != 'C'
                                          && inputDNA.charAt(i) != 'G'
                                          && inputDNA.charAt(i) != 'T') {
                isClear = false;
                break;
            }
        }
        return isClear;
    }

    public static String sequenceRNA(String inputDNA) {
        return inputDNA.replace("T","U");
    }

}