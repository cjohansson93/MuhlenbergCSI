/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        02/18/2021
Instructor:  Dr. Helsing
Description: This program tests what the furthest planet is
             (Hint: Neptune)
*/

import java.util.Scanner; //to be able to read from the keyboard

public class Switch {
    public static void main (String [] args) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // identifier declarations
        int choice; // number representing choice of planet

        // display prompt and get input for planet choice
        System.out.println("Welcome to the 111 quiz. Please choose the correct answer to the following question: ");
        System.out.println("Which planet in our solar system is on average furthest away from the sun? ");
        System.out.println("1: Mercury ");
        System.out.println("2: Jupiter ");
        System.out.println("3: Neptune ");
        System.out.println("4: Saturn ");
        System.out.println("5: Pluto ");
        System.out.print("Please enter your choice (1, 2, 3, 4, or 5): ");

        choice = keyboard.nextInt();

        // print out of results dependent on answer correctness

        switch(choice) {
            case 1:
                System.out.println("That is incorrect! Neptune is the planet farthest away from the sun");
                break;
            case 2:
                System.out.println("That is incorrect! Neptune is the planet farthest away from the sun");
                break;
            case 3:
                System.out.println("That is correct! Neptune is the planet farthest away from the sun");
                break;
            case 4:
                System.out.println("That is incorrect! Neptune is the planet farthest away from the sun");
                break;
            case 5:
                System.out.println("That is incorrect! Pluto is unfortunately not a planet, but a dwarf planet");
                break;
            default:
                System.out.println("That is not a valid choice");
                break;
        }
        System.out.println("Good bye");

    }
}