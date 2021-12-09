/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        12/10/2021
Instructor:  Professor Silveyra
Description: int Stack with push, pop, peek, as well as determining if stack is empty or full.
*/

public class Stack {

    // The stack to hold segments
    private int[] stack;
    // The top of the stack
    private int top;

    // Constructor to set initial top of the stack to -1 (empty)
    public Stack(){
        this.top = -1;
    }



    /**
     * Adds a String to the top of the stack and moves top to it if space allows
     *
     * @param number The new value of top's index
     */
    public void push(int number){
        if(isFull()){
            System.out.println("No more room!");
        }
        // Stack's top increments and is String value is number
        else{
            top++;
            stack[top] = number;
        }
    }

    /**
     * Removes and returns the String at top's index and moves top down one
     *
     * @return Empty String if empty or the String at top's index
     */
    public int pop(){
        // Returns empty string if empty
        if(isEmpty()){
            return -1;
        }
        // Returns the String at top's index
        // and decrements top
        else{
            int atTop = stack[top];
            top--;
            return atTop;
        }
    }

    /**
     * Looks at top of the stack
     *
     * @return The String in top's index, or empty string if empty
     */
    public int peek(){
        // Returns empty string if empty
        if(isEmpty()){
            return -1;
        }
        else{
            return stack[top];
        }
    }

    /**
     * Checks if stack is empty
     *
     * @return true if empty, false if not
     */
    public boolean isEmpty(){
        // Since 0 is the first index if top is -1
        // then nothing has been added or enough has
        // been removed to return it to -1
        if(top == -1){
            return true;
        }
        return false;
    }

    /**
     * Checks if stack is full
     *
     * @return true if full, false if not
     */
    public boolean isFull(){
        // As top moves to the end of the array
        // if it equals the index of the last slot
        // it is full
        if(top == stack.length -1){
            return true;
        }
        return false;
    }

}
