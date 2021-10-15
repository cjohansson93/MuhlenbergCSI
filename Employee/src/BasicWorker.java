/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        04/30/2021
Instructor:  Dr. Helsing
Description: Stores worker's shift, pay rate and method to calculate pay. Extends the super class Employee
             for name and ID number.
*/

public class BasicWorker extends Employee {

    private int workerShift;      // Workers shift, 1 = day shift, 2 = night shift
    private double workerPayRate; // Workers pay rate

    // BasicWorker constructor, contains call to superclass Employee
    public BasicWorker( String employeeName, int employeeID, int workerShift, double workerPayRate) {
        super(employeeName,employeeID);
        this.workerShift = workerShift;
        this.workerPayRate = workerPayRate;
    }

    /**
     * Calculates the pay of a worker
     * (Hours x Rate)
     *
     * @param hoursWorked User passed hours the worker had worked
     * @return The worker's pay as a double
     */
    public double calcPay(int hoursWorked) {
        return (hoursWorked * workerPayRate);
    }

    // Getters for private variables
    public int getWorkerShift() {
        return workerShift;
    }

    public double getWorkerPayRate() {
        return workerPayRate;
    }

}
