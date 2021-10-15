/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        09/10/2021
Instructor:  Professor Silveyra
Description: Iterative method of calculating the fibonacci value at value N.
*/

import java.util.Scanner;

public class Fibonacci1 {
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

        int fibN = 1;
        int fibN1 = 0;
        int fibN2;

        if (valueN < 2) {
            return valueN;
        }

        else {
            for (int i = 2; i <= valueN; i++) {

                fibN2 = fibN1;
                fibN1 = fibN;
                fibN = fibN2 + fibN1;

            }
            return fibN;
        }
    }
}