/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        02/26/2021
Instructor:  Dr. Helsing
Description: This program uses methods to calculate the side area,
             base area and total area of a right cylinder.
*/

import java.util.Scanner;
import java.lang.Math;

public class Cylinder {
    public static void main(String[] args) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // identifier declarations
        double height;    // height
        double radius;    // length of the radius
        double base_area; // area of base
        double side_area; // area of side

        // Collect user input for radius and height of cylinder
        System.out.println("Enter the length of the radius for the right cylinder in feet: ");
        radius = keyboard.nextDouble();
        System.out.println("Enter the height of the right cylinder in feet: ");
        height = keyboard.nextDouble();

        base_area = calcBaseArea(radius);
        System.out.println("Base surface area of the right cylinder is "
                            + base_area + " square feet.");

        side_area = calcSideArea(radius,height);
        System.out.println("Side surface area of the right cylinder is "
                + side_area + " square feet.");

        prntsurfArea(base_area,side_area);
    }

    // This method calculates the area of ONE of the two circles that make of the base/top of the cylinder
    public static double calcBaseArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    // This method calculates the side surface area of the cylinder
    public static double calcSideArea(double radius,double height) {
        return height * (2 * Math.PI * radius);
    }

    // This method takes the the total surface area and prints it out
    public static void prntsurfArea(double base_area,double side_area) {
        System.out.println("The total surface area of the right cylinder is "
                + (2 * base_area + side_area) + " square feet.");
    }
}
