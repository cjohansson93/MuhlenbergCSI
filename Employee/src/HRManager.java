/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        04/30/2021
Instructor:  Dr. Helsing
Description: Obtains, stores and prints out user entered employee information of supervisors and basic workers.
             As well as the total pay of all employees combined
*/

import java.util.Scanner;

public class HRManager {

    public static void main(String[] args) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Array of superclass Employee of user input size, # of employees
        Employee[] staff;
        System.out.println("Welcome.");
        System.out.println("How many employees are to be added?: ");
        staff = new Employee[keyboard.nextInt()];

        // Loop to iterate through array objects
        for (int i = 0; i < staff.length; i++) {

            // Temporary holders to be filled and used in object creation
            String name;
            int id;
            double payRate;
            int level;
            int shift;

            // Menu controlled by simple number switch, for use in making either a supervisor or worker
            System.out.println("Is the information to be entered a supervisor or worker?");
            System.out.println("1. Supervisor");
            System.out.println("2. Worker");
            System.out.println("Enter the number corresponding to employee type: ");
            int menuChoice = keyboard.nextInt();

            if ( menuChoice == 1 || menuChoice == 2){
                switch (menuChoice) {

                    case 1: // Create supervisor object at current index
                        keyboard.nextLine();
                        System.out.println("What is the supervisors name?: ");
                        name = keyboard.nextLine();
                        System.out.println("What is the supervisors ID?: ");
                        id = keyboard.nextInt();
                        System.out.println("What is the supervisors pay rate?: ");
                        payRate = keyboard.nextDouble();
                        System.out.println("What is the supervisors level?: ");
                        level = keyboard.nextInt();

                        staff[i] = new Supervisor(name,id,level,payRate);
                        break;
                    case 2: // Create BasicWorker object at current index
                        keyboard.nextLine();
                        System.out.println("What is the workers name?: ");
                        name = keyboard.nextLine();
                        System.out.println("What is the workers ID?: ");
                        id = keyboard.nextInt();
                        System.out.println("What is the workers pay rate?: ");
                        payRate = keyboard.nextDouble();
                        System.out.println("What is the workers shift?: ");
                        shift = keyboard.nextInt();

                        staff[i] = new BasicWorker(name,id,shift,payRate);
                        break;
                }
            }
            else {
                // Check to stop invalid menu inputs
                System.out.println("That is an invalid entry! Try again.'" +
                        "");
                // Back track index if the entry at that index was an invalid input
                i--;
            }
        }

        // List off employees
        listEmployees(staff);

        // Print out total pay of all employees combined
        System.out.println("\nTotal pay for all employees: $" + calcTotalPay(staff));
    }

    /**
     * Calculates the total pay combined of all employees
     *
     * @param staff Employee class array containing objects with pay methods
     * @return total pay combined of all employees
     */
    private static double calcTotalPay( Employee[] staff) {

        // Holds sum of all employees pay
        double totalPay = 0;

        // Iterate through each employee, get pay and add to total
        for (int i = 0; i < staff.length; i++) {

            totalPay += staff[i].calcPay(40);

        }
        // return total pay
        return totalPay;
    }

    /**
     * Lists off employee information, dependant on employee type, supervisor or basic worker
     * the output will vary.
     *
     * @param staff Employee class array containing objects with characteristic information
     */
    private static void listEmployees( Employee[] staff) {

        // Iterate through each employee object
        for (int i = 0; i < staff.length; i++) {

            // Determine if the object is of the Supervisor class variety
            if (staff[i] instanceof Supervisor) {
                System.out.println("");
                System.out.println("Name: " + staff[i].getEmployeeName());
                System.out.println("ID: " + staff[i].getEmployeeID());
                System.out.println("Pay Rate: $" + ((Supervisor) staff[i]).getSupervisorPayRate());
                System.out.println("Level: " + ((Supervisor) staff[i]).getSupervisorLevel());
            }
            // Determine if the object is of the BasicWorker class variety
            else {
                System.out.println("");
                System.out.println("Name: " + staff[i].getEmployeeName());
                System.out.println("ID: " + staff[i].getEmployeeID());
                System.out.println("Pay Rate: $" + ((BasicWorker) staff[i]).getWorkerPayRate());

                // Turning integer representation of shift into a text one
                if (((BasicWorker) staff[i]).getWorkerShift() == 1) {
                    System.out.println("Shift: Day Shift");
                }
                else {
                    System.out.println("Shift: Night Shift");
                }
            }
        }
    }
}
