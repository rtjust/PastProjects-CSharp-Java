/*
 * @(#)RotCipher.java        1.0 8/4/10
 *
 * Copyright (c) 2010 Rob Just
 */

package edu.baker.cs.cs242.FinalProject.RotCipher;

/**
 * Class: RotCipher
 * Description: This class contains operations to perform a rotation Caesar
 * cipher (13 or 47 characters) on a String. It accepts a String as inputString
 * and returns a ciphered\deciphered String as outputString.
 *
 * @author     Rob Just
 * @created    August 4th, 2010
 */
public class RotCipher
{

    // Default Constructor
    public RotCipher()
    {
        this.outputString = "";
        this.inputString = "";
    }

    // Constructor with inputString parameter
    public RotCipher(String inputString)
    {
        this.outputString = "";
        this.inputString = inputString;
    }

    private String outputString; // Stores the output string for retrieval
    private String inputString; // Stores the input string for retrieval

    // Performs Rot13 cipher on inputString parameter and returns String
    public String getRot13String(String inputString)
    {
        StringBuilder outputString = new StringBuilder();
        char currentChar;

        for (int i = 0; i <= inputString.length() - 1; i++) {
            currentChar = inputString.charAt(i);
            if (currentChar >= 'A' && currentChar <= 'M') {
                currentChar += 13;
                outputString.insert(i, (currentChar));
            } else if (currentChar >= 'N' && currentChar <= 'Z') {
                currentChar -= 13;
                outputString.insert(i, (currentChar));
            } else if (currentChar >= 'a' && currentChar <= 'm') {
                currentChar += 13;
                outputString.insert(i, (currentChar));
            } else if (currentChar >= 'n' && currentChar <= 'z') {
                currentChar -= 13;
                outputString.insert(i, (currentChar));
            } else {
                outputString.insert(i, currentChar);
            }
        }

        this.outputString = outputString.toString();
        
        return this.outputString;
    }

    // Performs Rot47 cipher on inputString parameter and returns String
    public String getRot47String(String inputString)
    {
        StringBuilder outputString = new StringBuilder();
        char currentChar;

        for (int i = 0; i <= inputString.length() - 1; i++) {
            currentChar = inputString.charAt(i);
            if (currentChar >= 33 && currentChar <= 79) {
                currentChar += 47;
                outputString.insert(i, (currentChar));
            }
            else if(currentChar >= 80 && currentChar <= 126) {
                currentChar -= 47;
                outputString.insert(i, (currentChar));
            }
            else
                outputString.insert(i, (currentChar));
        }

        this.outputString = outputString.toString();
        
        return this.outputString;
    }

    // Accessor method for outputString
    public String getOutputString()
    {
        return this.outputString;
    }

    // Accessor method for inputString
    public String getInputString()
    {
        return this.inputString;
    }


}
