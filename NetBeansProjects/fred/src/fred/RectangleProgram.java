package fred;

//Jave Programming
//Final Project
//Numerology: Interpretation of your numbers
//Fred Brock
//Draft


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class RectangleProgram extends JFrame //beginning of box that will be displayed 
{
	
	private static final int WIDTH = 500; //width and height of display box
	private static final int HEIGHT = 900;
	
	private JLabel nameL, birthL, confirmationL, confirmBirthL, expressionL, heartL, personalityL, destinyL;//all labels to be displayed
	private JTextField nameTF, birthTF, confirmationTF, confirmBirthTF, expressionTF, heartTF, personalityTF, destinyTF;//test field displays for labels
	
	private JButton calculateB, exitB;
	
	private CalculateButtonHandler cbHandler; //calculate button handler
	private ExitButtonHandler ebHandler; //exit button handler

	public RectangleProgram()
	{
		// text to be displayed in the label area of the rectangle
		nameL =
			new JLabel("Enter your name: ", SwingConstants.RIGHT);
		birthL =
			new JLabel("Enter your birthdate: ", SwingConstants.RIGHT);
		confirmationL =
			new JLabel("You have entered your name as: ", SwingConstants.RIGHT);
		confirmBirthL =
			new JLabel("You have entered your birthdate as: ", SwingConstants.RIGHT);		
		expressionL =
			new JLabel("Expression Number: ", SwingConstants.RIGHT);
		heartL =
			new JLabel("Heart Number: ", SwingConstants.RIGHT);
		personalityL =
			new JLabel("Personality Number: ", SwingConstants.RIGHT);
		destinyL =
			new JLabel("Destiny Number: ", SwingConstants.RIGHT);
		
		//how many characters can be placed in each of the text fields for each label	
		nameTF = new JTextField(50);
		birthTF = new JTextField(50);
		confirmationTF = new JTextField(50);
		confirmBirthTF = new JTextField(50);
		expressionTF = new JTextField(50);
		heartTF = new JTextField(50);
		personalityTF = new JTextField(50);
		destinyTF = new JTextField(50);
		
		//naming the calculate button to display Interpret
		calculateB = new JButton("Interpret");
		cbHandler = new CalculateButtonHandler();
		calculateB.addActionListener(cbHandler);
		
		//naming the exit button to display Exit
		exitB = new JButton("Exit");
		ebHandler = new ExitButtonHandler();
		exitB.addActionListener(ebHandler);
		
		//title to show in the upper lefthand corner of the rectangle box
		setTitle("Numerology Interpretation");		
			
			
		Container pane = getContentPane();
		
		
		pane.setLayout(new GridLayout(9,3));
		
		pane.add(nameL);
		pane.add(nameTF);
		pane.add(birthL);
		pane.add(birthTF);
		pane.add(confirmationL);
		pane.add(confirmationTF);
		pane.add(confirmBirthL);
		pane.add(confirmBirthTF);
		pane.add(expressionL);
		pane.add(expressionTF);
		pane.add(heartL);
		pane.add(heartTF);
		pane.add(personalityL);
		pane.add(personalityTF);
		pane.add(destinyL);
		pane.add(destinyTF);
		pane.add(calculateB);
		pane.add(exitB);						
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}

	private class CalculateButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
	      // start of code for bringing the birthdate down to one number
			String givenName, birth;
			int sum;
			int num;
			int n;
			
			n = 411969;
			
			int sum_digits = n;
			while(sum_digits > 9)
			{
			sum_digits = 0;
			
			int num_digits = (int) Math.log10(n) + 1;
			
				do
				{
					sum_digits += n % 10;
					n /= 10;
				
				}
				while (n>0);
				
				n = sum_digits;			
			}

	
			
				
			givenName = (nameTF.getText());
			birth = (birthTF.getText());
			confirmationTF.setText("" + givenName);
			confirmBirthTF.setText("" + birth);
			destinyTF.setText("" + n);
		}
	
	
	}

	private class ExitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	
	}

	public static void main(String[] args)
	{
	
		RectangleProgram rectObject = new RectangleProgram();
	
	}

}