/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        02/26/2021
Instructor:  Dr. Helsing
Description: This program calculates the floating point average of
             a series of user specified grades.
*/

import java.util.Scanner; //to be able to read from the keyboard

public class Grade {
    public static void main (String [] args) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // identifier declarations
        double grade = 0; // sum of all grades
        double gradeAvg = 0; // stores final grade average.
        int gradeCounter = 0; // keeps track of how many grades were entered
        char noMoreGrades; //[Y]/[y] to enter another grade, else breaks loop

        // do-while loop collects grades, checks if between 0-100 and
        // breaks if the user doesn't enter [Y]/[y] to enter another grade
        do {
            System.out.println("Enter a grade to average: ");
            grade = keyboard.nextDouble();
            if (grade < 0 || grade > 100) {
                System.out.println("That is an invalid grade!");
                grade = 0;
            }
            else {
                gradeCounter++;
                gradeAvg += grade;
            }
            System.out.println("Do you wish to add another grade, enter [Y]/[y]");
            noMoreGrades = keyboard.next().charAt(0);

        } while (noMoreGrades == 'Y' || noMoreGrades == 'y');

        //Print out of the grade average
        System.out.println("You have a grade average of: " + (gradeAvg/gradeCounter));
    }
}
