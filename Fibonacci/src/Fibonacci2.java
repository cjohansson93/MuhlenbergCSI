/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        09/10/2021
Instructor:  Professor Silveyra
Description: Recursive method of calculating the fibonacci value at value N
*/

import java.util.Scanner;

public class Fibonacci2 {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Which Nth value of the fibonacci sequence would you like to know? :");
        int valueNthTerm = keyboard.nextInt();

        long start = System.nanoTime();
        int fib = fibonacci(valueNthTerm);
        long finnish = System.nanoTime();

        System.out.println("The fibonacci value of the " + valueNthTerm + " term is " + fib);
        System.out.println("Fibonacci run time: " + (finnish - start) + " nanoseconds.");

    }

    public static int fibonacci( int valueN ) {

        if ( valueN > 1 ) {
            return fibonacci(valueN - 1) + fibonacci(valueN - 2);
        }
        else {
            return valueN;
        }
    }
}
