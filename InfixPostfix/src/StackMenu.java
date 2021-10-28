import java.util.Scanner;

public class StackMenu {
    public static void main(String[] args) {
        System.out.println("62/3-4*+".matches("(.*)[^0-9\\-+*/%](.*)"));
        InfixPostfix i;
        i = new InfixPostfix();
        System.out.println(i.infixToPostfix("a*b/c"));
        i = new InfixPostfix();
        System.out.println(i.infixToPostfix("a/b-c+d*e-a*c"));
        i = new InfixPostfix();
        System.out.println(i.infixToPostfix("(a/(b-c+d))*(e-a)*c"));
        i = new InfixPostfix();
        System.out.println(i.infixToPostfix("(1-(3*(4-5)/2)-4)"));
        i = new InfixPostfix();
        System.out.println(i.infixToPostfix("ab*c/"));

        // Control variable for switch main menu
        int choice = 0;
        // Control variable for switch postfix to infix submenu
        int type = 0;
        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Menu loop
        while ( choice != 1 || choice != 2 ) {

            // Menu controlled by simple number switch
            System.out.println("---------------------- Main Menu -----------------------");
            System.out.println("1. Convert infix to postfix");
            System.out.println("2. Convert postfix to infix");
            System.out.println("3. Exit");
            System.out.println("Enter the number corresponding to the desired operation: ");
            choice = keyboard.nextInt();

            if (choice == 1 || choice == 2 || choice == 3) {
                switch (choice) {
                    case 1: // Convert infix to postfix
                        keyboard.nextLine();
                        System.out.println("Please enter the infix you'd like to convert to postfix: ");
                        System.out.println(i.infixToPostfix(keyboard.nextLine()));
                        break;
                    case 2: // Enter postfix submenu
                        while ( type != 3 ) {

                            // Menu controlled by simple number switch
                            System.out.println("---------------- Postfix to Infix Menu -----------------");
                            System.out.println("1. Convert postfix to infix");
                            System.out.println("2. Evaluate postfix expression");
                            System.out.println("3. Exit to main menu");
                            System.out.println("Enter the number corresponding to the desired operation: ");
                            type = keyboard.nextInt();

                            if (type == 1 || type == 2) {
                                switch (type) {
                                    case 1: // Convert postfix to infix
                                        keyboard.nextLine();
                                        System.out.println("Please enter the postfix you'd like to convert to infix: ");
                                        System.out.println(i.postfixToInfix(keyboard.nextLine(), false));
                                        break;
                                    case 2: // evaluate postfix expression
                                        keyboard.nextLine();
                                        System.out.println("Please enter the postfix you'd like to evaluate: ");
                                        System.out.println(i.postfixToInfix(keyboard.nextLine(), true));
                                        break;
                                    case 3: // Exit submenu
                                        type = 3;
                                        break;
                                }
                            }
                            else {
                                // Check to stop invalid menu inputs
                                System.out.println("That is an invalid entry! Try again.'" +
                                        "");
                            }

                        }
                        type = 0;
                        break;
                    case 3: // Exit program
                        choice = 3;
                        break;
                }
            }
            else {
                // Check to stop invalid menu inputs
                System.out.println("That is an invalid entry! Try again.'" +
                        "");
            }

        }
    }
}
