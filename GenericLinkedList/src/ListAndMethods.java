/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        10/01/2021
Instructor:  Professor Silveyra
Description: The class for a generic singularly LinkedList.
*/

public class ListAndMethods <T extends Comparable<T>> {

    // Make header
    private Node<T> header;

    // Constructor setting initial header to null
    public ListAndMethods()
    {
        header = null;
    }

    /**
     * Displays the current list's data values.
     */
    public void display()
    {
        //Starts temporary Node at header
        Node<T> n = header;

        //Loop and print each item with commas until at end of list.
        while (n != null) {
            System.out.print(n.getData().toString()+ ",");
            n = n.next;
        }

        //Black space for visual ease
        System.out.println("");
    }

    /**
     * Takes a value and attempts to insert the data at a user specified index.
     *
     * @param val Passed in data value
     * @param inx Index of desired insert location in list
     */
    public void insertIndex(T val, int inx){
        // Method call to get size of list
        int listSize = lengthIterative();

        // Indexes that are to big are out of bounds
        if (inx > 1+listSize) {
            System.out.println("That index is to large, the list size is: " + listSize);
        }
        // Indexes that are to small are out of bounds
        else if (inx < 1 ) {
            System.out.println("That index is to small, please provide an index of 1 or larger.");
        }
        // Inserting at front if index is 1(start)
        else if (inx == 1){
            insertFirst(val);
        }
        // Inserts at end if index is 1 bigger than list size
        else if (inx == listSize+1){
            insertLast(val);
        }
        else {
            // Starts temporary Node at header
            Node<T> previous = header;

            // Loop to end one before desired index
            for (int i=1; i < inx-1; i++){
                previous = previous.next;
            }

            // Make new Node with user data to desired index
            Node<T> n = new Node<>();
            n.setData(val);
            n.next = previous.next;
            previous.next = n;

        }
    }

    public void removeIndex(int inx){
        // Method call to get size of list
        int listSize = lengthIterative();

        // Indexes that are to big are out of bounds
        if (inx > listSize) {
            System.out.println("That index is to large, the list size is: " + listSize);
        }
        // Indexes that are to small are out of bounds
        else if (inx < 1 ) {
            System.out.println("That index is to small, please provide an index of 1 or larger.");
        }
        // Removing at front if index is 1(start)
        else if (inx == 1){
            removeFirst();
        }
        // Inserts at end if index is list size
        else if (inx == listSize){
            removeLast();
        }
        else {
            // Starts temporary Node at header
            Node<T> previous = header;

            // Loop to end one before desired index
            for (int i=1; i < inx-1; i++){
                previous = previous.next;
            }

            // Remove Node at desired index
            Node<T> temp = previous.next;
            previous.next = previous.next.next;
            temp.next = null;

        }
    }

    /**
     * Finds the length of the current list
     *
     * @return The length of the list as an int
     */
    public int lengthIterative()
    {
        // Starts temporary Node at header
        Node<T> n = header;
        // Variable to store each Node count
        int count = 0;

        // Loop through list incrementing count for each Node
        while (n != null)
        {
            count++;
            n = n.next;
        }

        return count;
    }

    /**
     * Inserts based data into Node at end of list
     *
     * @param val Passed in data value
     */
    public void insertLast(T val){
        // Create new Node
        Node<T> n = new Node<>();

        // If the list is empty insert at front
        if (header == null) {
            insertFirst(val);
            return;
        }
        // Set new Node's value to val and next to null
        n.setData(val);
        n.next = null;

        // Starts temporary Node at header
        Node<T> temp = header;

        // Loop through entire list until end
        while(temp.next != null){
            temp = temp.next;

        }
        // Attach the new node at end
        temp.next = n;

    }

    /**
     * Inserts based data into Node at start of list
     *
     * @param val Passed in data value
     */
    public void insertFirst(T val)
    {
        // Create new Node
        Node<T> n = new Node<>();

        // Set value of new Node to val and make it the new header
        // Push old header one forward.
        n.setData(val);
        n.next = header;
        header = n;
    }

    /**
     * Removes first Node of the list
     */
    public void removeFirst()
    {
        // If the list is empty there is nothing to remove
        if (header == null) {
            return;
        }
        // Change header to the address header stored
        header = header.next;
    }

