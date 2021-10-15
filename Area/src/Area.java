/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        02/08/2021
Instructor:  Dr. Helsing
Description: This program calculates the area of a rectangle
*/

import java.util.Scanner; //to be able to read from the keyboard

public class Area {
    public static void main (String [] args) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // identifier declarations
        double width; // width of the rectangle in inches
        double height; // height of the rectangle in inches
        double area; // area of the rectangle in square inches

        // display prompt and get input for sides
        System.out.print("How many inches is the width of the rectangle? ");
        width = keyboard.nextDouble();

        System.out.print("How many inches is the height of the rectangle? ");
        height = keyboard.nextDouble();

        // calculations
        area = width * height;

        // display results depending on if square or rectangle
        if (width == height) {
            System.out.println("The square is " + area + " square inches.");
        }
        else {
            System.out.println("The rectangle is " + area + " square inches.");
        }
    }
}

