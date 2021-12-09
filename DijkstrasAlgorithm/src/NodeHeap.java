/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        12/10/2021
Instructor:  Professor Silveyra
Description: The Node class for a heap, with name and priority.
*/

public class NodeHeap {
    private ListNode node;
    private Integer value;

    public NodeHeap(ListNode node, Integer value){
        this.setNode(node);
        this.setValue(value);
    }

    // Overload constructor for blank Node
    public NodeHeap(){
        this.setNode(null);
        this.setValue(null);
    }

    // Getters and Setters
    public ListNode getNode() {
        return node;
    }

    public void setNode(ListNode node) {
        this.node = node;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
