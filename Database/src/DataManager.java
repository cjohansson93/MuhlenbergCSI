/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        05/14/2021
Instructor:  Dr. Helsing
Description: This program takes in a txt file and stores the words and their
             frequency in a HashMap, then prints them out in a satisfying format
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class DataManager {

    HashMap<Integer,Item> entireInventory; // Item ID numbers as key, stores items of Book,Music or Movie class objects as value
    LinkedList<Book> books;                // Stores individual book objects
    LinkedList<Music> musics;              // Stores individual music objects
    LinkedList<Movie> movies;              // Stores individual movie objects

    // Constructor for the DataManager
    public DataManager() {
        this.entireInventory = new HashMap<>();
        this.books = new LinkedList<>();
        this.musics = new LinkedList<>();
        this.movies = new LinkedList<>();
    }

    /**
     * Increments an items copy count if entered ID exists
     *
     * @param entireInventory Hashmap containing all item objects by ID number
     * @param books LinkedList, Not used atm
     * @param musics LinkedList, Not used atm
     * @param movies LinkedList, Not used atm
     */
    public static void checkInItem(HashMap<Integer,Item> entireInventory, LinkedList<Book> books, LinkedList<Music> musics, LinkedList<Movie> movies) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Collects item ID number to check against stored item IDs
        System.out.println("What is the ID number of the item to be checked in?: ");
        int checkID = keyboard.nextInt();
        boolean itemExists = false;
        for (Integer id : entireInventory.keySet()) {
            // A found ID match causes an incrementation of the quantity of that item.
            if (id == checkID) {
                entireInventory.get(id).setItemCopies(entireInventory.get(id).getItemCopies() + 1);
                System.out.println("The item's copies has been increased by one.");
                itemExists = true;
            }
        }
        // Informing user if entered ID doesn't exist
        if (!itemExists) {
            System.out.println("That ID does not exist.");
        }
    }

    /**
     * Decrements an items copy count if entered ID exists, can't go below 0 or be removed completely
     *
     * @param entireInventory Hashmap containing all item objects by ID number
     * @param books LinkedList, Not used atm
     * @param musics LinkedList, Not used atm
     * @param movies LinkedList, Not used atm
     */
    public static void checkOutItem(HashMap<Integer,Item> entireInventory, LinkedList<Book> books, LinkedList<Music> musics, LinkedList<Movie> movies) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Collects item ID number to check against stored item IDs
        System.out.println("What is the ID number of the item to be checked out?: ");
        int checkID = keyboard.nextInt();
        boolean itemExists = false;
        for (Integer id : entireInventory.keySet()) {
            if (id == checkID) {
                // If there are no copies, none can be removed
                if (entireInventory.get(id).getItemCopies() == 0) {
                    System.out.println("There are no more copies of that item to check out.");
                }
                // A found ID match causes a decrementing of the quantity of that item, if above 0
                else {
                    entireInventory.get(id).setItemCopies(entireInventory.get(id).getItemCopies() - 1);
                    System.out.println("The item's copies has been decreased by one.");
                }
                itemExists = true;
            }
        }
        // Informing user if entered ID doesn't exist
        if (!itemExists) {
            System.out.println("That ID does not exist.");
        }
    }

    /**
     * Displays an items information, if entered ID exists
     *
     * @param entireInventory Hashmap containing all item objects by ID number
     * @param books LinkedList, Not used atm
     * @param musics LinkedList, Not used atm
     * @param movies LinkedList, Not used atm
     */
    public static void checkForCopies(HashMap<Integer,Item> entireInventory, LinkedList<Book> books, LinkedList<Music> musics, LinkedList<Movie> movies) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Collects item ID number to check against stored item IDs
        System.out.println("What is the ID number of the item to check for copies?: ");
        int checkID = keyboard.nextInt();
        boolean itemExists = false;
        for (Integer id : entireInventory.keySet()) {
            // A found ID prints out all information on that item
            if (id == checkID) {
                // If the item ID matches a book item
                if (entireInventory.get(id).getItemType().equals("Book")) {
                    System.out.print("ID number: " + entireInventory.get(id).getItemID()
                                 + "\nMedia Type: " + entireInventory.get(id).getItemType()
                                 + "\nName: " + entireInventory.get(id).getItemName()
                                 + "\nAuthor: " + ((Book) entireInventory.get(id)).getBookAuthor()
                                 + "\nGenre: " + entireInventory.get(id).getItemGenre()
                                 + "\nNumber of Pages: " + ((Book) entireInventory.get(id)).getBookPages()
                                 + "\nCopies: " + entireInventory.get(id).getItemCopies());
                    System.out.println();
                    System.out.println();
                }
                // If the item ID matches a music item
                else if (entireInventory.get(id).getItemType().equals("Music")){
                    System.out.print("ID number: " + entireInventory.get(id).getItemID()
                                 + "\nMedia Type: " + entireInventory.get(id).getItemType()
                                 + "\nName: " + entireInventory.get(id).getItemName()
                                 + "\nArtist: " + ((Music) entireInventory.get(id)).getMusicArtist()
                                 + "\nGenre: " + entireInventory.get(id).getItemGenre()
                                 + "\nNumber of Songs: " + ((Music) entireInventory.get(id)).getMusicSongCount()
                                 + "\nCopies: " + entireInventory.get(id).getItemCopies());
                    System.out.println();
                    System.out.println();
                }
                // If the item ID matches a movie item
                else if (entireInventory.get(id).getItemType().equals("Movie")){
                    System.out.print("ID number: " + entireInventory.get(id).getItemID()
                                 + "\nMedia Type: " + entireInventory.get(id).getItemType()
                                 + "\nName: " + entireInventory.get(id).getItemName()
                                 + "\nGenre: " + entireInventory.get(id).getItemGenre()
                                 + "\nNumber of Minutes Long: " + ((Movie) entireInventory.get(id)).getMovieLengthInMin()
                                 + "\nCopies: " + entireInventory.get(id).getItemCopies());
                    System.out.println();
                    System.out.println();
                }
                itemExists = true;
            }
        }
        // Informing user if entered ID doesn't exist
        if (!itemExists) {
            System.out.println("That ID does not exist.");
        }
    }

    /**
     * Displays all items of a specific type and their associated information
     *
     * @param entireInventory Hashmap containing all item objects by ID number
     * @param books LinkedList, Not used atm
     * @param musics LinkedList, Not used atm
     * @param movies LinkedList, Not used atm
     */
    public static void checkItemType(HashMap<Integer,Item> entireInventory, LinkedList<Book> books, LinkedList<Music> musics, LinkedList<Movie> movies) {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Keeps prompting user until they choose to return to main menu (switch option 4)
        boolean quit = false;
        while ( !quit ) {
            // Menu controlled by simple number switch, for use in menu options
            System.out.println("---Menu----");
            System.out.println("1. Books");
            System.out.println("2. Music");
            System.out.println("3. Movies");
            System.out.println("4. Go back to main menu");
            System.out.println("Enter the number corresponding to media type you'd like to inventory: ");
            int menuChoice = keyboard.nextInt();

            if (menuChoice == 1 || menuChoice == 2 || menuChoice == 3 || menuChoice == 4) {
                switch (menuChoice) {

                    case 1: // Prints out all book items and their information
                        for (Integer id : entireInventory.keySet()) {
                            if (entireInventory.get(id).getItemType().equals("Book")) {
                                System.out.print("ID number: " + entireInventory.get(id).getItemID()
                                             + "\nMedia Type: " + entireInventory.get(id).getItemType()
                                             + "\nName: " + entireInventory.get(id).getItemName()
                                             + "\nAuthor: " + ((Book) entireInventory.get(id)).getBookAuthor()
                                             + "\nGenre: " + entireInventory.get(id).getItemGenre()
                                             + "\nNumber of Pages: " + ((Book) entireInventory.get(id)).getBookPages()
                                             + "\nCopies: " + entireInventory.get(id).getItemCopies());
                                System.out.println();
                                System.out.println();
                            }
                        }
                        break;
                    case 2: // Prints out all music items and their information
                        for (Integer id : entireInventory.keySet()) {
                            if (entireInventory.get(id).getItemType().equals("Music")) {
                                System.out.print("ID number: " + entireInventory.get(id).getItemID()
                                             + "\nMedia Type: " + entireInventory.get(id).getItemType()
                                             + "\nName: " + entireInventory.get(id).getItemName()
                                             + "\nArtist: " + ((Music) entireInventory.get(id)).getMusicArtist()
                                             + "\nGenre: " + entireInventory.get(id).getItemGenre()
                                             + "\nNumber of Songs: " + ((Music) entireInventory.get(id)).getMusicSongCount()
                                             + "\nCopies: " + entireInventory.get(id).getItemCopies());
                                System.out.println();
                                System.out.println();
                            }
                        }
                        break;
                    case 3: // Prints out all movie items and their information
                        for (Integer id : entireInventory.keySet()) {
                            if (entireInventory.get(id).getItemType().equals("Movie")) {
                                System.out.print("ID number: " + entireInventory.get(id).getItemID()
                                             + "\nMedia Type: " + entireInventory.get(id).getItemType()
                                             + "\nName: " + entireInventory.get(id).getItemName()
                                             + "\nGenre: " + entireInventory.get(id).getItemGenre()
                                             + "\nNumber of Minutes Long: " + ((Movie) entireInventory.get(id)).getMovieLengthInMin()
                                             + "\nCopies: " + entireInventory.get(id).getItemCopies());
                                System.out.println();
                                System.out.println();
                            }
                        }
                        break;
                    case 4: // Back to main menu

                        quit = true;
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
     * Loads in music,movie,book data from a text file and stores it
     *
     * @param entireInventory Hashmap containing all item objects by ID number
     * @param books LinkedList, stores Book objects
     * @param musics LinkedList, stores Music objects
     * @param movies LinkedList, stores Movie objects
     * @throws FileNotFoundException Throws to main if file not found
     */
    public static void loadFromFile(HashMap<Integer,Item> entireInventory, LinkedList<Book> books, LinkedList<Music> musics, LinkedList<Movie> movies) throws FileNotFoundException {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        String fileName; // File's name
        File itemsToAdd; // Make file object with File's name

        // Get and store user entered name file
        System.out.println("Please enter the name of the item list file: ");
        fileName = keyboard.nextLine();

        // Create a File object to hold itemsToAdd text file
        itemsToAdd = new File(fileName);

        // Check to make sure file exists
        while(!itemsToAdd.exists()) {

            System.out.println("Invalid entry! Please enter the name of the item list file: ");
            fileName = keyboard.nextLine();
            itemsToAdd = new File(fileName);
        }

        // Plug file to scanner
        Scanner itemListReader = new Scanner(itemsToAdd);

        // Check for each line of file until end
        while(itemListReader.hasNextLine()) {

            int itemID;      // Stores first read in piece, the items ID
            String itemTYPE; // Stores second read in piece, the items type

            // Plug each line of file into individual scanner, with "," delimiter
            Scanner itemListLine = new Scanner(itemListReader.nextLine());
            itemListLine.useDelimiter(",");
            itemID = Integer.parseInt(itemListLine.next());
            itemTYPE = itemListLine.next();
            // Sorts items by type (book,music,movie) and stores in appropriate LinkedList, then stores in Item Hashmap
            if (itemTYPE.equals("Book")) {
                Book aBook = new Book(itemID,itemListLine.next(),itemListLine.next(),itemListLine.next(),Integer.parseInt(itemListLine.next()),Integer.parseInt(itemListLine.next()));
                books.add(aBook);
                entireInventory.put(aBook.getItemID(),aBook);
            }
            else if (itemTYPE.equals("Music")) {
                Music aMusic = new Music(itemID,itemListLine.next(),itemListLine.next(),itemListLine.next(),Integer.parseInt(itemListLine.next()),Integer.parseInt(itemListLine.next()));
                musics.add(aMusic);
                entireInventory.put(aMusic.getItemID(),aMusic);

            }
            else if (itemTYPE.equals("Movie")) {
                Movie aMovie = new Movie(itemID,itemListLine.next(),itemListLine.next(),Integer.parseInt(itemListLine.next()),Integer.parseInt(itemListLine.next()));
                movies.add(aMovie);
                entireInventory.put(aMovie.getItemID(),aMovie);
            }

        }
        itemListReader.close();
        System.out.println("File loaded.");
    }

    /**
     * Saves the full current Items data into text file
     *
     * @param entireInventory Hashmap containing all item objects by ID number
     * @param books LinkedList, Not used atm
     * @param musics LinkedList, Not used atm
     * @param movies LinkedList, Not used atm
     * @throws FileNotFoundException Throws to main if file not found
     */
    public static void saveToFile(HashMap<Integer,Item> entireInventory, LinkedList<Book> books, LinkedList<Music> musics, LinkedList<Movie> movies) throws FileNotFoundException {

        // Name of file that will be created
        String outputFile = "ItemsOutput";
        // Create PrintWriter object and give file name
        PrintWriter outFile = new PrintWriter(outputFile);

        // Goes through all Items and prints them to storage text file in same formats as they came in
        for (Integer id : entireInventory.keySet()) {
            if (entireInventory.get(id).getItemType().equals("Book")) {
                outFile.print(entireInventory.get(id).getItemID() + ","
                            + entireInventory.get(id).getItemType() + ","
                            + entireInventory.get(id).getItemName() + ","
                            + ((Book) entireInventory.get(id)).getBookAuthor() + ","
                            + entireInventory.get(id).getItemGenre() + ","
                            + ((Book) entireInventory.get(id)).getBookPages() + ","
                            + entireInventory.get(id).getItemCopies() + "\n");
            }
            else if (entireInventory.get(id).getItemType().equals("Music")) {
                outFile.print(entireInventory.get(id).getItemID() + ","
                            + entireInventory.get(id).getItemType() + ","
                            + entireInventory.get(id).getItemName() + ","
                            + ((Music) entireInventory.get(id)).getMusicArtist() + ","
                            + entireInventory.get(id).getItemGenre() + ","
                            + ((Music) entireInventory.get(id)).getMusicSongCount() + ","
                            + entireInventory.get(id).getItemCopies() + "\n");
            }
            else if (entireInventory.get(id).getItemType().equals("Movie")) {
                outFile.print(entireInventory.get(id).getItemID() + ","
                            + entireInventory.get(id).getItemType() + ","
                            + entireInventory.get(id).getItemName() + ","
                            + entireInventory.get(id).getItemGenre() + ","
                            + ((Movie) entireInventory.get(id)).getMovieLengthInMin() + ","
                            + entireInventory.get(id).getItemCopies() + "\n");
            }
        }
        outFile.close();

        System.out.println("File saved as " + outputFile + ".txt");
    }


}