    /**
     * Removes the last Node of the list
     */
    public void removeLast(){

        // If the list is empty there is nothing to remove
        if (header == null) {
            return;
        }
        // If there is only one Node remove it
        else if (header.next == null){
            header = null;
            return;
        }

        // Starts temporary Node at header
        Node<T> temp = header;

        // Loop and stop at second to last Node
        while(temp.next.next != null){
            temp = temp.next;

        }
        // Set second to last Node's next to null
        // Removing the last Node
        temp.next = null;

    }

    /**
     * Search the list for an index by a specific data value
     *
     * @param val Passed in data value to search by
     * @return The index of the found value or 0 for not found
     */
    public int searchByValue(T val)
    {
        // Method call to get size of list
        int listSize = lengthIterative();

        // If list is empty return 0
        if (header == null) {
            return 0;
        }

        // Starts temporary Node at header
        Node<T> n = header;
        int count = 1;

        // Loops through list and increments count to find index of matching value
        // Checks to see if val is of the same type as the list
        while (n.getData().getClass() == val.getClass() && !(n.getData().equals(val)) && count <= listSize && n.next != null )
        {
            count++;
            n = n.next;
        }
        // If the value is never found it returns 0
        if (!(n.getData().equals(val))){
            System.out.println("That value doesn't exist");
            return 0;
        }

        return count;
    }

    /**
     * Returns data value at specified index
     *
     * @param inx Index of the desired value
     * @return The data at index or null if empty or not found
     */
    public T searchByIndex(int inx){
        // Method call to get size of list
        int listSize = lengthIterative();

        // Indexes that are to big are out of bounds
        if (inx > listSize) {
            System.out.println("That index is to large, the list size is: " + listSize);
            return null;
        }
        // Indexes that are to small are out of bounds
        else if (inx < 1 ) {
            System.out.println("That index is to small, please provide an index of 1 or larger.");
            return null;
        }
        // Returns null if list is empty
        else if (header == null){
            System.out.println("There is nothing in the list!");
            return header.getData();
        }
        else {
            // Starts temporary Node at header
            Node<T> temp = header;

            // Loops up to index times to arrive at index
            for (int i=1; i < inx; i++){
                temp = temp.next;
            }
            return temp.getData();

        }
    }

    /**
     * Update the data value at a given index
     *
     * @param inx Index of the data to be updated
     * @param newVal The new data to replace the existing
     * @return True if the update was successful or false if not
     */
    public boolean update(int inx, T newVal){
        // Method call to get size of list
        int listSize = lengthIterative();

        // Indexes that are to big are out of bounds
        if (inx > listSize) {
            System.out.println("That index is to large, the list size is: " + listSize);
            return false;
        }
        // Indexes that are to small are out of bounds
        else if (inx < 1 ) {
            System.out.println("That index is to small, please provide an index of 1 or larger.");
            return false;
        }
        else if (header == null){
            System.out.println("There is nothing in the list!");
            return false;
        }
        else {
            // Starts temporary Node at header
            Node<T> temp = header;

            // Loop through each list Node until at indexed Node
            for (int i=1; i < inx; i++){
                temp = temp.next;
            }

            // Checking to see if val and the list are of the same type
            // Update the value at the index with val
            if (temp.getData().getClass() == newVal.getClass()){
                temp.setData(newVal);
                return true;
            }
            // If the data is a different type
            else {
                return false;
            }


        }
    }

    /**
     * Updates a specified number of old value(s) with a new one.
     *
     * @param oldVal The value the is to be replaced/updated in the list
     * @param newVal The value that is to replace/update the existing value in the list
     * @param times The number of times the old value should be replaced if possible
     * @return The number of times the old value was able to be replaced, or 0
     */
    public int updateAll(T oldVal, T newVal, int times){

        // Counter so that only the correct amount of updating takes place.
        int counter = 0;
        // If the list is empty return 0
        if (header == null){
            System.out.println("There is nothing in the list!");
            return 0;
        }
        else if (times < 0){
            System.out.println("The number of updates must be 0 or greater.");
            return 0;
        }
        else {
            // Method call to get size of list
            int listSize = lengthIterative();
            // Starts temporary Node at header
            Node<T> temp = header;

            // Check to see if specified old and new values matches list type
            if (temp.getData().getClass() == newVal.getClass() && temp.getData().getClass() == oldVal.getClass()) {

                // Loop through list, check data at each Node for match with oldVal
                // Replace the value with newVal and increment counter until
                // The value has been replaced the desired amount of times
                for (int i = 0; i < listSize; i++) {
                    if (temp.getData() == oldVal && counter < times) {
                        temp.setData(newVal);
                        counter++;
                    }
                    temp = temp.next;
                }
                return counter;
            }

            // Returns 0 if the data type didn't match
            return counter;
        }
    }

