/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        11/23/2021
Instructor:  Professor Silveyra
Description: The Node class for linkedlist within an open hash table, with key and value.
*/

public class NodeHash {

    private String key;
    private String value;
    public NodeHash next;

    public NodeHash(String key, String value){
        this.key = key;
        this.value = value;
        next = null;
    }

    // Overload constructor for blank Node
    public NodeHash(){
        this.key = null;
        this.value = null;
        next = null;
    }

    // Getters and Setters
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
