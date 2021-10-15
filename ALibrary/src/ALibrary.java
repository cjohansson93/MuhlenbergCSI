/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        04/09/2021
Instructor:  Dr. Helsing
Description: This program acts as an interactive library for book title storage, removal,
             checking and printing of titles, as well as load and save library inventory to file
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ALibrary {
    public static void main(String[] args) throws FileNotFoundException {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // create an ArrayLists objects to store titles & copy count respectively
        // The index of a title corresponds to its copy count at the same index in the other list and vice versa.
        ArrayList<String> titleList = new ArrayList<>();
        ArrayList<Integer> countList = new ArrayList<>();

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
                        storeTitle(keyboard.nextLine(), titleList, countList);
                        break;
                    case 2: // Check for book
                        keyboard.nextLine();
                        System.out.println("What is the name of the book to check for:");
                        if (findTitle(keyboard.nextLine(),titleList)) {
                            System.out.println("The book is in the library");
                        } else {
                            System.out.println("That book is not in the library");
                        }
                        break;
                    case 3: // Remove book
                        keyboard.nextLine();
                        System.out.println("What is the name of the book to remove:");
                        if (removeTitle(keyboard.nextLine(),titleList, countList)) {
                            System.out.println("The book is now removed");
                        } else {
                            System.out.println("That book is not in the library");
                        }
                        break;
                    case 4: // Print all books
                        printTitle(titleList, countList);
                        break;
                    case 5: // Load in book text file
                        fileName = loadLibrary(titleList, countList);
                        break;
                    case 6: // Save library in text file
                        if (fileName == null) {
                            System.out.println("You must load a file first");
                            break;
                        }
                        saveLibrary(fileName,titleList, countList);
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
     * Method stores title of book and copy count at same index in two ArrayLists
     *
     * @param title Title of book to store one copy of.
     * @param titleList String ArrayList with titles, quantity found in countList at same index
     * @param countList Integer ArrayList with quantities of titles, title found in titleList at same index
     */
    public static void storeTitle (String title, ArrayList<String> titleList, ArrayList<Integer> countList){

        // Loop to iterate through title Arraylist
        for (int i = 0; i < titleList.size(); i++) {
            // Increments book count if title already exists
            if (titleList.get(i).equals(title)) {
                countList.set(i,countList.get(i) + 1);
                System.out.println("Book added to library");
                return;
            }
        }

        // Creates new title & count of one if title doesn't exist or library is empty
        titleList.add(title);
        countList.add(1);
        System.out.println("Book added to library");

    }

    /**
     * Method checks user title against titles in ArrayList for match
     *
     * @param title Title of book to compare to titles in Arraylist for potential match.
     * @param titleList String ArrayList with titles, quantity found in countList at same index
     * @return True, book exists. False, book doesn't exist.
     */
    public static boolean findTitle (String title, ArrayList<String> titleList){

        // Iterates through title Arraylist to see if title exists
        for (int i = 0; i < titleList.size(); i++) {
            if (titleList.get(i).equals(title)) {
                return true;
            }
        }
        // False return indicates book title does not exist
        return false;
    }

    /**
     * Method searches for title match and removes one copy of book, or book if only one
     *
     * @param title Title of book to compare to titles in Arraylist for potential match.
     * @param titleList String ArrayList with titles, quantity found in countList at same index
     * @param countList Integer ArrayList with quantities of titles, title found in titleList at same index
     * @return True, book exists and removed. False, book doesn't exist and can't be removed.
     */
    public static boolean removeTitle (String title, ArrayList<String> titleList, ArrayList<Integer> countList){

        // Loop to iterate through title Arraylist
        for (int i = 0; i < titleList.size(); i++) {
            if (titleList.get(i).equals(title)) {
                // If there is more than one of the book title reduce count by one
                if (countList.get(i) > 1) {
                    countList.set(i,countList.get(i) - 1);
                    return true;
                }
                // If there is only one of the book title, remove it completely
                // from both title and count at same index
                else {
                    titleList.remove(i);
                    countList.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method prints out all non-empty ArrayList book titles and count data
     *
     * @param titleList String ArrayList with titles, quantity found in countList at same index
     * @param countList Integer ArrayList with quantities of titles, title found in titleList at same index
     */
    public static void printTitle ( ArrayList<String> titleList, ArrayList<Integer> countList) {

        // Condition if there are book titles in the title ArrayList
        if (!titleList.isEmpty()) {

            // Print out title at each index and corresponding count index for copy quantity.
            for (int i = 0; i < titleList.size(); i++) {
                System.out.println();
                System.out.println("Title: " + titleList.get(i) + "\nCopies: " + countList.get(i));
            }
        }
        // If there are no books user is informed
        else {
            System.out.println("There are no books in the library.");
        }
    }

    /**
     * Method loads in file's book data into title and count ArrayLists
     *
     * @param titleList String ArrayList with titles, quantity found in countList at same index
     * @param countList Integer ArrayList with quantities of titles, title found in titleList at same index
     * @return File name to be used in saving to same file
     * @throws FileNotFoundException
     */
    public static String loadLibrary ( ArrayList<String> titleList, ArrayList<Integer> countList) throws FileNotFoundException {

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
            for (int i = 0; i < titleList.size(); i++) {
                if (titleList.get(i).equals(title)) {
                    countList.set(i,countList.get(i) + bookCount);
                }
            }

            // If title is new add the title to the title and count to their LinkedList.
            titleList.add(title);
            countList.add(bookCount);

        }
        bookReader.close();
        System.out.println("File loaded.");
        return fileName;

    }

    /**
     * Method saves book data from ArrayLists into same file that data was loaded from, in the same format
     *
     * @param fileName File name of loaded file to be used in saving to same file.
     * @param titleList String ArrayList with titles, quantity found in countList at same index
     * @param countList Integer ArrayList with quantities of titles, title found in titleList at same index
     * @throws FileNotFoundException
     */
    public static void saveLibrary (String fileName,  ArrayList<String> titleList, ArrayList<Integer> countList) throws FileNotFoundException {
        // Create PrintWriter object and give loaded file name
        PrintWriter outFile = new PrintWriter(fileName);
        // Print out each title and count data index pair into file in same format it came in
        for (int i = 0; i < titleList.size(); i++) {
            outFile.println(titleList.get(i) + ":" + countList.get(i));
        }
        System.out.println("File Saved.");

        outFile.close();
    }

}