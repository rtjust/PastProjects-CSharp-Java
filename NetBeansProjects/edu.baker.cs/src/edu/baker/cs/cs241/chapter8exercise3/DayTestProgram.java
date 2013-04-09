/*
 * @(#)DayTestProgram.java        1.0 7/28/10
 *
 * Copyright (c) 2010 Rob Just
 */
package edu.baker.cs.cs241.chapter8exercise3;

/**
 * Class: DayTestProgram
 * Description: This class tests the class Day and it's methods
 *
 * @author     Rob Just
 * @created    July 28th, 2010
 */
public class DayTestProgram
{

    public static void main(String[] args) 
    {
        // Create the Day objects
        Day testDayDefault = new Day();
        Day testDay = new Day(Day.SATURDAY);

        // Test the toString method (toString takes place of print method)
        System.out.println("Day with default constructor is " 
                + testDayDefault.toString());

        System.out.println("Day constructor with Day.SATURDAY (6) as "
                + "parameter is " + testDay.toString());

        // Test setDay method
        testDay.setDay(Day.THURSDAY);
        System.out.println("setDay with Day.THURSDAY (4) as parameter is "
                + testDay.toString());

        // Test the calcDaysFrom method
        for (int i = 0; i <= 10; i++)
        {
            System.out.println(i + " days from " + testDay.toString() + " is a "
                    + testDay.calcDaysFrom(i));
        }

        for (int i = 0; i >= -10; i--)
        {
            System.out.println(i + " days from " + testDay.toString() + " is a "
                    + testDay.calcDaysFrom(i));
        }

        // Test the nextDay and prevDay method
        System.out.println("Day after " + testDay.toString() + " is "
                + testDay.nextDay());
        System.out.println("Day before " + testDay.toString() + " is "
                + testDay.prevDay());     

        // Test the getDay method
        System.out.println("The integer value of " + testDay.toString() +
                " is " + testDay.getDay());


    }
}
