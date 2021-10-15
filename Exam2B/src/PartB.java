import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> isInt = new ArrayList<>();

        Scanner keyboard = new Scanner(System.in);

        String fileName;
        File readNumbers;
        int total = 0;

        System.out.println("Please enter the name of the file: ");
        fileName = keyboard.nextLine();

        readNumbers = new File(fileName);

        while(!readNumbers.exists()) {

            System.out.println("Invalid entry! Please enter the name of the file: ");
            readNumbers = new File(fileName);
        }

        Scanner numberReader = new Scanner(readNumbers);

        while(numberReader.hasNextLine()) {

            String line = numberReader.nextLine();

            try {
                int isInteger = Integer.parseInt(line);
                isInt.add(isInteger);
            }
            catch (NumberFormatException e) {
                System.out.println(line + " is not an integer");
            }



        }
        numberReader.close();

        for (int i = 0; i < isInt.size(); i++ ) {
            System.out.println(isInt.get(i));
            total = total + isInt.get(i);
        }
        System.out.println("The total is: " + total);

    }
}
