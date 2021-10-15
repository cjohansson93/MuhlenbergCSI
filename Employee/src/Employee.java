/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        04/30/2021
Instructor:  Dr. Helsing
Description: Superclass of an employee extended by BasicWorker.java and Supervisor.java
             stores employee name and id, requires creation of method to calculate pay
*/

public abstract class Employee {

    protected String employeeName; // Employee name
    protected int employeeID;      // Employee ID

    // Employee constructor
    public Employee( String employeeName, int employeeID) {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
    }

    /**
     * Abstract for calculating pay of an employee
     *
     * @param hoursWorked User passed hours the worker had worked
     * @return The employee's pay as a double
     */
    public abstract double calcPay( int hoursWorked );

    // Getters for private variables
    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

}
