/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        11/23/2021
Instructor:  Professor Silveyra
Description: The Node class for a heap, with name and priority.
*/

public class NodeHeap {
    private Integer priority;
    private String name;

    public NodeHeap(Integer priority, String name){
        this.priority = priority;
        this.name = name;
    }

    // Overload constructor for blank Node
    public NodeHeap(){
        this.priority = null;
        this.name = null;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
