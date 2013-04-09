/*
 * @(#)HighLowTemp.java        1.0 8/18/10
 *
 * Copyright (c) 2010 Rob Just
 */
package edu.baker.cs.cs242.seminar2exercise3;

import java.util.Scanner;

/**
 * Class: HighLowTemp
 * Description: This class prompts the user for the high and low temperatures
 * for each month of the year for a total of 24 (2 each month) temperatures.
 * The average high, low, highest temp, and lowest temp of the year is then
 * displayed.

 *
 * @author     Rob Just
 * @created    August 18th, 2010
 */
public class HighLowTemp {

    public static void main(String args[])
    {
        int[][] highLowTemps = new int[12][2]; // 2D array to store the temps
        int highestTempIndex; // Stores the index of the highest temp
        int lowestTempIndex; // Stores the index of the lowest temp

        getData(highLowTemps); // Gather data from user

        highestTempIndex = indexHighTemp(highLowTemps);
        lowestTempIndex = indexLowTemp(highLowTemps);

        // Output results
        System.out.println("Average high of the year: "
                + averageHigh(highLowTemps));
        System.out.println("Average low of the year: "
                + averageLow(highLowTemps));
        
        System.out.println("Highest temp of the year: "
                + highLowTemps[highestTempIndex][0] + " Month: "
                + (highestTempIndex + 1));

        System.out.println("Lowest temp of the year: "
                + highLowTemps[lowestTempIndex][1] + " Month: "
                + (lowestTempIndex + 1));

    }

    // Prompts user for the high and low for each month and returns a 2D array
    public static int[][] getData(int[][] tempArray)
    {
        Scanner console = new Scanner(System.in);
        int userEntry = 0;

        for (int i = 0; i < tempArray.length; i++)
        {
            System.out.println("Enter integer high for month " + (i + 1) + ": ");
            userEntry = console.nextInt();
            tempArray[i][0] = userEntry;

            System.out.println("Enter integer low for month " + (i + 1) + ": ");
            userEntry = console.nextInt();
            tempArray[i][1] = userEntry;          
        }

        return tempArray;
    }

    // Returns the average of the high temps of the tempArray parameter
    public static int averageHigh(int[][] tempArray)
    {
        int sum = 0;
        int average = 0;

        for (int row = 0; row < tempArray.length; row++)
        {
            sum += tempArray[row][0];
        }

        average = (int)(Math.round(sum / tempArray.length));

        return average;
    }

    // Returns the average of the low temps of the tempArray parameter
    public static int averageLow(int[][] tempArray)
    {
        double sum = 0;
        int average = 0;

        for (int row = 0; row < tempArray.length; row++)
        {
            sum += tempArray[row][1];
        }

        average = (int)(Math.round(sum / tempArray.length));

        return average;
    }

    // Returns the index of the highest temperature in tempArray
    public static int indexHighTemp(int[][] tempArray)
    {
        int row = 0;
        int largest = tempArray[row][0];
        int largestIndex = 0;
        
       for (row = 0; row < tempArray.length; row++)
       {
           if (largest < tempArray[row][0])
           {
               largest = tempArray[row][0];
               largestIndex = row;
           }
       }

        return largestIndex;
    }

    // Returns the index of the lowest temperature in tempArray
    public static int indexLowTemp(int[][] tempArray)
    {
        int row = 0;
        int smallest = tempArray[row][1];
        int smallestIndex = 0;

       for (row = 0; row < tempArray.length; row++)
       {
           if (smallest > tempArray[row][1])
           {
               smallest = tempArray[row][1];
               smallestIndex = row;
           }
       }

        return smallestIndex;
    }

}
