import java.util.Random;

public class PartA {
    public static void main(String[] args) {
        Stats[] statsArray = new Stats[7];
        genNumbers(statsArray);
        outputResults(statsArray);
    }

    public static void genNumbers(Stats[] statsArray){

        Random rand = new Random();

        for ( int i = 0; i < statsArray.length; i++) {
            int currentMIN = 20001;
            int currentMAX = -1;
            double currentAVG = currentMAX + currentMIN / 2.0;
            for ( int j = 0; j < 50; j++) {
                int number = rand.nextInt(20000)+1;
                if ( number > currentMAX ) {
                    currentMAX = number;
                }
                if ( number < currentMIN) {
                    currentMIN = number;
                }
                currentAVG = currentMAX + currentMIN / 2.0;
            }
            statsArray[i] = new Stats(currentMIN,currentMAX,currentAVG);
        }

    }

    public static void outputResults(Stats[] statsArray){

        int totalMin = 0;
        int totalMax = 0;
        double totalAvg = 0;

        for ( int i = 0; i < statsArray.length; i++) {
            System.out.print("Minimum: " + statsArray[i].getMinimum() + "\nMaximum: " + statsArray[i].getMaximum() + "\nAverage: " + statsArray[i].getAverage() + "\n");
            System.out.println();
        }
        for ( int i = 0; i < statsArray.length; i++) {
            totalMin = totalMin + statsArray[i].getMinimum();
            totalMax = totalMax + statsArray[i].getMaximum();
            totalAvg = totalAvg + statsArray[i].getAverage();
        }

        System.out.println("Total Average Minimum: " + totalMin/statsArray.length + "\nTotal Average Maximum: " + totalMax/statsArray.length + "\nTotal Average Average: " + totalAvg/statsArray.length);
    }
}
