public class StackMenu {
    public static void main(String[] args) {
        InfixPostfix i = new InfixPostfix();
        System.out.println(i.infixToPostfix());
        i = new InfixPostfix("a*b/c");
        System.out.println(i.infixToPostfix());
        i = new InfixPostfix("a/b-c+d*e-a*c");
        System.out.println(i.infixToPostfix());
        i = new InfixPostfix("(a/(b-c+d))*(e-a)*c");
        System.out.println(i.infixToPostfix());
        i = new InfixPostfix("(1-(3*(4-5)/2)-4)");
        System.out.println(i.infixToPostfix());
        i = new InfixPostfix("ab*c/");
        System.out.println(i.infixToPostfix());
    }
}
