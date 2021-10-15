/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        09/24/2021
Instructor:  Professor Silveyra
Description: A program that implements a recursive function
             to compute the number of cannon balls in
             a pyramid.
*/

import java.util.Scanner;

public class CannonBall {


    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);  // Keyboard scanner.
        int cannonBalls;                        // Number of cannonballs
                                                //    in the pyramid.
        int layers;                             // Number of layers in
                                                //    the pyramid.

        do {
            // Prompt for and read the number of layers of
            // cannonballs in the pyramid.

            System.out.print("\nNumber of layers (-1 to quit): ");
            layers = keyboard.nextInt();

            if (layers != -1) {
                cannonBalls = cannon(layers);  // Determine and report the
                                               // number of cannonballs.
                System.out.printf("There are %d cannonballs in the %d layers.\n",
                                                          cannonBalls, layers);
            }
        } while (layers != -1);
    }


    public static int cannon(int n)
    {
        // All layers greater than 0
        // Each layer n is size n squared
        if (n>=1) {
            return (n*n)+(cannon(n-1));
        }
        return 0;   // Layer 0

    }
}
