/*
 * @(#)Day.java        1.0 7/28/10
 *
 * Copyright (c) 2010 Rob Just
 */
package edu.baker.cs.cs241.chapter8exercise3;

/**
 * Class: StudentGrades
 * Description: This class represents a Day of the week. It can stores both
 * an integer and String representation of the day. It contains methods
 * to set the day, calculate the next day, previous day, or X days before\after.
 * Can return the integer value of the day as well as String value.
 * Provides a toString override method in place of a print method.
 * 
 * @author     Rob Just
 * @created    July 23rd, 2010
 */
public class Day {

    // Constants used to easily identify the days and their integer equivalents
    public static final int SUNDAY = 0;
    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;
    private static final int DAYS_IN_WEEK = 7;
    
    private int dayInt;         // Stores the current day as an int
    private String dayString;   // Stores the current day as a String value

    // Default constructor, Calls setDay and sets the day to Sunday (0)
    public Day()
    {
        setDay(SUNDAY);
    }

    // Constructor that takes an int parameter that is passed to setDay
    public Day(int day)
    {
        setDay(day);
    }

    // Sets the dayInt value and dayString value
    public final void setDay(int day)
    {
        this.dayInt = day;
        this.dayString = convertDayToString(day);
    }

    // Returns the current value of dayInt as integer
    public int getDay()
    {
        return dayInt;
    }

    // Returns the String value of dayString (replaces print method)
    @Override
    public String toString()
    {
        return dayString;
    }

    // Returns a String of the next day after the current day
    public String nextDay()
    {
        return calcDaysFrom(1);
    }

    // Returns a String of the previous day before the current day
    public String prevDay()
    {
        return calcDaysFrom(-1);
    }

    // Returns a String of the day X number of days after the current day
    public String calcDaysFrom(int numberOfDays)
    {
        int tempDay;

        tempDay = (numberOfDays % DAYS_IN_WEEK) + this.dayInt;
        tempDay = tempDay % DAYS_IN_WEEK;

        return convertDayToString(tempDay);
    }

    // Takes an integer from 0 - 6 and returns its day of week String value
    private String convertDayToString(int day)
    {
        String tempDayString;

        switch (day)
        {
            case SUNDAY:
                tempDayString = "Sunday";
                break;
            case MONDAY:
                tempDayString = "Monday";
                break;
            case TUESDAY:
                tempDayString = "Tuesday";
                break;
            case WEDNESDAY:
                tempDayString = "Wednesday";
                break;
            case THURSDAY:
                tempDayString = "Thursday";
                break;
            case FRIDAY:
                tempDayString = "Friday";
                break;
            case SATURDAY:
                tempDayString = "Saturday";
                break;
            default:
                tempDayString = "Sunday"; // default to Sunday
                break;
        }

        return tempDayString;
    }
}
