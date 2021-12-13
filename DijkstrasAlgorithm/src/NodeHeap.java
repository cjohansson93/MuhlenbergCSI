/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        12/10/2021
Instructor:  Professor Silveyra
Description: The Node class for a heap, with name and priority.
*/

public class NodeHeap {
    private boolean known;
    private int distance;
    private int previous;

    public NodeHeap(boolean known, int distance, int previous){
        this.known = known;
        this.distance = distance;
        this.previous = previous;
    }

    // Overload constructor for blank Node
    public NodeHeap(){
        this.known = false;
        this.distance = 0;
        this.previous = 0;
    }

    public int getValue() {
        return this.distance;
    }
}
