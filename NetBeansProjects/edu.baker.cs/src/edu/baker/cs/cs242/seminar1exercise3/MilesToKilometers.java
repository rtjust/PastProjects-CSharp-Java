/*
 * @(#)MilesToKilometers.java        1.0 8/11/10
 *
 * Copyright (c) 2010 Rob Just
 */
package edu.baker.cs.cs242.seminar1exercise3;

import javax.swing.JOptionPane;

/**
 * Class: MilesToKiometers
 * Description: Prompts the user to select from Miles to Kilometers or vice
 * versa. Accepts integer or double input, performs conversion, displays output.
 *
 * @author     Rob Just
 * @created    August 11th, 2010
 */
public class MilesToKilometers
{

    public static void main(String[] args)
    {
        int dialogAnswer; // Stores the value of OptionDialog
        double dialogInput = 0; // Stores the value of the InputDialog

        // Custom button options for the OptionDialog
        Object[] options = {"Miles to Kilometers",
                            "Kilometers to Miles",
                            "Cancel"};
        
        // Do ... until the user presses Cancel or closes the OptionDialog
        do
        {
            dialogAnswer = JOptionPane.showOptionDialog(null,
                    "To convert, select from one of the following options or "
                    + "select Cancel to quit.",
                    "Miles\\Kilometers Converter",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            // User presses Miles to Kilometers
            if (dialogAnswer == JOptionPane.YES_OPTION)
            {
                try
                {
                    dialogInput = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "Please enter the number of miles you wish to "
                            + "convert to kilometers.",
                            "Miles to Kilometers",
                            JOptionPane.INFORMATION_MESSAGE));
                }
                catch (NumberFormatException ex) // Invalid input
                {
                    JOptionPane.showMessageDialog(null, "You have entered an "
                            + "invalid number. Please try again.",
                            "Invalid input", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                catch (NullPointerException ex) // User presses cancel
                {
                    continue;
                }

                JOptionPane.showMessageDialog(null, dialogInput + " miles is "
                        + milesToKilos(dialogInput) + " kilometers.",
                        "Result",
                        JOptionPane.INFORMATION_MESSAGE);

            }
            // User presses Kilometers to miles
            else if (dialogAnswer == JOptionPane.NO_OPTION)
            {
                try
                {
                    dialogInput = 
                            Double.parseDouble(JOptionPane.showInputDialog(null,
                            "Please enter the number of kilometers you wish to "
                            + "convert to miles.",
                            "Kilometers to miles",
                            JOptionPane.INFORMATION_MESSAGE));
                }
                catch (NumberFormatException ex) // Invalid input
                {
                    JOptionPane.showMessageDialog(null, "You have entered an "
                            + "invalid number. Please try again.",
                            "Invalid input", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                catch (NullPointerException ex) // User presses cancel
                {
                    continue;
                }

                // Display results
                JOptionPane.showMessageDialog(null, dialogInput
                    + " kilometers is " + kilosToMiles(dialogInput)
                    + " miles.",
                    "Result",
                    JOptionPane.INFORMATION_MESSAGE);
            }
                       
        } while (dialogAnswer != JOptionPane.CANCEL_OPTION &&
                dialogAnswer != JOptionPane.CLOSED_OPTION);

    }

    // Accepts a double and returns a double. Miles to Kilometers conversion
    public static double milesToKilos(double miles)
    {
        return (miles * 1.61);
    }

    // Accepts a double and returns a double. Kilometers to miles conversion
    public static double kilosToMiles(double kilometers)
    {
        return (kilometers * .62);
    }
}
