import java.util.InputMismatchException;
import java.util.Scanner;

public class HashHeapMenu {
    public static void main(String[] args) {
        OpenHash theOpenHash = new OpenHash();
        Heap theHeap = new Heap();
        
        // Create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        int choice = 0;
        while ( choice != 3 ) {

            // Menu controlled by simple number switch
            System.out.println("------------------------- Main Menu --------------------------");
            System.out.println("1. Hash");
            System.out.println("2. Heap");
            System.out.println("3. Exit Program");
            System.out.println("Enter the number corresponding to structure to be manipulated: ");
            try {
                choice = keyboard.nextInt();
            }catch (InputMismatchException e){
                choice = 4;
            }

            if (choice == 1 || choice == 2 || choice == 3) {
                switch (choice) {
                    case 1: // Hash Menu
                        int choice2 = 0;
                        while ( choice2 != 5 ) {

                            // Menu controlled by simple number switch
                            System.out.println("---------------------- Hash Menu -----------------------");
                            System.out.println("1. Search");
                            System.out.println("2. Insert");
                            System.out.println("3. Remove");
                            System.out.println("4. Display");
                            System.out.println("5. Return to Main Menu");
                            System.out.println("Enter the number corresponding to what you'd like to do: ");
                            try {
                                choice2 = keyboard.nextInt();
                            }catch (InputMismatchException e){
                                choice2 = 6;
                            }

                            if (choice2 == 1 || choice2 == 2 || choice2 == 3|| choice2 == 4|| choice2 == 5) {
                                switch (choice2) {
                                    case 1: // Hash Search
                                        System.out.println("Enter the key to search: ");
                                        String found = theOpenHash.search(keyboard.nextLine());
                                        if (found != null){
                                            System.out.println("The value at that key is: " + found);
                                        }
                                        else {
                                            System.out.println("That key does not exist.");
                                        }
                                        break;
                                    case 2: // Hash Insert
                                        System.out.println("Enter the key to insert: ");
                                        String key = keyboard.nextLine();
                                        System.out.println("Enter the value to insert at that key:");
                                        String value = keyboard.nextLine();
                                        theOpenHash.insert(key,value);
                                        break;
                                    case 3: // Hash Remove
                                        System.out.println("Enter the key to remove: ");
                                        String key2 = keyboard.nextLine();
                                        boolean removed = theOpenHash.remove(key2);
                                        if (removed){
                                            System.out.println(key2 + ", has been removed.");
                                        }
                                        else {
                                            System.out.println("That key doesn't exist.");
                                        }
                                        break;
                                    case 4: // Hash Display
                                        theOpenHash.display();
                                        break;
                                    case 5: // Return to main menu
                                        break;
                                }
                            }
                            else {
                                // Check to stop invalid menu inputs
                                keyboard.nextLine();
                                System.out.println("That is an invalid entry! Try again.");
                            }

                        }
                        break;
                    case 2: // Make Integer List
                        int choice3 = 0;
                        while ( choice3 != 5 ) {

                            // Menu controlled by simple number switch
                            System.out.println("---------------------- Heap Menu -----------------------");
                            System.out.println("1. Search by name");
                            System.out.println("2. Insert new element");
                            System.out.println("3. Remove next guest");
                            System.out.println("4. Display all names and their ranking");
                            System.out.println("5. Return to Main Menu");
                            System.out.println("Enter the number corresponding to what you'd like to do: ");
                            try {
                                choice3 = keyboard.nextInt();
                            }catch (InputMismatchException e){
                                choice3 = 6;
                            }

                            if (choice3 == 1 || choice3 == 2 || choice3 == 3 || choice3 == 4 || choice3 == 5) {
                                switch (choice3) {
                                    case 1: // Search by name
                                        System.out.println("Enter the name to search for: ");
                                        theHeap.search(keyboard.nextLine());
                                        break;
                                    case 2: // Insert new element
                                        int priority;
                                        System.out.println("Enter the integer priority of the person");
                                        try {
                                            priority = keyboard.nextInt();
                                        }catch (InputMismatchException e){
                                            System.out.println("That wasn't an integer!");
                                            break;
                                        }
                                        keyboard.nextLine();
                                        System.out.println("Enter the name of the person");
                                        String name = keyboard.nextLine();
                                        theHeap.insert(priority,name);
                                        break;
                                    case 3: // Remove next guest
                                        theHeap.remove();
                                        System.out.println("It has been done.");
                                        break;
                                    case 4: // Display all names and their ranking
                                        theHeap.display();
                                        break;
                                    case 5: // Return to Main Menu
                                        break;
                                }
                            }
                            else {
                                // Check to stop invalid menu inputs
                                keyboard.nextLine();
                                System.out.println("That is an invalid entry! Try again.");
                            }

                        }
                        break;
                    case 3: // Exit program
                        break;
                }
            }
            else {
                // Check to stop invalid menu inputs
                keyboard.nextLine();
                System.out.println("That is an invalid entry! Try again.");
            }

        }
    }
}
