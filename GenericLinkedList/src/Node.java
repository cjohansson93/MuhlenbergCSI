/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        10/01/2021
Instructor:  Professor Silveyra
Description: The Node class for a generic singularly LinkedList
*/

public class Node<T extends Comparable<T>>
{
    private T data;        // Data stored in the Node.
    public Node<T> next;   // Pointer to next Node in the list.

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
