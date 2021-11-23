/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        11/23/2021
Instructor:  Professor Silveyra
Description: An open hash table, with insert,remove,
             search & display functionality options.
*/

public class OpenHash {
    // Array of Nodes with String key and String value
    NodeHash[] hashTable;

    // Constructor sets up small array for easier testing
    public OpenHash(){
        hashTable = new NodeHash[5];
    }

    /**
     * Inserts a Node with given key and value at index in array
     * corresponding to key hashcode equivalent
     *
     * @param key String key of value to be inserted into array, duplicate keys overwrite value
     * @param value String value associated with one unique key
     */
    public void insert(String key, String value){
        // Call out to turn String key into an int hashcode within array index bounds
        int index = getIndex(key);
        // Case if the index is empty, make blank "head node"
        if (hashTable[index] == null){
            hashTable[index] = new NodeHash();
        }
        // Temporary node to transverse linkedlist at the index
        NodeHash temp = hashTable[index];
        // This while loop is broken internally
        while(true) {
            // Insertion if the key is unique and end is reached
            if (temp.next == null){
                NodeHash n = new NodeHash(key,value);
                temp.next = n;
                break;
            }
            // Replacement of value if key exists already
            else if (temp.next.getKey().equals(key)){
                temp.next.setValue(value);
                break;
            }
            else {
                temp = temp.next;
            }
        }
    }

    /**
     * Removes Node in array corresponding to given key
     *
     * @param key String key of a value to be removed array
     * @return True if removed, false is empty or key doesn't exist
     */
    public boolean remove(String key){
        // Call out to turn String key into an int hashcode within array index bounds
        int index = getIndex(key);
        // Case if the index is empty
        if (hashTable[index] == null){
            return false;
        }
        // Temporary node to transverse linkedlist at the index
        NodeHash temp = hashTable[index];
        // This while loop is broken internally
        while(true) {
            // Case if the key doesn't exist and end is reached
            if (temp.next == null){
                return false;
            }
            // Case if key is found and removed
            else if (temp.next.getKey().equals(key)){
                temp.next = temp.next.next;
                return true;
            }
            else {
                temp = temp.next;
            }
        }
    }

    /**
     * Searches the array of Nodes by given key for value
     *
     * @param key String key of a value to be searched for
     * @return The value of the found key or null if nonexistent
     */
    public String search(String key){
        // Call out to turn String key into an int hashcode within array index bounds
        int index = getIndex(key);
        // Case if the index is empty
        if (hashTable[index] == null){
            return null;
        }
        // Temporary node to transverse linkedlist at the index
        NodeHash temp = hashTable[index];
        while(true) {
            // Case if the key doesn't exist and end is reached
            if (temp.next == null){
                return null;
            }
            // Case if the key is found and its value returned
            else if (temp.next.getKey().equals(key)){
                return temp.next.getValue();
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
        for (int i = 0; i < hashTable.length; i++){
            if (hashTable[i] != null){
                // Temporary node to transverse linkedlist at the index
                NodeHash temp = hashTable[i];
                while (temp != null){
                    if (temp.getKey() != null){
                        System.out.println("Index: " + i + " Key: " + temp.getKey() + " Value: " + temp.getValue());
                    }
                    temp = temp.next;
                }
            }
        }
    }

    /**
     * Turns a key into an int hashcode corresponding to that key within bounds of array size to fit as index
     *
     * @param key String key provided by user
     * @return An int hashcode corresponding to key within bounds of array size to fit as index
     */
    private int getIndex(String key){
        return key.hashCode()%5;
    }
}
