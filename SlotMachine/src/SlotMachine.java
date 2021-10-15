/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        03/19/2021
Instructor:  Dr. Helsing
Description: This program is a functional 3x3 slot machine with ability to deposit money from
             a wallet, change bet, play and win in 3's and 2's, and cash out.
*/

import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

public class SlotMachine {
    public static void main(String[] args) {

        // Create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Variables
        double wallet = 100.0; // How much you start with
        double machineBalance = 0.00; // Initial slot machine balance or credit
        double betAmount = 1.00; // Initial bet
        boolean endGame = false; // When true at cash out, it ends the game, otherwise keeps game loop going

        // Array that holds unicode symbols as icons for slot machine reels
        char[] slotSymbols = {'\u0024','\u277c','\u2606','\u2665','\u2620','\u2622','\u2655'};
        // Array that will house randomly assigned icons in 3x3 grid
        char[][] gameArray3x3 = new char[3][3];

        // Welcome message, starting bet and basic rules for winning
        System.out.print("Welcome to The House Always Wins Slots." +
                "\nWhere you play to prove me wrong!" +
                "\nYou win by Three of a kind on any single row, column, or diagonal. Payout is 3X the bet amount." +
                "\nTwo of a kind adjacent to each other on any single row, column, or diagonal. Payout is 2X the bet amount." +
                "\nMultiple instances of two or three get summed." +
                "\nStarting bet is $" + betAmount + ", but can be changed by the menu.\n");

        // Game loop
        while ( !endGame ) {

            // Menu controlled by simple number switch
            System.out.println("1. Add money to the Machine");
            System.out.println("2. Change bet Amount");
            System.out.println("3. Spin the Wheel!");
            System.out.println("4. Cash out and Leave");
            System.out.println("Enter the number corresponding to what you'd like to do: ");
            int menuChoice = keyboard.nextInt();

            if ( menuChoice == 0 || menuChoice == 1 || menuChoice == 2 || menuChoice == 3 || menuChoice == 4 ){
                switch (menuChoice) {
                    case 1: // Add money
                        double[] twoReturnValues = moneyToMachine( wallet, machineBalance);
                        wallet = twoReturnValues[0];
                        machineBalance = twoReturnValues[1];
                        break;
                    case 2: // Change bet
                        betAmount = changeBet$( betAmount );
                        break;
                    case 3: // Play game
                        machineBalance = playGame( betAmount, machineBalance, gameArray3x3, slotSymbols);
                        break;
                    case 4: // Cash out and end game/program
                        cashOut( wallet, machineBalance);
                        endGame = true;
                        break;
                }
            }
            else {
                // Check to stop invalid menu inputs
                System.out.println("That is an invalid entry! Try again.'" +
                        "");
            }
        }

    }

