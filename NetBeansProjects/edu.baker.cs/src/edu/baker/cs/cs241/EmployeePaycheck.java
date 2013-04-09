/*
 * @(#)EmployeePaycheck.java        1.0 7/7/10
 *
 * Copyright (c) 2010 Rob Just
 */

package edu.baker.cs.cs241;

import javax.swing.*;
import java.util.*;
import java.io.*;

/**
 * Class: EmployeePaycheck
 * Description: This class prompts the user for an employee
 * name and gross income. It then calculates the taxes and total net income.
 * The output is saved to a file.
 * 
 * @author     Rob Just
 * @created    July 7th, 2010
 */
public class EmployeePaycheck {

    // Constants used for calculating taxes witheld
    static final double FEDERAL_INCOME_RATE = .15;
    static final double STATE_RATE = .035;
    static final double SOC_SECURITY_RATE = .0575;
    static final double MED_RATE = .0275;
    static final double PENSION_RATE = .05;
    static final double HEALTH_INSURANCE = 75.00;
    
    public static void main(String[] args) throws FileNotFoundException {

       String employeeName;         // Employee's name
       double grossIncome = 0;      // Employee's gross income
       double netIncome = 0;        // Employee's net income
       double totalFedTax = 0;      // Federal Tax witheld
       double totalStateTax = 0;    // State Tax witheld
       double totalSSTax = 0;       // SS tax witheld
       double totalMedTax = 0;      // Medicare\Medicaid tax witheld
       double totalPension = 0;     // Pension witheld
       double totalHealth = 0;      // Helth Insurance witheld
       PrintWriter outFile;         // File to write paycheck to
       String fileName;             // File name used by outFile
       
       // Get the employee's name
       employeeName = JOptionPane.showInputDialog("Enter the employee "
               + "name and press OK:");

       // Get the gross income
       grossIncome = Double.parseDouble(JOptionPane.showInputDialog("Enter the "
               + "gross income amount:"));

       // Calculate individual tax amounts
       totalFedTax = grossIncome * FEDERAL_INCOME_RATE;
       totalStateTax = grossIncome * STATE_RATE;
       totalSSTax = grossIncome * SOC_SECURITY_RATE;
       totalMedTax = grossIncome * MED_RATE;
       totalPension = grossIncome * PENSION_RATE;
       totalHealth = HEALTH_INSURANCE;
       
       // Calculate total net income
       netIncome = grossIncome - totalFedTax - totalStateTax - totalSSTax
               - totalMedTax - totalPension - totalHealth;
       
       // Creates an output file as name_PayChceck.txt
       fileName = employeeName.replaceAll(" ", "_") + "_PayCheck.txt";
       outFile = new PrintWriter(fileName);

       // Output paycheck to outFile line by line
       outFile.println(employeeName);
       outFile.println(String.format("Gross Income: %11s %10.2f",
               "$", grossIncome));
       outFile.println(String.format("Federal Tax: %12s %10.2f",
               "$", totalFedTax));
       outFile.println(String.format("State Tax: %14s %10.2f",
               "$", totalStateTax));
       outFile.println(String.format("Social Security Tax: %4s %10.2f",
               "$", totalSSTax));
       outFile.println(String.format("Medicare\\Medicaid Tax: %2s %10.2f",
               "$", totalMedTax));
       outFile.println(String.format("Pension Plan: %11s %10.2f",
               "$", totalPension));
       outFile.println(String.format("Health Insurance: %7s %10.2f",
               "$", totalHealth));
       outFile.println(String.format("Net Income: %13s %10.2f",
               "$", netIncome));

       // Display success message and provide filename
       JOptionPane.showMessageDialog(null, "Employee paycheck calculated "
               + "and saved to file: " + fileName, "Pay Check Calculated",
               JOptionPane.INFORMATION_MESSAGE);

       // Close the file
       outFile.close();
    }

}
