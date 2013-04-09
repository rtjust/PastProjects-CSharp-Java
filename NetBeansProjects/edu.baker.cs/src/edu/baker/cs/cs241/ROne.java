/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.baker.cs.cs241;

import javax.swing.*;
import static java.lang.Math.*;

public class ROne extends JFrame
{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    public ROne()
    {
        setTitle("Welcome");
        setSize(WIDTH,HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String args[])
    {
        ROne r1 = new ROne();
        int counter;

        for (counter = 1; counter <= 100; counter++)
            if (pow(floor(sqrt(counter)), 2) == counter)
                System.out.print(counter + " ");

        System.out.println();
    }

}
