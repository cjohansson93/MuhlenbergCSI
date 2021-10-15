/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        04/09/2021
Instructor:  Dr. Helsing
Description: This program acts as an interactive library for book title storage, removal,
             checking and printing of titles, as well as load and save library inventory to file
             Uses Book.java
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.LinkedList;

public class LLibrary {
    public static void main(String[] args) throws FileNotFoundException {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // create a LinkedList object to manipulate internal Book nodes with titles & copy count
        LinkedList <Book> list = new LinkedList<>();

        // Switch control variable
        int choice = 0;

        // Initialization of blank filename, to be filled in load and saved to
        String fileName = null;

        // Kills menu when Switch is 7
        while (choice != 7) {

            // Menu controlled by simple number switch
            System.out.println("1. Add book to library");
            System.out.println("2. Check for book in library");
            System.out.println("3. Remove book from library");
            System.out.println("4. Print out library");
            System.out.println("5. Load");
            System.out.println("6. Save");
            System.out.println("7. Quit and Leave");
            System.out.println("Enter the number corresponding to what you'd like to do: ");
            choice = keyboard.nextInt();

            if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6 || choice == 7) {
                switch (choice) {
                    case 1: // Add book
                        keyboard.nextLine();
                        System.out.println("What is the name of the book to add:");
                        storeTitle(keyboard.nextLine(), list);
                        break;
                    case 2: // Check for book
                        keyboard.nextLine();
                        System.out.println("What is the name of the book to check for:");
                        if (findTitle(keyboard.nextLine(),list)) {
                            System.out.println("The book is in the library");
                        } else {
                            System.out.println("That book is not in the library");
                        }
                        break;
                    case 3: // Remove book
                        keyboard.nextLine();
                        System.out.println("What is the name of the book to remove:");
                        if (removeTitle(keyboard.nextLine(),list)) {
                            System.out.println("The book is now removed");
                        } else {
                            System.out.println("That book is not in the library");
                        }
                        break;
                    case 4: // Print all books
                        printTitle(list);
                        break;
                    case 5: // Load in book text file
                        fileName = loadLibrary(list);
                        break;
                    case 6: // Save library in text file
                        if (fileName == null) {
                            System.out.println("You must load a file first");
                            break;
                        }
                        saveLibrary(fileName,list);
                        break;
                    case 7: // End program
                        System.out.println("Good bye.");
                        break;
                }
            } else {
                // Check to stop invalid menu inputs
                System.out.println("That is an invalid entry! Try again.'" +
                        "");
            }

        }
    }

    /**
     *  Method creates new Book node to store in LinkedList, data contains title and copy count.
     *
     * @param title Title of book to store one copy of.
     * @param list LinkedList with Book nodes.
     */
    public static void storeTitle (String title, LinkedList  <Book>  list){

        // Loop to iterate through Book nodes
        for (int i = 0; i < list.size(); i++) {
            // Increments Book count if title already exists
            if (list.get(i).getTitle().equals(title)) {
                list.get(i).setBookCount(list.get(i).getBookCount() + 1);
                System.out.println("Book added to library");
                return;
            }
        }

        // Creates new Book node if title doesn't exist or library is empty
        list.add(new Book(title,1));
        System.out.println("Book added to library");

    }

    /**
     *  Method searches through Book node titles for match for title.
     *
     * @param title Title of book to compare to Book node titles for potential match.
     * @param list LinkedList with Book nodes.
     * @return True, book exists. False, book doesn't exist.
     */
    public static boolean findTitle (String title, LinkedList  <Book>  list){

        // Iterates through Book nodes to see if title exists
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(title)) {
                return true;
            }
        }
        // False return indicates book does not exist
        return false;
    }

    /**
     * Method searches for title match and removes one copy of book, or book if only one
     *
     * @param title Title of book to compare to Book node titles for potential match.
     * @param list LinkedList with Book nodes.
     * @return True, book exists and removed. False, book doesn't exist and can't be removed.
     */
    public static boolean removeTitle (String title, LinkedList  <Book>  list){

        // Loop to iterate through Book nodes
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(title)) {
                // If there is more than one of the book reduce count by one
                if (list.get(i).getBookCount() > 1) {
                    list.get(i).setBookCount(list.get(i).getBookCount() - 1);
                    return true;
                }
                // If there is only one of the book, remove it completely
                else {
                    list.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method prints out all non-empty Book node's book titles and count data
     *
     * @param list LinkedList with Book nodes.
     */
    public static void printTitle (LinkedList  <Book>  list) {

        // Condition if there are books in the LinkedList
        if (!list.isEmpty()) {

            for (int i = 0; i < list.size(); i++) {
                System.out.println();
                System.out.println("Title: " + list.get(i).getTitle() + "\nCopies: " + list.get(i).getBookCount());
            }
        }
        // If there are no books user is informed
        else {
            System.out.println("There are no books in the library.");
        }
    }

    /**
     * Method loads in file's book data into Book LinkedList
     *
     * @param list LinkedList with Book nodes.
     * @return File name to be used in saving to same file
     * @throws FileNotFoundException
     */
    public static String loadLibrary (LinkedList  <Book>  list) throws FileNotFoundException {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        String fileName;
        File loadedBooks;

        // Collect name of file from user
        System.out.println("Please enter the name of the file: ");
        fileName = keyboard.nextLine();

        // Create a File object to hold poem.txt file
        loadedBooks = new File(fileName);

        // Check for file existence/ potential typos
        while(!loadedBooks.exists()) {

            System.out.println("Invalid entry! Please enter the name of the file: ");
            loadedBooks = new File(fileName);
        }

        // Plug file into Scanner for ease of manipulation
        Scanner bookReader = new Scanner(loadedBooks);

        // Check for each line of file until end
        while(bookReader.hasNextLine()) {
            // Store each line as separate entity
            String line = bookReader.nextLine();
            Scanner stringReader = new Scanner(line);
            // Collect String data on every side of a ":"
            stringReader.useDelimiter(":");

            // Store title and numeric copy quantity in independent variables
            String title = stringReader.next();
            int bookCount = Integer.parseInt(stringReader.next());

            // Check for title existence in library, if found increment its copy amount
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getTitle().equals(title)) {
                    list.get(i).setBookCount(list.get(i).getBookCount() + bookCount);
                }
            }

            // If title is new add the title to the Book LinkedList with its copy quantity
            list.add(new Book(title,bookCount));

        }
        bookReader.close();
        System.out.println("File loaded.");
        return fileName;

    }

    /**
     * Method saves book data from LinkedList into same file that data was loaded from, in the same format
     *
     * @param fileName File name of loaded file to be used in saving to same file.
     * @param list LinkedList with Book nodes.
     * @throws FileNotFoundException
     */
    public static void saveLibrary (String fileName, LinkedList  <Book>  list) throws FileNotFoundException {
        // Create PrintWriter object and give loaded file name
        PrintWriter outFile = new PrintWriter(fileName);
        // Print out each Book node data into file in same format it came in
        for (int i = 0; i < list.size(); i++) {
            outFile.println(list.get(i).getTitle() + ":" + list.get(i).getBookCount());
        }
        System.out.println("File Saved.");

        outFile.close();
    }

}
