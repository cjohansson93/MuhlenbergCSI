/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        02/08/2021
Instructor:  Dr. Helsing
Description: This program calculates the user's gross pay
*/

import java.util.Scanner; //to be able to read from the keyboard

public class PayRollCalculator {
    public static void main (String [] args) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // identifier declarations
        double hours; // number of hours worked
        double rate = 15.0; // hourly pay rate
        double pay; // gross pay

        // display prompt and get input
        System.out.print("How many hours did you work? ");
        hours = keyboard.nextDouble();

        // calculations
        if (hours <= 40) {
            pay = hours * rate;
        }
        else {
            pay = (hours - 40) * (1.5 * rate) + (40 * rate);
        }

        // display results
        System.out.println("You earned $" + pay);
    }
}
