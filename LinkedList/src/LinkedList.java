/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        04/03/2021
Instructor:  Dr. Helsing
Description: This program creates Node objects to store book titles in
             also contains methods to view book titles, add and remove titles
             and check for title existence. Uses Node.java, used by Library.java
*/

public class LinkedList {

    // Creation of starting reference Nodes
    private Node head = null;
    private Node tail = null;

    /**
     * This method takes the title of a book and stores it in a Node in a linked list
     *
     * @param title takes the title of the book and stores in a Node linked list
     */
    public void storeTitle(String title){

        // Node current used as a temporary Node
        Node current;

        // Conditional for the first Node case
        if (head == null) {
            current = new Node(title, null, null);
            head = current;
        }

        // All additional nodes after first
        else {
            current = new Node(title, null, tail);
            tail.setNext(current);
        }

        tail = current;

    }

    /**
     * This method takes a book title string and checks to see if it exists
     *
     * @param title takes the title of the book and checks through nodes for match
     * @return Boolean return indicating if book title exists(true) or not(false).
     */
    public boolean findTitle(String title){

        // Start checking from first Node
        Node current = head;

        // Checks all non-empty Nodes for String match
        while( current != null) {
            if (current.getTitle().equals(title)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    /**
     * This method searches for a book title and removes it if found
     *
     * @param title takes the title of the book and checks through nodes for match
     * @return Boolean return indicating if book title was removed(true) or not(false).
     */
    public boolean removeTitle(String title){

        Node current;  // Temporary Node for current position
        Node previous; // Temporary Node for previous Node address
        Node next;     // Temporary Node for previous Node address

        // Conditional if first Node is empty entire list is empty
        if (head == null){
            return false;
        }

        // Conditional if the first Node is to be removed, set its next to null and make head null
        if (head.getTitle().equals(title)) {
            current = head;
            head = head.getNext();
            current.setNext(null);
            return true;
        }

        // Removal of middle Nodes or tail Node
        current = head.getNext();
        while(current != null) {
            if (current.getTitle().equals(title)) {
                // Stores next and previous Node while moving through list
                previous = current.getPrevious();
                next = current.getNext();
                // Conditional, removal of tail node
                if (next == null) {
                    previous.setNext(null);
                }
                // All other middle Nodes, tie side Nodes together
                else {
                    next.setPrevious(previous);
                    previous.setNext(next);
                }
                // Remove current node by untying it.
                current.setPrevious(null);
                current.setNext(null);
                return true;
            }
            // Move to next Node until found or not
            current = current.getNext();
        }

        return false;
    }

    /**
     * This method prints out all non-empty Node's book title data
     */
    public void printTitle() {
        Node current = head;
        while( current != null) {
            System.out.println(current.getTitle());
            current = current.getNext();
        }
    }
}
