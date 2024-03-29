/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        09/24/2021
Instructor:  Professor Silveyra
Description: A comparison of iterative vs recursive
             binary search algorithms. Requires a sorted array.
*/

import java.util.*;

public class BinarySearch {

    private static int[] A = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

    public static void main(String[] args)
    {

        int key;       // The integer to search for in the array.
        int index1;    // Location of the key if it's in the array - iterative.
        int index2;    // Location of the key if it's in the array - recursive.

        Scanner keyb = new Scanner(System.in);  // Construct a keyboard scanner.

        do {
            System.out.print("\nEnter an integer to search for (0 to quit): ");
            key = keyb.nextInt();

            index1 = SearchBinIterative(A, key, 0, A.length-1);
            index2 = SearchBinRecursive(A, key, 0, A.length-1);

            if (index1 != index2)
                System.out.println("indices don't match!!");
            else
                System.out.printf("index1: %d, index2 %d\n",index1, index2);

            if (index1 != -1)
                System.out.printf("%d was found at index %d\n", key, index1);
            else
                System.out.printf("%d is not in the array", key, args);

        } while (key != 0);
    }

    /*
     *   SearchBinIterative()
     *
     *   Search for the key within the array A from location left to right.
     *   Return the index where it is found or -1.
     */

    public static int SearchBinIterative(int[] A, int key, int left, int right)
    {
        int mid = 0;               // Index at the middle of the search region.
        boolean found = false;     // Flags if the key is found.

        while (left <= right && !found) {   // While we've a valid Search Region
                                            // and the key isn't found ...
            mid = (left + right) / 2;       // ... compute middle of SR

            if (A[mid] == key)              // we found the key
                found = true;               //    set our flag
            else if (key < A[mid])          // key less than middle
                right = mid-1;              //    search left side of SR
            else                            // key greater than middle
                left = mid + 1;             //    search right side of SR
        }

        return found ? mid : -1;    // Return index or -1.
    }

    /*
     *   SearchBinRecursive()
     *
     *   Search for the key within the array A from location i to j.
     *   Return the index where it is found or -1.
     */

    public static int SearchBinRecursive(int[] A, int key, int left, int right)
    {
        int mid = (left + right)/2;
        if (A[mid] > key && left <= right ){
            return SearchBinRecursive(A,key,left,mid-1);
        }
        else if (A[mid] < key && left <= right ){
            return SearchBinRecursive(A,key,mid+1,right);
        }
        else if (A[mid] == key){
            return mid;
        }
        return -1;
     

    }
}
