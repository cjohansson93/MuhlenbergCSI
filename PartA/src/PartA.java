/*
Christian Johansson
3/19/2021
 */

import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a phrase containing one or more words:");
        String userPhrase = keyboard.nextLine();

        boolean result = shoutingWhisper(userPhrase);

        if (result) {
            System.out.println(userPhrase.toUpperCase());
            System.out.println("Shhh! No shouting in the Library!");
        }
        else {
            System.out.println(userPhrase.toLowerCase());
            System.out.println("Can't hear you. Can stop whispering?");
        }


    }

    public static boolean shoutingWhisper( String phrase) {
        int shouting = 0;
        int whispering = 0;

        for (int i = 0; i < phrase.length() ; i++) {
            if (Character.isLetter(phrase.charAt(i))) {
                if (Character.isUpperCase(phrase.charAt(i))) {
                    shouting += 1;
                }
                else {
                    whispering += 1;
                }
            }
            else {
                continue;
            }

        }
        if (shouting > whispering) {
            return true;
        }
        else {
            return false;
        }
    }
}