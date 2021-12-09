/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        12/10/2021
Instructor:  Professor Silveyra
Description: The Node class for adjacency list.
*/

public class ListNode {

    private Integer to;
    private Integer weight;
    private Boolean known;
    private Integer previous;
    public ListNode next;

    public ListNode( Integer to, Integer weight){
        this.to = to;
        this.weight = weight;
        this.known = false;
        this.previous = -1;
        next = null;
    }

    // Overload constructor for blank Node
    public ListNode(){
        this.to = null;
        this.weight = null;
        this.known = null;
        this.previous = null;
        next = null;
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

    public Boolean getKnown() {
        return known;
    }

    public void setKnown(Boolean known) {
        this.known = known;
    }

    public Integer getPrevious() {
        return previous;
    }

    public void setPrevious(Integer previous) {
        this.previous = previous;
    }
}
