public class InfixPostfix1 implements StackInterface<String>{
    private String[] stack;
    private int top;

    public InfixPostfix1(){
        this.top = -1;
    }

    public String infixToPostfix(String exp){
        int size = exp.length();
        this.stack = new String[size];
        String postfix = "";
        for (int i = 0; i < size; i++){
            if (exp.charAt(i) == '+' || exp.charAt(i) == '-'){

                while (!isEmpty()){
                    postfix = postfix + pop();
                }
                push(Character.toString(exp.charAt(i)));
            }
            else if (exp.charAt(i) == '*' || exp.charAt(i) == '/'|| exp.charAt(i) == '%'){

                while (peek().equals("*") || peek().equals("/") || peek().equals("%")) {
                    postfix = postfix + pop();
                }
                push(Character.toString(exp.charAt(i)));
            }
            else {
                postfix = postfix + exp.charAt(i);
            }
        }
        while (!isEmpty()){
            postfix = postfix + pop();
        }
        return postfix;
    }

    public void push(String number){
        if(isFull()){
            System.out.println("No more room!");
        }
        else{
            top++;
            stack[top] = number;
        }
    }

    public String pop(){
        if(isEmpty()){
            System.out.println("The expression is empty");
            return "";
        }
        else{
            String atTop = stack[top];
            top--;
            return atTop;
        }
    }

    public String peek(){
        if(isEmpty()){
            return "";
        }
        else{
            return stack[top];
        }
    }

    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(top == stack.length - 1){
            return true;
        }
        return false;
    }

}
