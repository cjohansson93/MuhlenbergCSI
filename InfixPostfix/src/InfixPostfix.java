public class InfixPostfix implements StackInterface<String>{
    private String[] stack;
    private int top;

    public InfixPostfix(){
        this.top = -1;
    }

    public String infixToPostfix( String exp){
        int size = exp.length();
        this.stack = new String[size];
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

    public String postfixToInfix( String exp , boolean evaluate){
        boolean eval = evaluate;
        int size = exp.length();
        this.stack = new String[size];
        if (eval && exp.matches("(.*)[^0-9\\-+*/%](.*)")){
            eval = false;
            System.out.println("Unable to evaluate, hostile character detected!");
        }
        for (int i = 0; i < size; i++){
            if (Character.toString(exp.charAt(i)).matches("[+/%*\\-]")){
                String a = pop();
                String b = Character.toString(exp.charAt(i));
                String c = pop();
                if (!eval){
                    push(c+b+a);
                }
                else {
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

                }
            }
            else {
                push(Character.toString(exp.charAt(i)));
            }
        }
        if (top > 0){
            return "Invalid postfix expression: "+exp;
        }
        else {
            return pop();
        }
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
        if(top == stack.length -1){
            return true;
        }
        return false;
    }

}
