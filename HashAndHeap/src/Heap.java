/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        11/23/2021
Instructor:  Professor Silveyra
Description: A heap, with insert,remove,
             search & display functionality.
*/

public class Heap {
    // Array of Nodes with integer priority and String name
    NodeHeap[] heap;
    // top is the last non null index in heap array
    int top;

    // Heap constructor, sets initial size of heap to 100 and top starts at 0
    public Heap(){
        heap = new NodeHeap[100];
        top = 0;
    }

    /**
     * Inserts a new node ,with a name, based on priority into the heap array.
     * (C++ code provided by Professor Silveyra, converted to Java by Christian J)
     *
     * @param priority Integer priority of a name, lower priorities are parents of larger ones.
     * @param name The String name associated with a given priority.
     */
    public void insert(int priority, String name){
        // Insert as long as array isn't full
        if (!(top == heap.length -1)){
            //Moves index to be over first empty(null) node
            top++;

            //Starts iteration at last non null node's index
            int i = top;
            // Starting at end, as long as you are smaller than your parent
            // your parent takes your place, until hole left is where the insert
            // can't move up further or has a smaller parent.
            for (; i > 1 && priority < heap[i/2].getPriority(); i = i/2){
                heap[i] = heap[i/2];
            }
            // Insert created new node at final index
            heap[i] = new NodeHeap(priority,name);
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
                    if (heap[c].getPriority() > heap[c+1].getPriority()){
                        c++;
                    }
                }
                // Checking if child is smaller than parent
                // if so switch-a-roo and parent index is now at child index
                if (heap[i].getPriority() > heap[c].getPriority()){
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

    /**
     * Searches the heap array nodes for a name match,
     * prints out index, name & rank if found or informs if not found
     *
     * @param name String name to search for in each node
     */
    public void search(String name){
        // Loops through all non null index in heap
        for (int i = 1; i <= top; i++){
            if (heap[i].getName().equals(name)){
                System.out.println("Index: "+ i +" Name: " + heap[i].getName() +" Rank: " + heap[i].getPriority());
                return;
            }
        }
        System.out.println(name + ", does not exist.");
    }

    /**
     * Displays the index, name and rank of each non null node in array
     */
    public void display(){
        // Loops through all non null index in heap
        for (int i = 1; i <= top; i++){
            System.out.println("Index: "+ i +" Name: " + heap[i].getName() +" Rank: " + heap[i].getPriority());
        }
    }
}