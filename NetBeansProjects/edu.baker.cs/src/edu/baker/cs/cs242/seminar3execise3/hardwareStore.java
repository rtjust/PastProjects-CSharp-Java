/*
 * @(#)hardwareStore.java        1.0 8/26/10
 *
 * Copyright (c) 2010 Rob Just
 */
package edu.baker.cs.cs242.seminar3execise3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

/**
 * Class: hawrdwareStore
 * Description: This class contains the vectors and methods to load, store, and
 * manipulate the hardware store inventory.
 * 7 Parallel vectors are used to store the inventory data loaded from a text
 * file. The vectors are then sorted in parallel.
 * Methods include sellItem, sortVectors, loadFromFile, calculateInventory,
 * and printReport.
 *
 *
 * @author     Rob Just
 * @created    August 26th, 2010
 */
public class hardwareStore {

    private static Vector<Integer> itemID = new Vector<Integer>(); // Item ID
    private static Vector<String> itemName = new Vector<String>(); // Item Name
    private static Vector<Integer> pOrdered = new Vector<Integer>(); // Ordered
    private static Vector<Integer> pInStore = new Vector<Integer>(); // In Store
    private static Vector<Integer> pSold = new Vector<Integer>(); // Sold
    private static Vector<Double> manufPrice = new Vector<Double>(); // Manufacturers Price
    private static Vector<Double> sellingPrice = new Vector<Double>(); // Selling Price
    private static double totalInventory = 0; // Total Inventory worth $
    private static int totalNumOfItems = 0; // Total number of inventory items

    // Method that checks to see if an item is in stock and display result
    public static void checkForItem(int searchID) {
        if (itemID.contains(searchID)) {
            int itemIndex = itemID.indexOf(searchID);
            String strItemName = itemName.get(itemIndex);
            int totalQuantity = pInStore.get(itemIndex);

            System.out.println("\nThere are " + totalQuantity + " "
                    + strItemName + "(s) currently in stock.");
        } else {
            System.out.println("\nItem " + searchID + " not in inventory.");
        }
    }

    // Method that sells an item specified by searchID and sellQuantity params
    public static void sellItem(int searchID, int sellQuantity) {
        if (itemID.contains(searchID)) {
            int itemIndex = itemID.indexOf(searchID);
            String strItemName = itemName.get(itemIndex);
            int totalQuantity = pInStore.get(itemIndex);
            int totalSold = pSold.get(itemIndex);

            if (sellQuantity > totalQuantity) {
                System.out.println("\nNot enough quantity in store to sell "
                        + sellQuantity + " " + strItemName + "(s).");
                System.out.println("\nThere are only " + totalQuantity + " "
                        + strItemName + "(s) left in stock.");
            } else {
                pInStore.set(itemIndex, (totalQuantity - sellQuantity));
                pSold.set(itemIndex, (totalSold + sellQuantity));
                System.out.println("\nSold " + sellQuantity + " " + strItemName
                        + "(s).");
            }

        } else {
            System.out.println("\nItem doesn't exist. Please try and enter "
                    + "another item.");
        }
    }

    // Method that sorts the vectors in parallel based on itemName Vector
    private static void sortVectors() {
        int firstOutOfOrder, location;
        String tempName;
        int tempID;
        int tempOrdered;
        int tempInStore;
        int tempSold;
        double tempManufPrice;
        double tempSellingPrice;

        for (firstOutOfOrder = 1; firstOutOfOrder < itemName.size(); firstOutOfOrder++) {

            if (itemName.elementAt(firstOutOfOrder).compareToIgnoreCase(itemName.elementAt(firstOutOfOrder - 1)) < 0) {
                tempName = itemName.elementAt(firstOutOfOrder);
                tempID = itemID.elementAt(firstOutOfOrder);
                tempOrdered = pOrdered.elementAt(firstOutOfOrder);
                tempInStore = pInStore.elementAt(firstOutOfOrder);
                tempSold = pSold.elementAt(firstOutOfOrder);
                tempManufPrice = manufPrice.elementAt(firstOutOfOrder);
                tempSellingPrice = sellingPrice.elementAt(firstOutOfOrder);

                location = firstOutOfOrder;

                do {
                    itemName.set(location, itemName.elementAt(location - 1));
                    itemID.set(location, itemID.elementAt(location - 1));
                    pOrdered.set(location, pOrdered.elementAt(location - 1));
                    pInStore.set(location, pInStore.elementAt(location - 1));
                    pSold.set(location, pSold.elementAt(location - 1));
                    manufPrice.set(location, manufPrice.elementAt(location - 1));
                    sellingPrice.set(location, sellingPrice.elementAt(location - 1));

                    location--;
                } while (location > 0
                        && itemName.elementAt(location - 1).compareToIgnoreCase(tempName) > 0);

                itemName.set(location, tempName);
                itemID.set(location, tempID);
                pOrdered.set(location, tempOrdered);
                pInStore.set(location, tempInStore);
                pSold.set(location, tempSold);
                manufPrice.set(location, tempManufPrice);
                sellingPrice.set(location, tempSellingPrice);
            }
        }
    }

    // Method that loads the data from text file into vectors
    public static void loadFromFile(String fileName) throws FileNotFoundException {
        Scanner inFile = new Scanner(new FileReader(fileName));
        int tempNum;

        while (inFile.hasNext()) {
            itemID.addElement(inFile.nextInt());
            inFile.nextLine();

            itemName.addElement(inFile.nextLine());

            tempNum = inFile.nextInt();
            pOrdered.addElement(tempNum);
            pInStore.add(tempNum);

            pSold.addElement(0);

            manufPrice.addElement(inFile.nextDouble());
            sellingPrice.addElement(inFile.nextDouble());
        }
        sortVectors();
    }

    // Method that calculates total inventory and total number of items
    private static void calculateInventory() {
        totalNumOfItems = 0;
        totalInventory = 0;

        for (int index = 0; index < pInStore.size(); index++) {
            totalNumOfItems += pInStore.elementAt(index);
            totalInventory += sellingPrice.elementAt(index)
                    * pInStore.elementAt(index);
        }
    }

    // Method that displays the inventory report
    public static void printReport() {

        calculateInventory();
        System.out.println("                          Friendly Hardware Store "
                + "                         ");
        System.out.println("                                                  "
                + "                         ");
        System.out.println("itemID  itemName        pOrdered  pInStore  pSold "
                + " manufPrice  sellingPrice");

        for (int index = 0; index < itemID.size(); index++) {
            System.out.printf("%1$-7s %2$-15s %3$-9s %4$-9s %5$-6s %6$-11.2f "
                    + "%7$-11.2f\n", itemID.elementAt(index),
                    itemName.elementAt(index), pOrdered.elementAt(index),
                    pInStore.elementAt(index), pSold.elementAt(index),
                    manufPrice.elementAt(index), sellingPrice.elementAt(index));
        }

        System.out.printf("\nTotal Inventory: $%15.2f", totalInventory);
        System.out.println("\nTotal number of items in the store: "
                + totalNumOfItems);

    }
}
