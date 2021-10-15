/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        10/01/2021
Instructor:  Professor Silveyra
Description: The tester file for a generic singularly LinkedList
*/

public class ListTester {
    public static void main(String[] args)
    {
        // Construct lists of Strings, Integers, and floats.

        //ListAndMethods<String> strList = new ListAndMethods<>();
        ListAndMethods<Integer> intList = new ListAndMethods<>();
        //ListAndMethods<Float> floatList = new ListAndMethods<>();


        //intList.insertLast(A);
        intList.insertLast(3);
        intList.insertLast(7);
        intList.display();


        //intList.insertFirst(A);
        intList.insertFirst(2);
        intList.insertFirst(9);
        intList.display();


        //Index would have been out of bounds
        intList.insertIndex(8,-2);

        //Index would have been out of bounds
        intList.insertIndex(10,9);

        intList.insertIndex(4,1);
        intList.display();
        intList.insertIndex(5,4);
        intList.display();
        intList.insertIndex(6,2);
        intList.display();


        intList.removeFirst();
        intList.display();


        intList.removeLast();
        intList.display();


        // Removes an index that doesn't exist
        intList.removeIndex(-1);

        intList.removeIndex(1);
        intList.display();


        // Value won't exist
        System.out.println(intList.searchByValue(-1));

        System.out.println(intList.searchByValue(2));


        // Index is to large
        System.out.println(intList.searchByIndex(100));

        System.out.println(intList.searchByIndex(3));


        // Index is out of bounds
        System.out.println(intList.update(-1,4));

        System.out.println(intList.update(3,8));
        intList.display();


        // The update quantity is negative
        System.out.println(intList.updateAll(3,12,-1));

        System.out.println(intList.updateAll(3,12,1));
        intList.display();


        //intList.insertSorted(A);
        intList.insertSorted(0);
        intList.insertSorted(10);
        intList.insertSorted(100);
        intList.display();


        System.out.println(intList.toString());


        intList.reSort();
        intList.display();
    }
}
