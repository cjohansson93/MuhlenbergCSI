/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        09/24/2021
Instructor:  Professor Silveyra
Description: A program to implement a recursive function
             to sum the elements of an integer array.
*/

public class ArraySum
{
    private static int[] A = {};           // An empty array.
    private static int[] B = { 3, 5, 2 };
    private static int[] C = {2, -2, 2, -2, 2, -2, 5};


    public static void main(String[] args) {

        int sumA = sum(A, 0, A.length-1);  // Sum the elements of the
        int sumB = sum(B, 0, B.length-1);  // three arrays and print
        int sumC = sum(C, 0, C.length-1);  // the results.

        System.out.printf("The sum for array A is %d\n", sumA);
        System.out.printf("The sum for array B is %d\n", sumB);
        System.out.printf("The sum for array C is %d\n", sumC);
    }


    /*
     *    sum() - return the sum of the elements in
     *            array X from index i to index j.
     */

    public static int sum(int[] X, int i, int j)
    {
        // recurs until at last element then sums it with every element before.
        if(i<=j)
        {
                return (X[i] + sum(X,i+1,j));
        }
        return 0;
    }

}
