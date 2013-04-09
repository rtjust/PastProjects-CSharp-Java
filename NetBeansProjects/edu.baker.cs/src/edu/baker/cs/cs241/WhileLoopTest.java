/*
 * @(#)WhileLoopTest.java        1.0 7/14/10
 *
 * Copyright (c) 2010 Rob Just
 */

package edu.baker.cs.cs241;

import java.util.*;
import java.io.*;

/**
 * Class: WhileLoopTest
 * Description: This class completes 5 tasks as described:
 * A. Prompt user for two integers with the first being larger than the second.
 * B. Outputs all odd numbers between the first and second integer.
 * C. Outputs the sum of all evens between the first and second integer.
 * D. Outputs all the numbers between 1-10 and their squares.
 * E. Outputs the sum of all squares of the odd numbers between the first and
 *    second integer.
 * F. Outputs all the uppercase letters of the alphabet.
 *
 * @author     Rob Just
 * @created    July 14th, 2010
 */
public class WhileLoopTest {

    static Scanner console = new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException {

        int firstNum = 0;           // First integer entered by user
        int secondNum = 0;          // Second integer entered by user
        int tempNum = 0;            // Init to firstNum's value then incremented
        int evenSum = 0;            // Holds the sum of all the evens
        int squareSum = 0;          // Holds the sum of all the squares
        char uppercaseLetter = 'A'; // Used to iterate through the alphabet
        
        // A. Ask for two integers, one larger than the other
        do
        {
            System.out.println("Please enter an integer: ");
            firstNum = console.nextInt();

            System.out.println("Please enter an another integer greater than "
                    + "the first: ");
            secondNum = console.nextInt();

            if (firstNum >= secondNum)
            {
                System.out.println("The first integer was larger or the same as"
                        + " the second. Please try again.");
            }

        } while (firstNum >= secondNum);

        System.out.println();

        // B. Output odd numbers between firstNum and secondNum
        System.out.print("Odd numbers between " + firstNum + " and " 
                + secondNum + ": ");

        tempNum = firstNum;
        
        while (tempNum <= secondNum)
        {
            if ((tempNum % 2) > 0)
                System.out.print(tempNum + " ");
            tempNum++;
        }

        System.out.println();

        // C. Output sum of all even numbers between firstNum and secondNum
        System.out.println();
        System.out.print("Sum of even numbers between " + firstNum + " and "
                + secondNum + ": ");

        tempNum = firstNum;

        while (tempNum <= secondNum)
        {
            if ((tempNum % 2) == 0)
                evenSum = evenSum + (tempNum);
 
            tempNum++;
        }

        System.out.print(evenSum);
        System.out.println();

        // D. Output all the numbers and their squares between 1 and 10
        System.out.println();
        System.out.println("Numbers 1-10 and their squares: ");

        tempNum = 1;
        
        while (tempNum <= 10)
        {
            System.out.println(tempNum + " squared is "
                    + (int)(Math.pow((double)(tempNum), 2.0)));
            tempNum++;
        }

        System.out.println();

        // E.Output the sum of the squares of odd between firstNum and secondNum
        tempNum = firstNum;

        while (tempNum <= secondNum)
        {
            if ((tempNum % 2) > 0)
                squareSum = squareSum + (int)(Math.pow((double)(tempNum), 2.0));
            tempNum++;
        }

        System.out.println("Sum of squares of the odd numbers between "
                + firstNum + " and " + secondNum + ": " + squareSum);
        System.out.println(); 
        
        // F. Output all the uppsercase letters of the alphabet
        System.out.println("All the uppercase letters of the alphabet: ");
        
        while (uppercaseLetter <= 'Z')
        {
            System.out.print(uppercaseLetter + " ");
            uppercaseLetter++;
        }
    }

}
    
   
    
    

