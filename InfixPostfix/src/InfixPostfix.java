/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        10/30/2021
Instructor:  Professor Silveyra
Description: Convert infix to postfix & vice versa,
             also evaluates postfix numerical expressions.
*/

public class InfixPostfix implements StackInterface<String>{

    // The stack to hold segments
    private String[] stack;
    // The top of the stack
    private int top;

    // Constructor to set initial top of the stack to -1 (empty)
    public InfixPostfix(){
        this.top = -1;
    }

    /**
     * Converts infix expressions to postfix
     *
     * @param exp The user passed in String expression to be converted
     * @return The expression converted to postfix if valid
     */
    public String infixToPostfix( String exp){
        // Get size of the passed string
        int size = exp.length();
        // Set stack array to the size of string
        this.stack = new String[size];
        // String to be returned with postfix expression
        String postfix = "";
        // Loop through each character in the String expression
        for (int i = 0; i < size; i++){
            // Handling if the operator is + or -
            if (exp.charAt(i) == '+' || exp.charAt(i) == '-'){

                // Existing operator gets added to output
                // Checks for no left parenthesis to enter loop
                while (!(isEmpty() || peek().equals("("))){
                    postfix = postfix + pop();
                }
                // New operators the get added top the top of the stack
                push(Character.toString(exp.charAt(i)));
            }
            // Handling if the operator is * or / or %
            else if (exp.charAt(i) == '*' || exp.charAt(i) == '/'|| exp.charAt(i) == '%'){

                // Existing operator gets added to output
                while (peek().equals("*") || peek().equals("/") || peek().equals("%")) {
                    postfix = postfix + pop();
                }
                // New operators the get added top the top of the stack
                push(Character.toString(exp.charAt(i)));
            }
            // Puts left parenthesis on the stack
            else if (exp.charAt(i) == '('){
                push(Character.toString(exp.charAt(i)));
            }
            // When a right parenthesis is found the stack is emptied
            // to the output variable until a left parenthesis is found.
            else if (exp.charAt(i) == ')'){
                while (!peek().equals("(")){
                    postfix = postfix + pop();
                }
                pop();
            }
            // Things that aren't operators get added to the output
            else {
                postfix = postfix + exp.charAt(i);
            }
        // Clearing out the stack at end to output
        }
        while (!isEmpty()){
            postfix = postfix + pop();
        }
        // Returning output
        return postfix;
    }

    public String postfixToInfix( String exp , boolean evaluate){
        // booleans indicating if the user was trying to evaluate an expression
        boolean eval = evaluate;
        // Get size of the passed string
        int size = exp.length();
        // Set stack array to the size of string
        this.stack = new String[size];

        // Uses regular expression to catch if the user tries to get a non numerical
        // value evaluated, ending the evaluation if true
        if (eval && exp.matches("(.*)[^0-9\\-+*/%](.*)")){
            eval = false;
            return ("Unable to evaluate, hostile character detected!: "+ exp);

        }
        // Loop through each character in the String expression
        for (int i = 0; i < size; i++){
            //Uses regular expression to catch operators during iteration
            if (Character.toString(exp.charAt(i)).matches("[+/%*\\-]")){
                // x = c + b + a
                // Where x is the new expression to be push to stack
                String a = pop();
                // Popping an empty stack returns an empty string
                // which will invalidate the postfix expression
                if (a.equals("")){
                    return "Invalid postfix expression: "+exp;
                }
                // Operator
                String b = Character.toString(exp.charAt(i));
                String c = pop();
                // Popping an empty stack returns an empty string
                // which will invalidate the postfix expression
                if (c.equals("")){
                    return "Invalid postfix expression: "+exp;
                }
                // If they aren't evaluating the new String expression is push to the stack
                if (!eval){
                    push(c+b+a);
                }
                // If they are evaluating the expression gets parsed as a double, evaluated
                // then back to a string and pushed to the stack
                else {
                    // Catches errors caused by trying to parse something that isn't a string, like null
                    try {
                        if (b.equals("+")){
                            push(Double.toString(Double.parseDouble(c) + Double.parseDouble(a)));
                        }
                        else if (b.equals("-")){
                            push(Double.toString(Double.parseDouble(c) - Double.parseDouble(a)));
                        }
                        else if (b.equals("*")){
                            push(Double.toString(Double.parseDouble(c) * Double.parseDouble(a)));
                        }
                        else if (b.equals("/")){
                            push(Double.toString(Double.parseDouble(c) / Double.parseDouble(a)));
                        }
                        else if (b.equals("%")){
                            push(Double.toString(Double.parseDouble(c) % Double.parseDouble(a)));
                        }
                    }catch (NumberFormatException e){
                        return "Invalid postfix expression: "+exp;
                    }

                }
            }
            // If its not an operator push it to the stack
            else {
                push(Character.toString(exp.charAt(i)));
            }
        }
        // If the stack still has stuff in the end the expression was invalid
        if (top > 0){
            return "Invalid postfix expression: "+exp;
        }
        else {
            return pop();
        }
    }

    /**
     * Adds a String to the top of the stack and moves top to it if space allows
     *
     * @param number The new value of top's index
     */
    public void push(String number){
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
    public String pop(){
        // Returns empty string if empty
        if(isEmpty()){
            return "";
        }
        // Returns the String at top's index
        // and decrements top
        else{
            String atTop = stack[top];
            top--;
            return atTop;
        }
    }

    /**
     * Looks at top of the stack
     *
     * @return The String in top's index, or empty string if empty
     */
    public String peek(){
        // Returns empty string if empty
        if(isEmpty()){
            return "";
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
