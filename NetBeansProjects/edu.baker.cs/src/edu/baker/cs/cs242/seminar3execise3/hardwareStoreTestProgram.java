/*
 * @(#)hardwareStoreTestProgram.java        1.0 8/26/10
 *
 * Copyright (c) 2010 Rob Just
 */
package edu.baker.cs.cs242.seminar3execise3;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class: hardwareStoreTestProgram
 * Description: This program displays a menu for the Friendly Hardware Store.
 * The use can choose 1, 2, 3, 4. 1 Prints a report of the inventory, 2 checks
 * to see if any item is in stock, 3 sells an item, and 4 exits the program.

 *
 * @author     Rob Just
 * @created    August 26th, 2010
 */
public class hardwareStoreTestProgram {

    public static void main(String args[]) throws FileNotFoundException {
        // Load inventory text file into hardwareStore
        hardwareStore.loadFromFile("storeItems.txt");

        // start the mainMenu
        mainMenu();
    }

    // Main menu that displays the title and 4 menu options for the user.
    public static void mainMenu() throws FileNotFoundException {
        int menuOption = 0;
        int itemNumber = 0;
        int quantity = 0;
        Scanner console = new Scanner(System.in);

        // Loop until user chooses 4 (Exit)
        while (menuOption != 4) {
            System.out.println("\nFriendly Hardware Store - Main Menu");
            System.out.println("-----------------------------------");
            System.out.println("1. Print Report");
            System.out.println("2. Check inventory of item");
            System.out.println("3. Sell item");
            System.out.println("4. Exit");
            System.out.println();
            System.out.println("Please enter an option (1-4): ");

            menuOption = console.nextInt();

            // Validate user entry
            while (menuOption < 1 || menuOption > 4) {
                System.out.println("\nInvalid entry, please try again.");
                System.out.println("\nPlease enter an option (1-4): ");
                menuOption = console.nextInt();
            }

            switch (menuOption) {
                case 1: // Print Report
                    hardwareStore.printReport();
                    break;
                case 2: // Check inventory
                    System.out.println("\nPlease enter a valid itemID to "
                            + "check (XXXX): ");
                    itemNumber = console.nextInt();
                    hardwareStore.checkForItem(itemNumber);
                    break;
                case 3: // Sell item
                    System.out.println("\nEnter the itemID of them "
                            + "item you wish to sell (ex. 4444): ");
                    itemNumber = console.nextInt();
                    System.out.println("\nEnter the quanitity to sell "
                            + "(ex. 50): ");
                    quantity = console.nextInt();
                    hardwareStore.sellItem(itemNumber, quantity);
                    break;
                case 4: // Exit program
                    break;
            }

        }
    }
}
