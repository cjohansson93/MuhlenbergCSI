/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        12/10/2021
Instructor:  Professor Silveyra
Description: The Node class for adjacency list.
*/

public class ListNode {

    private Integer to;
    private Integer weight;
    private ListNode next;

    public ListNode( Integer to, Integer weight){
        this.to = to;
        this.weight = weight;
        setNext(null);
    }

    // Overload constructor for blank Node
    public ListNode(){
        this.to = null;
        this.weight = null;
        setNext(null);
    }

    // Getters and Setters
    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
