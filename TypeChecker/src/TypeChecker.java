/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        04/16/2021
Instructor:  Dr. Helsing
Description: This program uses try catches to determine if entered data is an integer, double, text or whitespaces.
*/

import java.util.Scanner;

public class TypeChecker {

    // Class scoped variables to store integer and double respectively
    private static int isInteger;
    private static double isDouble;

    public static void main(String[] args) {

        // Create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Retrieve user input string
        System.out.println("Enter an Integer, floating point number, words or whitespaces: ");
        String usersNumber = keyboard.nextLine().trim(); // Removed white space on left and right

        // if/else if statements for testing input against being an integer, double, whitespace or text
        // Prints out data and typing statement based on determined type.
        if ( tryInt(usersNumber)) {

            System.out.println(isInteger + " is interpreted as integer data.");
        }

        else if ( tryDouble(usersNumber)) {

            System.out.println(isDouble + " is interpreted as floating point data.");
        }

        else if ( usersNumber.equals("")) {

            System.out.println("You entered only whitespaces.");
        }
        else {

            System.out.println(usersNumber + ". Is interpreted as text data.");
        }
    }

    /**
     *  Method used try-catch to determine if a string is an integer by parsing it
     *
     * @param usersNumber String for integer parsing attempt
     * @return false return for if unable to parse as int, true if able
     */
    private static boolean tryInt( String usersNumber ) {
        try {
            isInteger = Integer.parseInt(usersNumber);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     *  Method used try-catch to determine if a string is a double by parsing it
     *
     * @param usersNumber String for double parsing attempt
     * @return false return for if unable to parse as double, true if able
     */
    private static boolean tryDouble( String usersNumber ) {
        try {
            isDouble = Double.parseDouble(usersNumber);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