    /**
     * Replaces all instances of a specified old value with a specified new value in the list
     *
     * @param oldVal The value the is to be replaced/updated in the list
     * @param newVal The value that is to replace/update the existing value in the list
     * @return The number of times the old value was able to be replaced, or 0
     */
    public int updateAll(T oldVal, T newVal){

        int counter = 0;
        if (header == null){
            System.out.println("There is nothing in the list!");
            return 0;
        }
        else {

            // Method call to get size of list
            int listSize = lengthIterative();
            // Starts temporary Node at header
            Node<T> temp = header;

            // Check to see if specified old and new values matches list type
            if (temp.getData().getClass() == newVal.getClass() && temp.getData().getClass() == oldVal.getClass()) {

                // Loop through list, check data at each Node for match with oldVal
                // Replace the value with newVal and increment counter until
                // The value has been completely replaced. Returns the amount of replacing
                for (int i = 0; i < listSize; i++) {
                    if (temp.getData() == oldVal) {
                        temp.setData(newVal);
                        counter++;
                    }
                    temp = temp.next;
                }
                return counter;
            }

            // Returns 0 if the data type didn't match
            return counter;
        }
    }

    /**
     * Turns list into single string.
     *
     * @return Whole list as a string with ","
     */
    public String toString(){

        // Empty string to build upon
        String list = "";

        // Starts temporary Node at header
        Node<T> n = header;

        // Loop through list concatenating the data
        while (n != null)
        {
            list = list + n.getData().toString() + ",";
            n = n.next;
        }

        return list;
    }

    /**
     * Sorts the list
     */
    public void reSort(){
        // Does nothing if there is no list or only one Node
        if (header == null || header.next == null){
        }
        else {
            // Starts temporary Node at header
            // Starts second temporary Node at header's next
            Node<T> temp = header;
            Node<T> temp2 = header.next;

            // When temp is at the end, the list is sorted
            while (temp.next != null) {
                // temp2 cycles through list finding lesser value comparisons
                while (temp2 != null){
                    // temp2 tracks through list when a lesser value than
                    // temp is found they swap values and temp moves down list once
                    // and temp2 resets to one after temp and they start again until sorted
                    if (temp.getData().compareTo(temp2.getData()) > 0){
                        T tempData = temp.getData();
                        temp.setData(temp2.getData());
                        temp2.setData(tempData);
                    }
                    temp2 = temp2.next;
                }
                temp = temp.next;
                temp2 = temp.next;
            }
        }
    }

    /**
     * Inserts a Node with a specified data value into the list in ascending order
     *
     * @param val Data value to be inserted in the proper ascending order
     */
    public void insertSorted( T val) {
        // If the list is empty, add the Node to the front
        if (header == null){
            insertFirst(val);
        }

        // Compare given value against existing data type
        // If there is only one Node insert first or last depending on data value
        else if (header.next == null){
            if (header.getData().getClass() == val.getClass()){
                if (header.getData().compareTo(val) < 1){
                    insertLast(val);
                }
                else {
                    insertFirst(val);
                }
            }
        }

        else{
            // Starts temporary Node at header
            Node<T> temp = header;

            // Compare given value against existing data type
            if (header.getData().getClass() == val.getClass()) {

                // Counter variable to find inx
                int counter = 1;
                while (temp != null) {

                    // Check temps's data against val
                    // a negative value sends the counter as the inx for insertIndex
                    if (temp.getData().compareTo(val) > 0 ) {
                        insertIndex(val,counter);
                        break;
                    }
                    counter++;
                    temp = temp.next;

                    // If nothing was bigger insert last
                    if (temp == null) {
                        insertLast(val);
                    }
                }
            }
        }
    }
}
