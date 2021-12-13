/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        12/10/2021
Instructor:  Professor Silveyra
Description: A heap, with insert,remove,
             search & display functionality.
*/

public class Heap {
    // Array of Nodes with integer priority and String name
    NodeHeap[] heap;
    // top is the last non null index in heap array
    int top;

    // Heap constructor, sets initial size of heap to size and top starts at 0
    public Heap(int size){
        heap = new NodeHeap[size];
        top = 0;
    }

    /**
     * Inserts a new node ,with a node, based on value into the heap array.
     * (C++ code provided by Professor Silveyra, converted to Java by Christian J)
     *
     * @param value Integer value of a node, lower priorities are parents of larger ones.
     * @param node The String node associated with a given value.
     */
    public void insert(int value, NodeHeap node){
        // Insert as long as array isn't full
        if (!(top == heap.length -1)){
            //Moves index to be over first empty(null) node
            top++;

            //Starts iteration at last non null node's index
            int i = top;
            // Starting at end, as long as you are smaller than your parent
            // your parent takes your place, until hole left is where the insert
            // can't move up further or has a smaller parent.
            for (; i > 1 && value < heap[i/2].getValue(); i = i/2){
                heap[i] = heap[i/2];
            }
            // Insert created new node at final index
            heap[i] = node;
        }
    }

    /**
     * Removes the node with the lowest priority (index 1)
     */
    public void remove(){
        // Case for removing if the array only has one node
        if (top == 1){
            heap[top] = null;
            top--;
        }
        // Case for removing from array with more than 1 node
        else if (top > 1){
            // Move last element to first spot of heap (index 1)
            // null top and decrement it
            heap[1] = heap[top];
            heap[top] = null;
            top--;
            // Percolate down array clearing up order disruption
            // Once i is more than half top it will have no more children
            // So no point in checking beyond that
            for (int i = 1; i <= top/2;){
                // Left child index
                int c = i*2;
                // This means the parent has 2 children
                if (c < top){
                    // If the right child is smaller than left it becomes the new child index
                    if (heap[c].getValue() > heap[c+1].getValue()){
                        c++;
                    }
                }
                // Checking if child is smaller than parent
                // if so switch-a-roo and parent index is now at child index
                if (heap[i].getValue() > heap[c].getValue()){
                    NodeHeap temp = heap[i];
                    heap[i] = heap[c];
                    heap[c] = temp;
                    i = c;
                }
                // Child isn't smaller than parent break loop
                else {
                    break;
                }
            }
        }
    }

//
//    /**
//     * Displays the to,weight,known & previous of each non null node in array
//     */
//    public void display(){
//        // Loops through all non null index in heap
//        for (int i = 1; i <= top; i++){
//            System.out.println(" To: " + heap[i].getNode().getTo() +" Weight: " + heap[i].getNode().getWeight()
//                            +" Known: " + heap[i].getNode().getKnown() +" Previous: " + heap[i].getNode().getPrevious());
//        }
//    }
}