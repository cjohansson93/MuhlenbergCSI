import java.util.InputMismatchException;
import java.util.Scanner;

public class HashHeapMenu {
    public static void main(String[] args) {
        int choice = 0;

        // Create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        while ( choice != 3 ) {

            // Menu controlled by simple number switch
            System.out.println("----------------------- Type Menu ------------------------");
            System.out.println("1. String");
            System.out.println("2. Integer");
            System.out.println("Enter the number corresponding to data type to be entered: ");
            try {
                choice = keyboard.nextInt();
            }catch (InputMismatchException e){
                choice = 4;
            }

            if (choice == 1 || choice == 2 || choice == 3) {
                switch (choice) {
                    case 1: // Make String List
                        break;
                    case 2: // Make Integer List
                        break;
                    case 3: // Make Integer List
                        break;
                }
            }
            else {
                // Check to stop invalid menu inputs
                System.out.println("That is an invalid entry! Try again.");
            }

        }
    }
}
