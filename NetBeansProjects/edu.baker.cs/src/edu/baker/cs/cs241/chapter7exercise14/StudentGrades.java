/*
 * @(#)StudentGrades.java        1.0 7/23/10
 *
 * Copyright (c) 2010 Rob Just
 */

package edu.baker.cs.cs241.chapter7exercise14;

import java.io.*;
import java.util.*;

/**
 * Class: StudentGrades
 * Description: This class reads the names of grades of students from a file.
 * Then it calculates the average grade and letter grade of each student. The
 * class average is calculated as well. The results are outputted to a file.
 *
 * @author     Rob Just
 * @created    July 23rd, 2010
 */
public class StudentGrades
{
    private static final int SENTINEL = -999; // Used as sentinel in while loop

    public static void main (String[] args) throws FileNotFoundException
    {
        // Declare FileReader and PrintWriter for file input\output
        Scanner inFile = new Scanner(new FileReader("StudentGrades.txt"));
        PrintWriter outFile = new PrintWriter("StudentGradesOutput.txt");

        String studentName; // Stores the students name for output
        DoubleClass studentAverage = new DoubleClass(); // Student Average Score
        double classAverage = 0.0; // Class average score
        double totalAverage = 0.0; // Total of student averages added together
        int numberOfStudents = 0; // Number of students counted from inFile

        outFile.println("Student    Test1 Test2 Test3 Test4 Test5 "
                + "Average Grade");

        /* Loops through each line of the file calling calculateAverage and
         * calculateGrade for each student and outputting the results to the
         * outFile.
         */
        while (inFile.hasNext())
        {
            studentName = inFile.next();

            outFile.printf("%-13s", studentName);

            calculateAverage(inFile, outFile, studentAverage);
            outFile.printf("%-9s", studentAverage.getNum());

            outFile.print("" + calculateGrade(studentAverage.getNum()));
            outFile.println();

            totalAverage = totalAverage + studentAverage.getNum();
            numberOfStudents++;
        }

        classAverage = totalAverage / numberOfStudents;
        outFile.println();
        outFile.println("Class Average = " + classAverage);
        
        inFile.close();
        outFile.close();

    }

    /* This method reads the scores from the current line of inFile
     * totals them up, calculates average, and outputs the scores to the outFile.
     * The average score is stored in studentAverage object that is passed as a
     * parameter.
     */
    public static void calculateAverage(Scanner inFile, PrintWriter outFile,
            DoubleClass studentAverage)
    {
        int currentScore = 0; // Current score read from inFile
        double totalScore = 0.0; // Total score to be used to calculate average
        int numberOfScores = 0; // Number of scores used to calculate average

        currentScore = inFile.nextInt();

        while (currentScore != SENTINEL)
        {
           outFile.printf("%-6s", currentScore);
           totalScore = totalScore + currentScore;
           currentScore = inFile.nextInt();
           numberOfScores++;
        }

        studentAverage.setNum(totalScore / numberOfScores);
    }

    /* This method accepts a double value and returns the letter grade
     * equivalent.
     */
    public static char calculateGrade(double inputGrade)
    {
        // Round inputGrade to nearest whole number and cast to int
        int roundedGrade = (int)(Math.round(inputGrade));

        switch (roundedGrade / 10)
        {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return 'F';
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
