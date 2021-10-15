/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        05/07/2021
Instructor:  Dr. Helsing
Description: This program takes in a txt file and stores the words and their
             frequency in a HashMap, then prints them out in a satisfying format
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class FreqCountV2 {
    public static void main(String[] args) throws Exception {

        // Create HashMap and HashSet
        HashMap<String, Integer> termFrequency = new HashMap<>();
        HashSet<String> stopWords = new HashSet<>();
        // Call read in and print out methods
        readStopWordsFile(stopWords);
        readTextFile(termFrequency,stopWords);
        outputFreq(termFrequency);
    }

    /**
     * Reads in and stores stop words in a HashSet from a text file of only single word lines
     *
     * @param stopWords HashSet of String "stop" words
     * @throws FileNotFoundException throws exception to main
     */
    private static void readStopWordsFile( HashSet<String> stopWords) throws FileNotFoundException {
        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter the name of the stop words file: ");
        String fileName = keyboard.nextLine();

        // Create a File object to hold full Text.txt file
        File fullStopText = new File(fileName);

        // Check to make sure file exists
        while(!fullStopText.exists()) {

            System.out.println("Invalid entry! Please enter the name of the stop words file: ");
            fullStopText = new File(fileName);
        }

        // Plug file to scanner
        Scanner textReader = new Scanner(fullStopText);

        // Check for each word of file until end
        while(textReader.hasNext()) {
            // Take the word trim whitespace and make lowercase
            String nextWord = textReader.next().trim().toLowerCase();

            // Add stop words to HashSet
            stopWords.add(nextWord);

        }
        textReader.close();

       // for (String word: stopWords){
       //    System.out.println(word);
        //}
    }

    /**
     * Takes text file with words separated by spaces,
     * stores words and their frequency in HashMap.
     *
     * @param termFrequency HashMap of String key and Integer value for count
     * @throws FileNotFoundException throws exception to main
     */
    private static void readTextFile(HashMap<String, Integer> termFrequency, HashSet<String> stopWords) throws FileNotFoundException {
        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter the name of the text file: ");
        String fileName = keyboard.nextLine();

        // Create a File object to hold full Text.txt file
        File fullText = new File(fileName);

        // Check to make sure file exists
        while(!fullText.exists()) {

            System.out.println("Invalid entry! Please enter the name of the text file: ");
            fullText = new File(fileName);
        }

        // Plug file to scanner
        Scanner textReader = new Scanner(fullText);

        // Check for each word of file until end
        while(textReader.hasNext()) {
            // Take the word trim whitespace and make lowercase
            String nextWord = textReader.next().trim().toLowerCase();
            // If the word is on the no flight list (stop words)
            if (!stopWords.contains(nextWord)) {
                // If the word doesn't exist
                if (termFrequency.get(nextWord) == null ) {
                    termFrequency.put(nextWord, 1);
                }
                // If the word exists increment its count
                else {
                    termFrequency.put(nextWord, termFrequency.get(nextWord) + 1);
                }
            }

        }
        textReader.close();
    }

    /**
     * Prints out words and their frequency count from HashMap in satisfying format
     *
     * @param termFrequency HashMap of String key and Integer value for count
     */
    private static void outputFreq(HashMap<String, Integer> termFrequency) {

        System.out.println("Word frequency:\n");
        // Stores the size of the largest word for size formatting a pretty print out
        int biggestWord = 0;
        for (String word : termFrequency.keySet()) {
            if (word.length() > biggestWord) {
                biggestWord = word.length();
            }
        }

        // Prints out words left justified with space equal to the size of biggest word, then count
        for (String word : termFrequency.keySet()) {
            Formatter formatter = new Formatter();
            formatter.format("%-"+biggestWord+"s: %d",word,termFrequency.get(word));
            System.out.println(formatter);
        }


    }
}
