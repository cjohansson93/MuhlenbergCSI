/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        04/09/2021
Instructor:  Dr. Helsing
Description: This program takes a poem in a txt file and writes the title, author
             number of lines and first three lines to a Output.txt file
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Poem {
    public static void main(String[] args) throws FileNotFoundException {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        String title = null;
        String author = null;
        String fileName;
        File poem;

        // Create an ArrayList object to store poem lines
        ArrayList<String> poemLines = new ArrayList<String>();

        System.out.println("Please enter the name of the file: ");
        fileName = keyboard.nextLine();

        // Create a File object to hold poem.txt file
        poem = new File(fileName);

        // Check to make sure file exists
        while(!poem.exists()) {

            System.out.println("Invalid entry! Please enter the name of the file: ");
            poem = new File(fileName);
        }

        // Plug file to scanner
        Scanner poemReader = new Scanner(poem);

        // Check for each line of file until end
        while(poemReader.hasNextLine()) {

            // Gates that fill in top to bottom, to assign title to first and author to second line
            // Rest fall under else
            if (title == null) {
                title = poemReader.nextLine();
            }
            else if (author == null) {
                author = poemReader.nextLine();
            }
            else {
                // Stores lines in ArrayList
                poemLines.add(poemReader.nextLine());
            }
        }
        poemReader.close();

        // Create PrintWriter object and give file name
        PrintWriter outFile = new PrintWriter("Output");

        // Print title, author and first 3 lines into file
        outFile.println(title);
        outFile.println(author);
        outFile.println(poemLines.size());

        for( int i = 0; i < 3 ; i++) {
            outFile.println(poemLines.get(i));
        }

        outFile.close();


    }

}
