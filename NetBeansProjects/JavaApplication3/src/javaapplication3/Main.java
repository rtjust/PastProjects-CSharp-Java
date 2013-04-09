/**
 * Description of the Class: This code will take 2 numbers and
 * put it in multiplication form then ask the user for the answer
 *
 * @author     Juan Rodriguez
 * @created    July 22, 2010
 */

import java.io.*;
import java.util.Random;
import javax.swing.*;

public class Numbers
{


public static void main (String[] args)throws IOException
{

//Declare Variables
int number1;
int number2;
int guess;
int answer;
String inputStr;
//String resolve;


DataInputStream stdin = new DataInputStream (System.in);
Random generator = new Random();

//get numbers
number1 = generator.nextInt(20);
number2 = generator.nextInt(20);

//prompt user for input   pg 150 JOption
inputStr = JOptionPane.showInputDialog("What is "+ number1 + "*" + number2);


inputStr = stdin.readLine();
guess = Integer.parseInt(inputStr);
answer = (number1 * number2);


	while (guess != answer)
		{
		inputStr = JOptionPane.showInputDialog("Try Again "+ number1 + "*" + number2);
		if (guess == answer)break;
		}
//    if	(guess != answer)
//		{
//		JOptionPane.showMessageDialog(null,"Your answer is incorrect, Sorry");
//		}
//	if (guess == answer)
		{
		JOptionPane.showMessageDialog(null,"Your answer is correct "+ answer);
	   }

	}
}





