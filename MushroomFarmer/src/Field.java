import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Field {

    private Mound[][] fieldMounds;                  // 2D array of Mounds
    private int initialLifespan;                    // How long a single mushroom lives
    private final int[] firstLocation = new int[2]; // Array to store x,y location of first spore/mushroom
    private int currentDay;                         // Integer value of what day it is
    private int mushroomMAX = 0;                    // Most amount of mushrooms on the field at any time
    private int dayOfMAX = 0;                       // Day that had the most amount of mushrooms

    /**
     *  Sets up field with mounds to the size and nutrition read in from file
     *  as well as location in field of first spore/mushroom spawn.
     *
     * @param fileName Name of user input file with initial field setup information
     * @throws FileNotFoundException error gets thrown to main
     */
    public void setupField( String fileName) throws FileNotFoundException {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        if (fileName == null) {

            // Collect name of file from user
            System.out.println("Please enter the name of the field setup file: ");
            fileName = keyboard.nextLine();

        }

        File fieldFile;

        // Create a File object to hold field#.txt file
        fieldFile = new File(fileName);

        // Check for file existence/ potential typos
        while(!fieldFile.exists()) {

            System.out.println("Invalid entry! Please enter the name of the field setup file: ");
            fileName = keyboard.nextLine();
            fieldFile = new File(fileName);
        }

        // Plug file into Scanner for ease of manipulation
        Scanner fileReader = new Scanner(fieldFile);

        // Get and store the initial lifespan of a mushroom
        // Store each line as separate entity
        String line = fileReader.nextLine();
        Scanner stringReader = new Scanner(line);
        // Collect String data on every side of a "="
        stringReader.useDelimiter("=");
        stringReader.next();
        initialLifespan = Integer.parseInt(stringReader.next());

        // Get and store the initial position in the field of first mushroom
        // Store each line as separate entity
        line = fileReader.nextLine();
        stringReader = new Scanner(line);
        // Collect String data on every side of a "="
        stringReader.useDelimiter("=");
        stringReader.next();
        stringReader = new Scanner(stringReader.next());
        // Collect String data on every side of a ","
        stringReader.useDelimiter(",");
        firstLocation[0] = Integer.parseInt(stringReader.next());
        firstLocation[1] = Integer.parseInt(stringReader.next());

        // Get and store the initial nutrition in the field at each mound
        // Counter for shifting down a row each loop
        int counter = 0;

        // Check for each line of file until end
        while(fileReader.hasNextLine()) {
            // Store each line as separate entity
            line = fileReader.nextLine();
            stringReader = new Scanner(line);

            // fieldMounds 2D array made of the size of the single String, adding one
            // to equalize the amount of commas to numbers and divided by two
            if (fieldMounds == null) {
                fieldMounds = new Mound[(line.length() + 1) / 2][(line.length() + 1) / 2];
            }

            // Initializing fieldMound array Mound objects with read in nutrition values.
            stringReader.useDelimiter(",");
            for ( int i = 0; i < (line.length() + 1) / 2 ; i++) {
                fieldMounds[counter][i] = new Mound(Integer.parseInt(stringReader.next()));
            }

            // Increments row down one
            counter+= 1;

        }

        // Sets up the first mushroom from spore at the read in location
        fieldMounds[firstLocation[0]][firstLocation[1]].addSpores(1);
        fieldMounds[firstLocation[0]][firstLocation[1]].sporeIntoMushroom(initialLifespan);

        // Day Zero
        currentDay = 0;
        // Close file
        fileReader.close();
        System.out.println("File loaded.");

        // Print day and field, tru prints mushrooms, false prints nutrients.
        System.out.println("Day:" + currentDay);
        printField(true);

    }

    /**
     * Propagates spores from each mushroom that expends its lifespan up,down,left,right.
     * Turns spores into mushrooms if nutrients allow. Progresses day by one and keeps track
     * of day with most mushrooms active.
     */
    public void farmSimulation() {

        int countOfMushrooms;

        // Goes through each mound expends a day of life from mushrooms and collects spores from dead
        // those spores are added to mound up,down,left and right for each mushroom that died.
        do {
            for (int i = 0; i < fieldMounds.length; i++) {
                for (int j = 0; j < fieldMounds[i].length; j++) {
                    int spores = fieldMounds[i][j].expendLife();

                    // Mound above
                    if (i > 0) {
                        fieldMounds[i - 1][j].addSpores(spores);
                    }
                    // Mound below
                    if (i < fieldMounds.length - 1) {
                        fieldMounds[i + 1][j].addSpores(spores);
                    }
                    // Mound left
                    if (j > 0) {
                        fieldMounds[i][j - 1].addSpores(spores);
                    }
                    // Mound right
                    if (j < fieldMounds[i].length - 1) {
                        fieldMounds[i][j + 1].addSpores(spores);
                    }
                }
            }

            countOfMushrooms = 0;

            // Spores turn into mushrooms if nutrients are available in that mound
            for (int i = 0; i < fieldMounds.length; i++) {
                for (int j = 0; j < fieldMounds[i].length; j++) {
                    fieldMounds[i][j].sporeIntoMushroom(initialLifespan);
                    //Collects mushroom count for that day in the field
                    countOfMushrooms = countOfMushrooms + fieldMounds[i][j].getMushroomCount();
                }
            }

            // Advance day by 1
            currentDay += 1;

            // Keep track of day with must mushrooms
            if (countOfMushrooms > mushroomMAX) {
                mushroomMAX = countOfMushrooms;
                dayOfMAX = currentDay;
            }

            // Print day and mushroom field
            System.out.println("Day:" + currentDay);
            printField(true);

        // Continues until last mushroom dies
        }while(countOfMushrooms > 0);

    }

    /**
     * Prints out state of field with shown mushroom count in each mound if passed true
     * Prints out state of field with shown nutrient count in each mound if passed false
     *
     * @param printMushrooms true prints mushrooms, false prints nutrients
     */
    public void printField(boolean printMushrooms) {

        // Loops through all mounds
        for ( int i = 0; i < fieldMounds.length; i++) {
            for ( int j = 0; j < fieldMounds[i].length; j++) {
                // Prints mushrooms
                if (printMushrooms) {
                    System.out.print("|M" + fieldMounds[i][j].getMushroomCount());
                }
                // Prints nutrients
                else {
                    System.out.print("|" + fieldMounds[i][j].getNutrientRemaining());
                }
            }
            System.out.print("|\n");
        }
        System.out.println();
    }

    /**
     * Prints out day with the most mushrooms active at once, and nutrients of final field.
     */
    public void summarizeSimulation() {

        System.out.println("The maximum number of mushrooms on a single day was " + mushroomMAX +" on day " + dayOfMAX);
        System.out.println("The nutrients still remaining in the field looks like this:");
        printField(false);

    }

}
