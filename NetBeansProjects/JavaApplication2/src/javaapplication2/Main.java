/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;
import java.util.*;
/**
 *
 * @author Rob
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


Scanner console = new Scanner(System.in);

boolean validInput = false;
while (!validInput)
{
    System.out.println("Enter your selection: ");
    String input = console.next();
    if(input.equals("yes"))
    {
        System.out.println("You said yes.");
        validInput = true;
    }
    else if (input.equals("no"))
    {
        System.out.println("You said no.");
        validInput = true;
    }
    else
    {
        System.out.println("Invalid selection!");
        validInput = false;
    }



}


        }
    }

}
