/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        12/10/2021
Instructor:  Professor Silveyra
Description: An adjacency list, with insert,remove,
             search & display functionality options.
*/

public class AdjacencyList {
    // Array of Nodes with String key and String value
    ListNode[] list;

    // Constructor sets up small array for easier testing
    public AdjacencyList(int nodes){
        list = new ListNode[nodes];
    }

    /**
     * Inserts a Node at index "from" with given "to" and "weight" at index in array
     * corresponding to key hashcode equivalent
     *
     * @param from Index in array
     * @param weight weight of the edge
     * @param to Index of Node the from points to
     */
    public void insert(Integer from, Integer to, Integer weight){
        // Call out to turn String key into an int hashcode within array index bounds
        // Case if the index is empty, make blank "head node"
        if (list[from] == null){
            list[from] = new ListNode();
        }
        // Temporary node to transverse list at the index
        ListNode temp = list[from];
        // This while loop is broken internally
        while(true) {
            // Insertion if to and weight don't already exist in same node
            if (temp.next == null){
                ListNode n = new ListNode(to,weight);
                temp.next = n;
                break;
            }
            // Don't insert if to and weight of Node already exist
            else if (temp.next.getTo() == to && temp.next.getWeight() == weight){
                break;
            }
            else {
                temp = temp.next;
            }
        }
    }

    /**
     * Removes every Node in array corresponding to given from
     *
     * @param from int from of a index to be cleared
     */
    public void remove(Integer from){
        // Case if the index is empty
        if (list[from] == null){
            return;
        }
        // Temporary node to transverse list at the index
        ListNode temp = list[from];
        // This while loop is broken internally
        while(true) {
            // Nothing more to remove
            if (temp.next == null){
                return;
            }
            // Remove every Node
            else {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    /**
     * Searches the array of Nodes by given key for value
     *
     * @param from Index in array
     * @param weight weight of the edge
     * @param to Index of Node the from points to
     * @return true if found, false if not
     */
    public boolean search(Integer from, Integer to, Integer weight){
        // Case if the index is empty
        if (list[from] == null){
            return false;
        }
        // Temporary node to transverse list at the index
        ListNode temp = list[from];
        while(true) {
            // Case if the key doesn't exist and end is reached
            if (temp.next == null){
                return false;
            }
            // Case if the key is found and its value returned
            else if (temp.next.getTo() == to && temp.next.getWeight() == weight){
                return true;
            }
            else {
                temp = temp.next;
            }
        }
    }

    /**
     * Prints out the index in the array, the key and value of every node
     */
    public void display(){
        // Iterate through all Nodes at every index in array
        for (int i = 0; i < list.length; i++){
            if (list[i] != null){
                // Temporary node to transverse list at the index
                ListNode temp = list[i];
                while (temp != null){
                    if (temp.next != null){
                        System.out.println("From: " + i + " To: " + temp.getTo() + " Weight: " + temp.getWeight()+ " Known: "
                                            + temp.getKnown()+ " Previous: " + temp.getPrevious());
                    }
                    temp = temp.next;
                }
            }
        }
    }
}
