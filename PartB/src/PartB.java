//Christian Johansson

import java.util.Scanner;
import java.util.Random;

public class PartB {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        Random rand = new Random();

        int rightMax = 0;
        int leftMax = 0;
        int positionNow = 0;
        int numberMoves = rand.nextInt(11) + 5;

        for (int i = 0; i < numberMoves; i++) {
            int oneOrZero = rand.nextInt(2);
            if (oneOrZero == 0) {
                positionNow -= 1;
                if (positionNow < leftMax) {
                    leftMax = positionNow;
                }
            } else {
                positionNow += 1;
                if (positionNow > rightMax) {
                    rightMax = positionNow;
                }
            }
        }

        System.out.println("I moved a total of " + numberMoves + " times.");
        System.out.println("I stopped at position " + positionNow);
        System.out.println("My furthest left position was " + leftMax);
        System.out.println("My furthest right position was " + rightMax);
        System.out.println("My average position was " + ((leftMax + rightMax)/2));
    }
}