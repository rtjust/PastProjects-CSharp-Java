/*
 * @(#)StringIfSwitchTest.java        1.0 8/9/10
 *
 * Copyright (c) 2010 Rob Just
 */
package edu.baker.cs.cs242.seminar1exercise2;

/**
 * Class: StringIfSwitchTest
 * Description: This program performs a reversal on a string, tests if a char
 * is uppercase, and converts a score to a letter grade and outputs the results.
 *
 * @author     Rob Just
 * @created    August 9th, 2010
 */
public class StringIfSwitchTest
{

    public static void main(String[] args)
    {
        String testString = "Hello. My name is Rob."; // For string manipulation
        char testChar = 'Z'; // For if\else control structure test
        int testInt = 81; // For switch control structure test

        // Output for string manipulation
        System.out.println("String before manipulation: " + testString);
        System.out.println("String after manipulation (reversal): "
                + stringManipulation(testString));

        // Output for if\else control structure
        System.out.println("Char " + testChar + " is uppercase (true\\false): " +
                isCharUppercase(testChar));

        // Output for switch control structure
        System.out.println("Letter grade for score of " + testInt + ": " +
                letterGrade(testInt));

    }

    // Accepts a String value and returns the reverse of that string
    public static String stringManipulation(String inputString)
    {
        StringBuilder outputString = new StringBuilder();

        for (int i = inputString.length() - 1; i >= 0; i--)
        {
            outputString.append(inputString.charAt(i));
        }

        return outputString.toString();

    }

    // Accepts a char value and returns true if its an uppercase letter
    public static boolean isCharUppercase(char inputChar)
    {
        if (inputChar >= 65 && inputChar <= 90)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Accepts an int and returns the letter grade equivalent if 0 - 109
    public static char letterGrade(int score)
    {
        switch (score / 10)
        {
            case 0:
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
                return 'D';
            case 7:
                return 'C';
            case 8:
                return 'B';
            case 9:
            case 10:
                return 'A';
            default:
                return '?';
        }
    }
}
