/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        04/30/2021
Instructor:  Dr. Helsing
Description: Stores supervisor's level, pay rate and method to calculate pay. Extends the super class Employee
             for name and ID number.
*/

public class Supervisor extends Employee {

    private int supervisorLevel;      // Supervisor's level
    private double supervisorPayRate; // Pay rate of the supervisor

    // Supervisor constructor, contains call to superclass Employee
    public Supervisor( String employeeName, int employeeID, int supervisorLevel, double supervisorPayRate) {
        super(employeeName,employeeID);
        this.supervisorLevel = supervisorLevel;
        this.supervisorPayRate = supervisorPayRate;
    }

    /**
     * Calculates the pay of a supervisor
     * (Hours x Rate) + (1000 x Level)
     *
     * @param hoursWorked User passed hours the supervisor had worked
     * @return The supervisor's pay as a double
     */
    public double calcPay(int hoursWorked) {
        return ((hoursWorked * supervisorPayRate) + (1000 * supervisorLevel));
    }

    // Getters for private variables
    public int getSupervisorLevel() {
        return supervisorLevel;
    }

    public double getSupervisorPayRate() {
        return supervisorPayRate;
    }

}
