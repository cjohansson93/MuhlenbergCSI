/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        02/18/2021
Instructor:  Dr. Helsing
Description: This program calculates the volume of a sphere, cylinder or cone
*/

import java.util.Scanner; //to be able to read from the keyboard
import java.lang.Math; //needed to do powers

public class Volume {
    public static void main (String [] args) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // identifier declarations
        int choice; // number representing declared shape
        double volume; // volume of shape
        double height; // height of shape
        double radius; // radius of shape
        double pi = 3.1415; //pi

        // display prompt and get input for sides
        System.out.print("To calculate the volume enter the number of the desired shape. \n");
        System.out.print("1: Sphere \n");
        System.out.print("2: Cylinder \n");
        System.out.print("3: Cone \n");
        System.out.print("What is your choice? ");
        choice = keyboard.nextInt();

        // calculations dependent on choice of shape & print out of results
        if (choice == 1) {
            System.out.println("What is the radius of the sphere?");
            radius = keyboard.nextDouble();

            volume = ( 4.0/3 ) * pi * Math.pow(radius, 3);

            System.out.println("The sphere has a volume of: " + volume);
        }
        else if (choice == 2) {
            System.out.println("What is the radius of the cylinder?");
            radius = keyboard.nextDouble();
            System.out.println("What is the height of the cylinder?");
            height = keyboard.nextDouble();

            volume = height * pi * Math.pow(radius, 2);

            System.out.println("The cylinder has a volume of: " + volume);
        }
        else if (choice == 3) {
            System.out.println("What is the radius of the cone?");
            radius = keyboard.nextDouble();
            System.out.println("What is the height of the cone?");
            height = keyboard.nextDouble();

            volume = (height / 3) * pi * Math.pow(radius, 2);

            System.out.println("The cone has a volume of: " + volume);
        }
        else {
            System.out.println("That is not a valid entry. Goodbye.");
        }
    }
}