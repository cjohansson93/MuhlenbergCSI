/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        10/08/2021
Instructor:  Professor Silveyra
Description: The class for a generic doubly LinkedList.
*/

public class SortedDoubleList <T extends Comparable<T>> {

    // Variables for known Nodes head and tail,
    // as well as initial list size
    private final DoubleNode<T> head;
    private final DoubleNode<T> tail;
    private int size;

    // Constructor for List's head and tail, and initial size of list, 0
    public SortedDoubleList(){
        head = new DoubleNode<>();
        tail = new DoubleNode<>();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * This method inserts a Node into the list with value in ascending order
     *
     * @param val The value to be inserted into the list
     */
    public void insert(T val){
        DoubleNode<T> n = new DoubleNode<>(val);
        // If the list is empty insert between head and tail
        if(empty()){
            n.next = tail;
            n.prev = head;
            head.next = n;
            tail.prev = n;
        }
        // All other inserts are done in ascending order by value comparison
        else{
            DoubleNode<T> temp = head.next;
            // Loop to progress through list
            // Compares value against each value in list
            // progresses until at before tail or finds greater value
            while (temp.next != tail && temp.getNode_value().compareTo(val) < 0){
                temp = temp.next;
            }
            // Insert for at the end of the list
            if (temp.getNode_value().compareTo(val) <= 0){
                n.next = temp.next;
                n.prev = temp;
                n.next.prev = n;
                temp.next = n;
            }
            // Insert if inserting smaller value than list value
            else {
                n.next = temp;
                n.prev = temp.prev;
                temp.prev = n;
                n.prev.next = n;
            }
        }
        // Increments list size
        size++;

    }

    /**
     * Removes and returns value of first list element
     *
     * @return The value of the removed element or null if empty
     */
    public T pop_front(){
        if (!empty()){
            DoubleNode<T> temp = head.next;
            temp.next.prev = head;
            head.next = temp.next;
            temp.next = null;
            temp.prev = null;
            // Decrements list size
            size--;
            return temp.getNode_value();
        }
        // If list is empty
        return null;
    }

    /**
     * Removes and returns value of last list element
     *
     * @return The value of the removed element or null if empty
     */
    public T pop_back(){
        if (!empty()){
            DoubleNode<T> temp = tail.prev;
            temp.prev.next = tail;
            tail.prev = temp.prev;
            temp.next = null;
            temp.prev = null;
            // Decrements list size
            size--;
            return temp.getNode_value();
        }
        // If list is empty
        return null;
    }

    /**
     * Removes all nodes with the passed in value
     *
     * @param val Value to be completely removed from list
     * @return The amount of times the value was removed
     */
    public int erase(T val){
        // Counter for the number of times a value was removed
        int counter = 0;
        if (!empty()){
            DoubleNode<T> temp = head.next;
            // Checking for input type mismatch
            if (temp.getNode_value().getClass() != val.getClass()){
                System.out.println("That type does not match the list.");
                return -1;
            }
            // Transverse list loop
            while (temp.next != null) {
                // Matched values cause node removal
                if (temp.getNode_value().compareTo(val) == 0) {
                    DoubleNode<T> match = temp;
                    temp = temp.next;
                    match.next.prev = match.prev;
                    match.prev.next = match.next;
                    match.next = null;
                    match.prev = null;
                    // List size is decremented
                    size--;
                    // Incremented counter for each removal
                    counter++;
                }
                else {
                    temp = temp.next;
                }
            }
        }
        return counter;
    }

    /**
     * Returns the size of the list
     *
     * @return Size of list
     */
    public int size(){
        return size;
    }

    /**
     * Returns whether the list is empty or not
     *
     * @return True if empty, false if not
     */
    public boolean empty() {
        // If the head is pointing to the tail there
        // mustn't be any other Nodes
        if (head.next == tail) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the value of the first Node after head
     *
     * @return Value of the first Node after head
     */
    public T front(){
        return head.next.getNode_value();
    }

    /**
     * Returns the value of the last Node before tail
     *
     * @return Value of the last Node before tail
     */
    public T back(){
        return tail.prev.getNode_value();
    }

    /**
     * Counts the number of elements with the same value as the one passed in
     *
     * @param val The value to check for in the list
     * @return The number of times the value was in the list
     */
    public int count(T val){
        // Counter to store the number of times the value appears
        int count = 0;
        if (!empty()) {
            DoubleNode<T> temp = head.next;
            // Checking for input type mismatch
            if (temp.getNode_value().getClass() != val.getClass()){
                System.out.println("That type does not match the list.");
                return count;
            }
            // Transverse list by loop looking for matching value
            // increment count if value found
            while (temp.next != null) {
                if (temp.getNode_value().compareTo(val) == 0) {
                    count++;
                }
                temp = temp.next;
            }
        }
        return count;
    }
}
