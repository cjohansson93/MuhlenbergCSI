public class InfixPostfix implements StackInterface<String>{
    final private String[] stack;
    private String exp;
    private int top;
    final private int size;

    public InfixPostfix(String expression){
        this.exp = expression;
        this.size = expression.length();
        this.stack = new String[size];
        this.top = -1;

    }

    public String infixToPostfix(){
        String postfix = "";
        for (int i = 0; i < size; i++){
            if (exp.charAt(i) == '+' || exp.charAt(i) == '-'){

                while (!(isEmpty() || peek().equals("("))){
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
            else if (exp.charAt(i) == '('){
                push(Character.toString(exp.charAt(i)));
            }
            else if (exp.charAt(i) == ')'){
                while (!peek().equals("(")){
                    postfix = postfix + pop();
                }
                pop();
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
        if(top == size -1){
            return true;
        }
        return false;
    }

}
