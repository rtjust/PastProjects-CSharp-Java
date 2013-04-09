/*
 * @(#)Calculator.java        1.0 9/08/10
 *
 * Copyright (c) 2010 Rob Just
 */
package edu.baker.cs.cs242.seminar5exercise3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class: Calculator
 * Description: This is a modified version of the Chapter 12 Calculator exercise.
 * This version adds support for decimal numbers and adds a decimal button.
 * The program throws a division by zero exception if a decimal is divided by
 * zero instead of infinity as a result.
*
 *
 * @author     D.S. Malik, modified by Rob Just
 * @created    September 8th, 2010
 */
public class Calculator extends JFrame implements ActionListener
{

    private JTextField displayText = new JTextField(30); // Display text field
    private JButton[] button = new JButton[17]; // Array of buttons for the keys

    // Keys for the calculator, added "."
    private String[] keys = {"7", "8", "9", "/",
                             "4", "5", "6", "*",
                             "1", "2", "3", "-",
                             "0", "C", "=", "+",
                             "."};

    private String numStr1 = ""; // Stores the first number of the equation
    private String numStr2 = ""; // Stores the second number of the equation
    private char op; // Stores the operator for the equation
    private boolean firstInput = true; // True if number is first input entered
    private boolean hasDecimal = false; // True if number has decimal already

    public Calculator()
    {
        setTitle("My Calculator (Decimals supported)");
        setSize(440, 440);
        Container pane = getContentPane();

        pane.setLayout(null);

        displayText.setSize(400, 60);
        displayText.setLocation(10, 10);
        displayText.setFont(new Font("sanserif", Font.PLAIN, 24));
        displayText.setEditable(false); // Don't allow user to edit textarea

        pane.add(displayText);

        int x, y;

        x = 10;
        y = 80;

        // Populate buttons with the keys array
        for (int ind = 0; ind < keys.length; ind++)
        {
            button[ind] = new JButton(keys[ind]);
            button[ind].addActionListener(this);
            button[ind].setSize(100, 60);
            button[ind].setLocation(x, y);
            button[ind].setFont(new Font("sanserif", Font.PLAIN, 24));
            pane.add(button[ind]);

            x = x + 100;

            if ((ind + 1) % 4 == 0)
            {
                x = 10;
                y = y + 60;
            }
        }

        // Close window listener
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    // This method performs an action based on what key is pressed
    public void actionPerformed(ActionEvent e)
    {
        String resultStr;

        String str = String.valueOf(e.getActionCommand());

        char ch = str.charAt(0);

        // Check the label of the key pressed, perform action specified
        switch (ch)
        {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                if (firstInput)
                {
                    numStr1 = numStr1 + ch;
                    displayText.setText(numStr1);
                } 
                else
                {
                    numStr2 = numStr2 + ch;
                    displayText.setText(numStr2);
                }
                break;
            case '.':
                if (hasDecimal)
                {
                    // Beep, only one decimal allowed in number string
                    Toolkit.getDefaultToolkit().beep();
                    break;
                }
                else 
                {
                    // No decimal already, add decimal to number string
                    if (firstInput)
                    {
                        numStr1 = numStr1 + ch;
                        displayText.setText(numStr1);
                    }
                    else
                    {
                        numStr2 = numStr2 + ch;
                        displayText.setText(numStr2);
                    }
                    hasDecimal = true;
                    break;
                }
            case '+':
            case '-':
            case '*':
            case '/':
                op = ch;
                firstInput = false;
                hasDecimal = false; // Reset hasDecimal
                break;
            case '=':
                resultStr = evaluate();
                displayText.setText(resultStr);
                numStr1 = resultStr;
                numStr2 = "";
                firstInput = false;
                hasDecimal = false; // Reset hasDecimal
                break;
            case 'C':
                displayText.setText("");
                numStr1 = "";
                numStr2 = "";
                firstInput = true;
                hasDecimal = false; // Reset hasDecimal
        }
    }

    // This method evaluates the equation entered, throws exception on / by zero
    private String evaluate()
    {
        try
        {
            double num1 = Double.parseDouble(numStr1);
            double num2 = Double.parseDouble(numStr2);
            double result = 0;

            // Check the operator entered by the user, perform operation
            switch (op)
            {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
            }

            if (String.valueOf(result).equalsIgnoreCase("infinity"))
            {
                // Divide a double by 0 results in infinity.
                // Throw exception "/ by zero" instead
                throw new ArithmeticException("/ by zero");
            } 
            else if (String.valueOf(result).equalsIgnoreCase("nan"))
            {
                // 0/0 is Not a Number (NaN). Throw exception "Not a Number"
                throw new ArithmeticException("Not a Number");
            }

            return String.valueOf(result);
        } 
        catch (ArithmeticException e)
        {
            Toolkit.getDefaultToolkit().beep();
            return "E R R O R: " + e.getMessage();
        } 
        catch (NumberFormatException e)
        {
            Toolkit.getDefaultToolkit().beep();

            if (numStr1.equals(""))
            {
                return "E R R O R: Invalid First Number";
            } 
            else
            {
                return "E R R O R: Invalid Second Number";
            }
        } 
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            return "E R R O R";
        }

    }

    // Main program method, creates new Calculator window
    public static void main(String[] args)
    {
        Calculator C = new Calculator();
    }
}
