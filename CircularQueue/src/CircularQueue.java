/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        11/02/2021
Instructor:  Professor Silveyra
Description: Circular int queue with adding, removing, full & empty functionality.
*/

public class CircularQueue {

    // The queue to integers
    private int[] queue;
    // The size of the queue
    private int size;
    // Index of the front and rear of the queue
    private int front;
    private int rear;

    // Constructor to set initial front & rear of the queue to -1 (empty)
    public CircularQueue( int size){
        this.size = size;
        this.rear = -1;
        this.front = -1;
        this.queue = new int[size];
    }

    public void enqueue(int val){
        if(isFull()){
            System.out.println("No more room!");
        }
        else if (isEmpty()){
            front = 0;
            rear = 0;
            queue[front] = val;
        }
        else {
            if (rear == size -1){
                rear = 0;
            }
            else {
                rear++;
            }
            queue[rear] = val;
        }

    }

    /**
     * Removes and returns the String at top's index and moves top down one
     *
     * @return Empty String if empty or the String at top's index
     */
    public int dequeue(){
        // Returns -1 if empty
        if(isEmpty()){
            System.out.println("The queue is empty");
            return -1;
        }
        else if (front == rear){
            int x;
            x = queue[front];
            front = -1;
            rear = -1;
            return x;
        }
        else if (front == size -1){
            front = 0;
            return queue[size-1];
        }
        else {
            front++;
            return queue[front-1];
        }
    }



    /**
     * Checks if queue is empty
     *
     * @return true if empty, false if not
     */
    public boolean isEmpty(){
        if(front == -1 && rear == -1){
            return true;
        }
        return false;
    }

    /**
     * Checks if queue is full
     *
     * @return true if full, false if not
     */
    public boolean isFull(){
        if(rear +1 == front || (rear == size -1 && front == 0)){
            return true;
        }
        return false;
    }

}
