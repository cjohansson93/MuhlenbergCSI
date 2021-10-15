/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        10/08/2021
Instructor:  Professor Silveyra
Description: The Node class for a generic doubly LinkedList
*/

public class DoubleNode<T extends Comparable<T>> {

    // Variables for the next Node, Previous Node
    // and the value contained within
    public DoubleNode<T> next;
    public DoubleNode<T> prev;
    private T node_value;

    // Node constructor for Node creation with passed in value
    public DoubleNode(T val){
        setNode_value(val);
        next = null;
        prev = null;
    }

    // Node constructor for Node creation of head and tail
    public DoubleNode(){
        setNode_value(null);
        next = null;
        prev = null;  }

    // Getter for value
    public T getNode_value() {
        return node_value;
    }

    // Setter for value
    public void setNode_value(T node_value) {
        this.node_value = node_value;
    }
}

