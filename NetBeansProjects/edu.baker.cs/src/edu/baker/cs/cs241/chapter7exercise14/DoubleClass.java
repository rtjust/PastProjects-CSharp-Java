/*
 * @(#)DoubleClass.java        1.0 7/23/10
 *
 * Copyright (c) 2010 Rob Just
 */


package edu.baker.cs.cs241.chapter7exercise14;

/**
 * Class: DoubleClass
 * Description: This class wraps a double and adds the ability to modify and
 * manipulate the double value as an object.
 * Source from Appendix D of JAVA Programming, Author D.S. MALIK
 *
 * @author     Rob Just
 * @created    July 23rd, 2010
 */

public class DoubleClass {
    private double x;

    public DoubleClass()
    {
        x = 0;
    }

    public DoubleClass(double num)
    {
        x = num;
    }

    public void setNum(double num)
    {
        x = num;
    }

    public double getNum()
    {
        return x;
    }

   public void addToNum(double num)
    {
       x = x + num;
   }

   public void multiplyToNum(double num)
    {
       x = x * num;
   }

   public double compareTo(double num)
    {
       return (x - num);
   }

   public boolean equals(double num)
    {
       if (x == num)
           return true;
       else
           return false;
    }

    @Override
   public String toString()
    {
       return (String.valueOf(x));
    }

}
