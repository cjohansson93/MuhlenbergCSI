/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        11/23/2021
Instructor:  Professor Silveyra
Description: The menu for Dijkstras algorithm, BFS & DFS, and loading a text file.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DijkstrasAlgorithm {
    public static void main(String[] args) throws FileNotFoundException {
        // Call to Hash and Heap constructors
        AdjacencyList theAdjacencyList = new AdjacencyList(0);
        Heap theHeap = new Heap(1);
        String fileName = null;
        Stack stack = new Stack();
        CircularQueue queue = new CircularQueue(1);

        // Create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        int choice = 0;
        while ( choice != 4 ) {

            // Menu controlled by simple number switch
            System.out.println("------------------------ Main Menu ------------------------");
            System.out.println("1. Find the shortest path");
            System.out.println("2. DFS and BFS");
            System.out.println("3. Load new file");
            System.out.println("4. Exit Program");
            System.out.println("Enter the number corresponding to operation to be preformed: ");
            try {
                choice = keyboard.nextInt();
            }catch (InputMismatchException e){
                choice = 5;
            }

            if (choice == 1 || choice == 2 || choice == 3 || choice == 4) {
                switch (choice) {
                    case 1: // Shortest path
                        keyboard.nextLine();
                        if (fileName == null) {

                            // Error for no file
                            System.out.println("There is no file loaded. please load a file first. ");
                            break;

                        }
                        // dijkstras
                        boolean[] visited = new boolean[theAdjacencyList.list.length];
                        NodeHeap[] vertices = new NodeHeap[theAdjacencyList.list.length];
                        int numVisits = 0;
                        theHeap = new Heap(theAdjacencyList.list.length+1);
                        for (int i = 0; i < theAdjacencyList.list.length; i++) {
                            vertices[i] = new NodeHeap(false, 0, 0);
                        }
                        theHeap.insert(0, vertices[0]);
                        while(numVisits < visited.length){
//                            if (queue.isEmpty()) {
//                                for (int i = 0; i < visited.length; i++){
//                                    if (!visited[i]) {
//                                        queue.enqueue(i);
//                                        bfs = bfs + "|";
//                                        break;
//                                    }
//                                }
//                            }

                            int popped = queue.dequeue();
                            if (!visited[popped]){
                                if (theAdjacencyList.list[popped] != null) {
                                    ListNode temp = theAdjacencyList.list[popped].getNext();
                                    while (temp != null) {
                                        queue.enqueue(temp.getTo());
                                        temp = temp.getNext();
                                    }
                                }
                                visited[popped] = true;
                                numVisits++;
                            }
                        }
                        break;
                    case 2: // DFS & BFS
                        keyboard.nextLine();
                        if (fileName == null) {

                            // Error for no file
                            System.out.println("There is no file loaded. Please load a file first. ");
                            break;

                        }
                        // bfs
                        visited = new boolean[theAdjacencyList.list.length];
                        numVisits = 0;
                        String bfs = "";
                        queue = new CircularQueue(theAdjacencyList.list.length*theAdjacencyList.list.length);
                        queue.enqueue(0);
                        while(numVisits < visited.length){
                            if (queue.isEmpty()) {
                                for (int i = 0; i < visited.length; i++){
                                    if (!visited[i]) {
                                        queue.enqueue(i);
                                        bfs = bfs + "|";
                                        break;
                                    }
                                }
                            }

                            int popped = queue.dequeue();
                            if (!visited[popped]){
                                if (theAdjacencyList.list[popped] != null) {
                                    ListNode temp = theAdjacencyList.list[popped].getNext();
                                    while (temp != null) {
                                        queue.enqueue(temp.getTo());
                                        temp = temp.getNext();
                                    }
                                }
                                visited[popped] = true;
                                numVisits++;
                                bfs = bfs + popped + ",";
                            }
                        }
                        System.out.println(bfs);
                        // dfs
                        visited = new boolean[theAdjacencyList.list.length];
                        numVisits = 0;
                        String dfs = "";
                        stack = new Stack();
                        stack.push(0);
                        while(numVisits < visited.length){
                            if (stack.isEmpty()) {
                                for (int i = 0; i < visited.length; i++){
                                    if (!visited[i]) {
                                        stack.push(i);
                                        dfs = dfs + "|";
                                        break;
                                    }
                                }
                            }

                            int popped = stack.pop();
                            if (!visited[popped]){
                                if (theAdjacencyList.list[popped] != null) {
                                    ListNode temp = theAdjacencyList.list[popped].getNext();
                                    while (temp != null) {
                                        stack.push(temp.getTo());
                                        temp = temp.getNext();
                                    }
                                }
                                visited[popped] = true;
                                numVisits++;
                                dfs = dfs + popped + ",";
                            }
                        }
                        System.out.println(dfs);
                        break;
                    case 3: // Load file
                        keyboard.nextLine();
                        if (fileName == null) {

                            // Collect name of file from user
                            System.out.println("Please enter the name of the text file: ");
                            fileName = keyboard.nextLine();

                        }

                        File listFile;

                        // Create a File object to hold text file
                        listFile = new File(fileName);

                        // Check for file existence/ potential typos
                        while(!listFile.exists()) {

                            System.out.println("Invalid entry! Please enter the name of the list setup file: ");
                            fileName = keyboard.nextLine();
                            listFile = new File(fileName);
                        }

                        // Plug file into Scanner for ease of manipulation
                        Scanner fileReader = new Scanner(listFile);

                        // Get and store the first line
                        // Store each line as separate entity
                        String line = fileReader.nextLine();
                        Scanner stringReader = new Scanner(line);
                        // Collect String data on every side of a " "
                        stringReader.useDelimiter(" ");
                        theAdjacencyList = new AdjacencyList(Integer.parseInt(stringReader.next()));

                        int numLines = Integer.parseInt(stringReader.next());
                        for (int i = 0; i < numLines; i++){
                            // Store each line as separate entity
                            line = fileReader.nextLine();
                            stringReader = new Scanner(line);
                            // Collect String data on every side of a " "
                            stringReader.useDelimiter(" ");
                            int fromTemp = Integer.parseInt(stringReader.next());
                            int to = Integer.parseInt(stringReader.next());
                            int weight = Integer.parseInt(stringReader.next());
                            theAdjacencyList.insert(fromTemp, to, weight);
                        }

                        // Close file
                        fileReader.close();
                        System.out.println("File loaded.");

                        break;
                    case 4: // Exit program
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