    /**
     * This methods purpose is to allow the player to deposit their money into the machine as credit to play with
     *
     * @param wallet This is the money the player has on them to add to machine balance
     * @param machineMoney This is the money the machine has in its balance
     * @return Returns an updated wallet amount and machines new balance based on how much was added
     */
    public static double[] moneyToMachine(double wallet, double machineMoney) {
        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Your current wallet balance is: $" + wallet +
                "\nYour current machine balance is: $" + machineMoney);
        System.out.println("How much would you like to deposit in dollars?");
        double depositAmount = keyboard.nextDouble();
        // Check to see if user has enough in wallet to deposit that amount
        if ( wallet >= depositAmount ) {
            System.out.println("Your new wallet balance is: $" + (wallet - depositAmount) +
                    "\nYour new machine balance is: $" + (machineMoney + depositAmount));
            return new double[]{ wallet - depositAmount , machineMoney + depositAmount };
        }
        // Informs user if they don't have enough to cover deposit
        else {
            System.out.println("You do not have enough to cover that deposit amount.");
            return new double[]{ wallet , machineMoney };
        }
    }

    /**
     * This method is used to change the slot machines current bet amount with a positive user specified one
     *
     * @param betAmount Is the current bet amount, is returned if entered bet is invalid
     * @return Returns either an updated valid bet amount (bet > 0) or returns the current bet if invalid
     */
    public static double changeBet$(double betAmount) {
        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Allows a positive bet change from the user
        System.out.println("How much would you like to bet?");
        double bet = keyboard.nextDouble();
        if ( bet > 0) {
            System.out.println("New bet is set at $" + bet );
            return bet;
        }
        // If positive check fails will inform the user
        else {
            System.out.println("That is an invalid bet amount, bet will remain the same.");
            return betAmount;
        }
    }

    /**
     * This method is the slot machine game, shows a 3x3 grid of symbols, calculates win/loss
     * in the form of 2 and 3 of a kind and displays messages to accompany them.
     *
     * @param betAmount The cost of playing, is subtracted from machines balance at start to play
     *                  if insufficient will deny play
     * @param machineMoney The current balance of usable credit in the slot machine
     * @param gameArray Holds the 3x3 grid that will make up the visible slot machine screen
     *                  is populated randomly with symbols from symbols array.
     * @param symbols Contains the unicode characters used as symbols to populate the 3x3 game array
     * @return Returns the machines new balance/credit from win or loss, or unchanged if insufficient
     *         to cover bet.
     */
    public static double playGame(double betAmount, double machineMoney, char[][] gameArray, char[] symbols) {
        //create a Random object to generate random numbers.
        Random rand = new Random();

        // Checks to see if there is enough available credit to cover bet
        if (betAmount <= machineMoney) {
            machineMoney = machineMoney - betAmount; // Subtracts bet from machine balance

            // for loop to populate 3x3 array with symbols/icons and displays them in a grid
            for (int i = 0; i < gameArray.length; i++) {
                for (int u = 0; u < gameArray.length; u++) {
                    gameArray[i][u] = symbols[rand.nextInt(6)];
                    System.out.print("\t" + gameArray[i][u]);
                }
                System.out.println("\n");
            }



            double total = 0.00; // Stores winnings in dollars
            int threeOfKind = 0; // Counts how many three of a kind matches
            int twoOfKind = 0; // Counts how many two of a kind matches

            // three of a kind straight line conditionals, when true add to total and counter. (6 of them)
            if (gameArray[0][0] == gameArray[0][1] && gameArray[0][1] == gameArray[0][2]) {
                total += (betAmount * 3);
                threeOfKind += 1;
            }
            if (gameArray[1][0] == gameArray[1][1] && gameArray[1][1] == gameArray[1][2]) {
                total += (betAmount * 3);
                threeOfKind += 1;
            }
            if (gameArray[2][0] == gameArray[2][1] && gameArray[2][1] == gameArray[2][2]) {
                total += (betAmount * 3);
                threeOfKind += 1;
            }
            if (gameArray[0][0] == gameArray[1][0] && gameArray[1][0] == gameArray[2][0]) {
                total += (betAmount * 3);
                threeOfKind += 1;
            }
            if (gameArray[0][1] == gameArray[1][1] && gameArray[1][1] == gameArray[2][1]) {
                total += (betAmount * 3);
                threeOfKind += 1;
            }
            if (gameArray[0][2] == gameArray[1][2] && gameArray[1][2] == gameArray[2][2]) {
                total += (betAmount * 3);
                threeOfKind += 1;
            }
            // three of a kind diagonal conditionals, when true add to total and counter. (2 of them)
            if (gameArray[0][0] == gameArray[1][1] && gameArray[1][1] == gameArray[2][2]) {
                total += (betAmount * 3);
                threeOfKind += 1;
            }
            if (gameArray[0][2] == gameArray[1][1] && gameArray[1][1] == gameArray[2][0]) {
                total += (betAmount * 3);
                threeOfKind += 1;
            }

            // two of a kind straight line conditionals, when true add to total and counter. (12 of them)
            if (gameArray[0][0] == gameArray[0][1] && gameArray[0][1] != gameArray[0][2]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[0][0] != gameArray[0][1] && gameArray[0][1] == gameArray[0][2]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[0][2] == gameArray[1][2] && gameArray[1][2] != gameArray[2][2]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[0][2] != gameArray[1][2] && gameArray[1][2] == gameArray[2][2]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[2][0] == gameArray[2][1] && gameArray[2][1] != gameArray[2][2]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[2][0] != gameArray[2][1] && gameArray[2][1] == gameArray[2][2]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[0][0] == gameArray[1][0] && gameArray[1][0] != gameArray[2][0]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[0][0] != gameArray[1][0] && gameArray[1][0] == gameArray[2][0]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[0][1] == gameArray[1][1] && gameArray[1][1] != gameArray[2][1]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[0][1] != gameArray[1][1] && gameArray[1][1] == gameArray[2][1]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[1][0] == gameArray[1][1] && gameArray[1][1] != gameArray[1][2]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[1][0] != gameArray[1][1] && gameArray[1][1] == gameArray[1][2]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            // two of a kind diagonal conditionals, when true add to total and counter. (8 of them)
            if (gameArray[0][0] == gameArray[1][1] && gameArray[1][1] != gameArray[2][2]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[0][0] != gameArray[1][1] && gameArray[1][1] == gameArray[2][2]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[2][0] == gameArray[1][1] && gameArray[1][1] != gameArray[0][2]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[2][0] != gameArray[1][1] && gameArray[1][1] == gameArray[0][2]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[1][0] == gameArray[0][1]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[0][1] == gameArray[1][2]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[1][2] == gameArray[2][1]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }
            if (gameArray[2][1] == gameArray[1][0]) {
                total += (betAmount * 2);
                twoOfKind += 1;
            }

            // Print out boxes based on winning/losing and what kind of matches
            if (total > 0.00) {
                if (threeOfKind > 0 && twoOfKind == 0) {
                    /*System.out.println("We got ourselves a winner here!\n" +
                            "You managed to get " + threeOfKind + " three of a kind!\n" +
                            "Total payout of $" + total);*/
                    JOptionPane.showMessageDialog(null, "You managed to get " + threeOfKind + " three of a kind!\nTotal payout of $" + total,
                            "We got ourselves a winner here!", JOptionPane.INFORMATION_MESSAGE);
                    return (machineMoney + total);
                } else if (threeOfKind == 0 && twoOfKind > 0) {
                    /*System.out.println("Woah! Think I'm seeing doubles!\n" +
                            "You managed to get " + twoOfKind + " two of a kind!\n" +
                            "Total payout of $" + total);*/
                    JOptionPane.showMessageDialog(null, "You managed to get " + twoOfKind + " two of a kind!\nTotal payout of $" + total,
                            "Woah! Think I'm seeing doubles!", JOptionPane.INFORMATION_MESSAGE);
                    return (machineMoney + total);
                } else {
                    /*System.out.println("Winner, Winner! Chicken Dinner!\n" +
                            "You managed to get " + twoOfKind + " two of a kind!\n" +
                            "and got " + threeOfKind + " three of a kind!\n" +
                            "Total payout of $" + total);*/
                    JOptionPane.showMessageDialog(null, "You managed to get " + twoOfKind + " two of a kind!\n" +
                                    "and got " + threeOfKind + " three of a kind!\n" +
                                    "Total payout of $" + total,
                            "Winner, Winner! Chicken Dinner!", JOptionPane.INFORMATION_MESSAGE);
                    return (machineMoney + total);
                }
            } else {
                /*System.out.println("Not a win in sight! Better luck next time!");*/
                JOptionPane.showMessageDialog(null, "Better luck next time!",
                        "Not a win in sight!", JOptionPane.PLAIN_MESSAGE);
            }

        }
        // Print out if they didn't have enough slot machine balance/credit to cover bid
        else {
            System.out.println("You lack the machine balance to cover that bet.\n" +
                    "Please deposit more money to the machine or change your bet.");
            return machineMoney;
        }
        return machineMoney;
    }

    /**
     * This method shows the final loss/ winning amounts in relation to the hard coded
     * starting amount $100 and the final amount the user will have in dollars
     *
     * @param wallet Final amount the user has on them, not in the machine
     * @param machineBalance Final amount in the machines balance to be added to wallet
     */
    public static void cashOut(double wallet, double machineBalance) {
        // Made money print out
        if (wallet + machineBalance > 100.00) {
            System.out.println("You have gained $" + ((wallet + machineBalance) - 100) +
                    "\nFor a total of $" + ( wallet + machineBalance ) +
                    "\nThanks for playing!");
        }
        // Broke even print out
        if (wallet + machineBalance == 100.00) {
            System.out.println("You have broke even for a total of $" + ( wallet + machineBalance ) +
                    "\nHope it was fun either way!");
        }
        // Lost money print out
        if (wallet + machineBalance < 100.00) {
            System.out.println("You have lost $" + (100 - (wallet + machineBalance)) +
                    "\nFor a total of $" + ( wallet + machineBalance ) +
                    "\nThe house ALWAYS wins! Mohahaha..");
        }
    }
}