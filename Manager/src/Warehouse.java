/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        03/26/2021
Instructor:  Dr. Helsing
Description: This program acts as a storage location for information pertaining to a product and is used
             in the program Ordersystem
*/

import java.util.Scanner;

public class Warehouse {

    private int warehouseGoods;

    // basic constructor
    public Warehouse( int goods) {
        this.warehouseGoods = goods;
    }

    public int getWarehouseGoods() {
        return warehouseGoods;
    }

    public void addGoods() {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        System.out.println("How many goods would you like to add?:");
        this.warehouseGoods += keyboard.nextInt();
    }

    public void removeGoods() {

        // create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        System.out.println("How many goods would you like to remove?:");
        int goodsRemove = keyboard.nextInt();
        if (this.warehouseGoods >= goodsRemove) {
            this.warehouseGoods -= goodsRemove;
        }
        else {
            System.out.println("There are insufficient goods to remove that quantity");
        }
    }
}
