/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        04/03/2021
Instructor:  Dr. Helsing
Description: This program is the class file for a Node object, its a
             storage location for information pertaining to a book title
             works in conjunction with LinkedList.java & Library.java
*/

public class Node {

    private String title;  //Store string variable of book title
    private Node next;     // Address of the next node
    private Node previous; // Address of the previous node

    // Constructor, takes title, the next node and previous node address
    public Node(String title, Node next, Node previous){
        this.title = title;
        this.next = next;
        this.previous = previous;
    }

    //Getters and setters for variables
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Node getNext() { return next; }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
