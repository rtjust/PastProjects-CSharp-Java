package javaapplication7;

/** CS241 Java Programming
 *  Final Project
 *  Coders Central Payroll Application 
 *
 *  @author Rachel Hackey
 */

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat; 
import java.text.SimpleDateFormat;
import java.text.ParseException; 


public class CodersCentralPayroll extends JFrame 
{  
	// Declares all of the User Interface variables
	private static final int WIDTH = 800;
	private static final int HEIGHT = 400;
        int i1 = 2.888;
	
	private JLabel empnumL, empnameL, spacerL;
	private static JTextField empnumTF, fnameTF, lnameTF;
	
	private JLabel section1L, begPayPeriodL, endPayPeriodL;
	private static JTextField begPayPeriodTF, endPayPeriodTF;
	
	private JLabel hoursWorkedL, rateOfPayL, numberOfHoursL, totalPayL;
	private JLabel regularHoursL, overtimeHoursL;

	private static JTextField regRateTF, regHoursTF, regTotalTF;
	private static JTextField otRateTF, otHoursTF, otTotalTF;

	private JLabel grossPayL;
	private static JTextField grsPayTF;
	
	private JLabel deductionsL, deductPercentageL, deductTotalL;
	
	private JLabel federalWithholdingL;
	private static JTextField fedPercentageTF, fedTotalTF;

	private JLabel stateWithholdingL;
	private static JTextField stPercentageTF, stTotalTF;

	private JLabel insuranceL;
	private static JTextField insPercentageTF, insTotalTF;

	private JLabel retirementL;
	private static JTextField retPercentageTF, retTotalTF;
	
	private JLabel netPayL;
	private static JTextField netPayTF;

	private JLabel YTDL;

	private JLabel grossYTDL, fedYTDL, stYTDL;
	private JLabel insYTDL, retYTDL, netYTDL;
	private static JTextField grossYTDTF, fedYTDTF, stYTDTF;	
	private static JTextField insYTDTF, retYTDTF, netYTDTF;
		
	private JButton ntciB, infB, w2B, exitB;
	
	// Declares the Event Handler variables
	private AddInfoHandler ntciHandler;
	private ViewW2ButtonHandler w2Handler;
	private InputFileButtonHandler infHandler;
	private ExitButtonHandler ebHandler;
	
	// Constant Variables
	final static double fedRATE = 0.20;
	final static double stRATE = 0.08;
	final static double insRATE = 50.00;
	final static double retRATE = 0.05;
	 

	//EMPLOYEE Info variables
	private static String empNum = "0000";
	private static String fname = "";
	private static String lname = "";
	private static double hourlyRate = 0;
	private static double otRate = 0;
	private static String[] begDate = new String[50];
	private static String[] endDate  = new String[50];
	private static double[] regHours = new double[50];
	private static double[] otHours = new double[50];
	private static int counter = -1; 
	
	
	// Global Scope Variables
	public static double grossFinal = 0;		// Gross Pay YTD total
	public static double fedFinal = 0;			// Federal Wth YTD total
	public static double stFinal = 0;			// State Wth YTD total
	public static double insFinal = 0;			// Insurance YTD total
	public static double retFinal = 0;			// Retirement YTD total
	public static double netFinal = 0;			// Net Pay YTD total
	 
	
	
	public CodersCentralPayroll()
	{
		// Title Bar of the User Interface
		setTitle("Coders Central Payroll");
	
		// Defines the guidelines and settings of all of the User Interface variables
		empnumL = new JLabel("Emp Number: ", SwingConstants.CENTER);
		empnameL = new JLabel("Emp Name: ", SwingConstants.CENTER);			
		empnumTF = new JTextField(4);
		empnumTF.setHorizontalAlignment(JTextField.CENTER);
		fnameTF = new JTextField(10);
		lnameTF = new JTextField(10);	

		spacerL = new JLabel("", SwingConstants.LEFT);
		section1L = new JLabel("MOST RECENT TIME RECORD", SwingConstants.LEFT);			
		
		begPayPeriodL = new JLabel("Pay Period Beginning Date", SwingConstants.LEFT);			
		begPayPeriodTF = new JTextField(10);
		begPayPeriodTF.setHorizontalAlignment(JTextField.CENTER);
		endPayPeriodL = new JLabel("Pay Period Ending Date", SwingConstants.LEFT);			
		endPayPeriodTF = new JTextField(10);
		endPayPeriodTF.setHorizontalAlignment(JTextField.CENTER);


		hoursWorkedL = new JLabel("Hours Worked Breakdown", SwingConstants.CENTER);			
		rateOfPayL = new JLabel("Rate of Pay", SwingConstants.CENTER);			
		numberOfHoursL = new JLabel("Number of Hours", SwingConstants.CENTER);			
		totalPayL = new JLabel("Total Pay", SwingConstants.CENTER);			
		
		regularHoursL = new JLabel("Regular Hours", SwingConstants.LEFT);			
		regRateTF = new JTextField(5);
		regRateTF.setHorizontalAlignment(JTextField.CENTER);
		regHoursTF = new JTextField(5);
		regHoursTF.setHorizontalAlignment(JTextField.CENTER);
		regTotalTF = new JTextField(5);
		regTotalTF.setHorizontalAlignment(JTextField.CENTER);
		
		overtimeHoursL = new JLabel("Overtime Hours", SwingConstants.LEFT);			
		otRateTF = new JTextField(5);
		otRateTF.setHorizontalAlignment(JTextField.CENTER);
		otHoursTF = new JTextField(5);
		otHoursTF.setHorizontalAlignment(JTextField.CENTER);
		otTotalTF = new JTextField(5);
		otTotalTF.setHorizontalAlignment(JTextField.CENTER);
		
		grossPayL = new JLabel("Gross Pay for this Pay Period", SwingConstants.LEFT);			
		grsPayTF = new JTextField(5);
		grsPayTF.setHorizontalAlignment(JTextField.CENTER);
		
		deductionsL = new JLabel("Deductions:", SwingConstants.CENTER);			
		deductPercentageL = new JLabel("Percentages", SwingConstants.CENTER);			
		deductTotalL = new JLabel("Total", SwingConstants.CENTER);			

		federalWithholdingL = new JLabel("Federal Withholding", SwingConstants.LEFT);			
		fedPercentageTF = new JTextField(5);
		fedPercentageTF.setHorizontalAlignment(JTextField.CENTER);
		fedTotalTF = new JTextField(5);
		fedTotalTF.setHorizontalAlignment(JTextField.CENTER);
		
		stateWithholdingL = new JLabel("State Withholding", SwingConstants.LEFT);			
		stPercentageTF = new JTextField(5);
		stPercentageTF.setHorizontalAlignment(JTextField.CENTER);
		stTotalTF = new JTextField(5);
		stTotalTF.setHorizontalAlignment(JTextField.CENTER);

		insuranceL = new JLabel("Insurance Premium", SwingConstants.LEFT);			
		insPercentageTF = new JTextField(5);
		insPercentageTF.setHorizontalAlignment(JTextField.CENTER);
		insTotalTF = new JTextField(5);
		insTotalTF.setHorizontalAlignment(JTextField.CENTER);
		
		retirementL = new JLabel("401K Contribution", SwingConstants.LEFT);			
		retPercentageTF = new JTextField(5);
		retPercentageTF.setHorizontalAlignment(JTextField.CENTER);
		retTotalTF = new JTextField(5);
		retTotalTF.setHorizontalAlignment(JTextField.CENTER);
		
		netPayL = new JLabel("Net Pay for this Pay Period", SwingConstants.LEFT);			
		netPayTF = new JTextField(5);
		netPayTF.setHorizontalAlignment(JTextField.CENTER);

		YTDL = new JLabel("YEAR TO DATE CALCULATIONS", SwingConstants.LEFT);			
		
		grossYTDL = new JLabel("Gross Pay", SwingConstants.CENTER);
		fedYTDL = new JLabel("Fed Wth", SwingConstants.CENTER);
		stYTDL = new JLabel("State Wth", SwingConstants.CENTER);
		insYTDL = new JLabel("Insurance", SwingConstants.CENTER);
		retYTDL = new JLabel("401K", SwingConstants.CENTER);
		netYTDL = new JLabel("Net Pay", SwingConstants.CENTER);
		
		grossYTDTF = new JTextField(5);
		grossYTDTF.setHorizontalAlignment(JTextField.CENTER);
		fedYTDTF = new JTextField(5);
	   fedYTDTF.setHorizontalAlignment(JTextField.CENTER);
	   stYTDTF = new JTextField(5);
		stYTDTF.setHorizontalAlignment(JTextField.CENTER);
		insYTDTF = new JTextField(5);
		insYTDTF.setHorizontalAlignment(JTextField.CENTER);
		retYTDTF = new JTextField(5);
		retYTDTF.setHorizontalAlignment(JTextField.CENTER);
		netYTDTF = new JTextField(5);
		netYTDTF.setHorizontalAlignment(JTextField.CENTER);				
			
		Container pane = getContentPane();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		

		// Employee Information Section of pane
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(empnumL, c);
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 0;
		pane.add(empnumTF, c);
		
		c.weightx = 2.0; 
		c.gridx = 2;
		c.gridy = 0;
		pane.add(empnameL, c);
		c.weightx = 1.0;		
		c.gridx = 3;
		c.gridy = 0;
		pane.add(lnameTF, c);
		c.weightx = 1.0;
		c.gridx = 4;
		c.gridy = 0;
		pane.add(fnameTF, c);
	
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(spacerL, c);
		
		
		// Pay Period View of Timesheet Data
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 2;
		pane.add(section1L, c);

		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 3;
		pane.add(begPayPeriodL, c);
		c.weightx = 1.0;
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		pane.add(begPayPeriodTF, c);
		
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 4;
		pane.add(endPayPeriodL, c);
		c.weightx = 1.0;
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 1;
		pane.add(endPayPeriodTF, c);


		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 5;
		pane.add(hoursWorkedL, c);
		
		c.weightx = 1.0;
		c.gridx = 2;
		c.gridy = 5;
		pane.add(rateOfPayL, c);
		
		c.weightx = 1.0;
		c.gridx = 3;
		c.gridy = 5;
		pane.add(numberOfHoursL, c);
		
		c.weightx = 1.0;
		c.gridx = 4;
		c.gridy = 5;
		pane.add(totalPayL, c);


		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 6;
		pane.add(regularHoursL, c);

		c.weightx = 1.0;
		c.gridx = 2;
		c.gridy = 6;
		pane.add(regRateTF, c);
		
		c.weightx = 1.0;
		c.gridx = 3;
		c.gridy = 6;
		pane.add(regHoursTF, c);
		
		c.weightx = 1.0;
		c.gridx = 4;
		c.gridy = 6;
		pane.add(regTotalTF, c);


		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 7;
		pane.add(overtimeHoursL, c);

		c.weightx = 1.0;
		c.gridx = 2;
		c.gridy = 7;
		pane.add(otRateTF, c);
		
		c.weightx = 1.0;
		c.gridx = 3;
		c.gridy = 7;
		pane.add(otHoursTF, c);
		
		c.weightx = 1.0;
		c.gridx = 4;
		c.gridy = 7;
		pane.add(otTotalTF, c);
		
	
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 8;
		pane.add(grossPayL, c);

		c.weightx = 1.0;
		c.gridx = 4;
		c.gridy = 8;
		pane.add(grsPayTF, c);


		//DEDUCTIONS SECTION
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 9;
		pane.add(deductionsL, c);
		c.weightx = 1.0;
		c.gridx = 2;
		c.gridy = 9;
		pane.add(deductPercentageL, c);
		c.weightx = 1.0;
		c.gridx = 3;
		c.gridy = 9;
		pane.add(deductTotalL, c);

		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 10;
		pane.add(federalWithholdingL, c);
		c.weightx = 1.0;
		c.gridx = 2;
		c.gridy = 10;
		pane.add(fedPercentageTF, c);
		c.weightx = 1.0;
		c.gridx = 3;
		c.gridy = 10;
		pane.add(fedTotalTF, c);


		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 11;
		pane.add(stateWithholdingL, c);
		c.weightx = 1.0;
		c.gridx = 2;
		c.gridy = 11;
		pane.add(stPercentageTF, c);
		c.weightx = 1.0;
		c.gridx = 3;
		c.gridy = 11;
		pane.add(stTotalTF, c);
		
		
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 12;
		pane.add(insuranceL, c);
		c.weightx = 1.0;
		c.gridx = 2;
		c.gridy = 12;
		pane.add(insPercentageTF, c);
		c.weightx = 1.0;
		c.gridx = 3;
		c.gridy = 12;
		pane.add(insTotalTF, c);


		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 13;
		pane.add(retirementL, c);
		c.weightx = 1.0;
		c.gridx = 2;
		c.gridy = 13;
		pane.add(retPercentageTF, c);
		c.weightx = 1.0;
		c.gridx = 3;
		c.gridy = 13;
		pane.add(retTotalTF, c);


		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 14;
		pane.add(netPayL, c);
		c.weightx = 1.0;
		c.gridx = 4;
		c.gridy = 14;
		pane.add(netPayTF, c);


		// YEAR TO DATE CALCULATION SECTION
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 15;
		pane.add(YTDL, c);

		c.weightx = 1.0;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 16;
		pane.add(grossYTDL, c);
		c.weightx = 1.0;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 16;
		pane.add(fedYTDL, c);
		c.weightx = 1.0;
		c.gridwidth = 1;
		c.gridx = 2;
		c.gridy = 16;
		pane.add(stYTDL, c);
		c.weightx = 1.0;
		c.gridwidth = 1;
		c.gridx = 3;
		c.gridy = 16;
		pane.add(insYTDL, c);
		c.weightx = 1.0;
		c.gridwidth = 1;
		c.gridx = 4;
		c.gridy = 16;
		pane.add(retYTDL, c);
		c.weightx = 1.0;
		c.gridwidth = 1;
		c.gridx = 5;
		c.gridy = 16;
		pane.add(netYTDL, c);

		c.weightx = 1.0;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 17;
		pane.add(grossYTDTF, c);
		c.weightx = 1.0;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 17;
		pane.add(fedYTDTF, c);
		c.weightx = 1.0;
		c.gridwidth = 1;
		c.gridx = 2;
		c.gridy = 17;
		pane.add(stYTDTF, c);
		c.weightx = 1.0;
		c.gridwidth = 1;
		c.gridx = 3;
		c.gridy = 17;
		pane.add(insYTDTF, c);
		c.weightx = 1.0;
		c.gridwidth = 1;
		c.gridx = 4;
		c.gridy = 17;
		pane.add(retYTDTF, c);
		c.weightx = 1.0;
		c.gridwidth = 1;
		c.gridx = 5;
		c.gridy = 17;
		pane.add(netYTDTF, c);


		// Add buttons to add additional timecard information
		ntciB = new JButton("Add New Timecard Information");
		ntciHandler = new AddInfoHandler();
		ntciB.addActionListener(ntciHandler);
		
		c.weightx = 1.0;
		c.gridwidth = 2;
		c.gridheight = 2;
		c.gridx = 3;
		c.gridy = 3;
		pane.add(ntciB, c);

	
		// Add buttons to the bottom of the pane
		w2B = new JButton("View W-2");
		w2Handler = new ViewW2ButtonHandler();
		w2B.addActionListener(w2Handler);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 18;
		pane.add(w2B, c);
	
		infB = new JButton("View Input File Example");
		infHandler = new InputFileButtonHandler();
		infB.addActionListener(infHandler);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridwidth = 2;
		c.gridx = 2;
		c.gridy = 18;
		pane.add(infB, c);
		
		c.gridheight=1; 
	
		exitB = new JButton("Exit Program");
		ebHandler = new ExitButtonHandler();
		exitB.addActionListener(ebHandler);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridwidth = 2;
		c.gridx = 4;
		c.gridy = 18;
		pane.add(exitB, c);
	
		// Set pane settings
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
	}
	
	
	/** Method to validate that the user's input strings only contains numbers
	 *		for the regular and overtime hours inputs
	 *
	 *  @param t the user input string from the dialog. 
    *  @return a boolean value (true if only digits were found).
	 */
	public static boolean validateNumberInput(String t) {
	
		String errorMsg2;
	
		for (int i = 0; i < t.length(); i++) {

			//If we find a non-digit character we return false.
			if (!Character.isDigit(t.charAt(i))){
				errorMsg2 = "Please only numbers are valid for this input.";
				JOptionPane.showMessageDialog(null, errorMsg2, "Error with Hours Entered",
							JOptionPane.INFORMATION_MESSAGE);

				return false;
			}
		}
		return true;	
	}
	
	
	/** Method that performs the YTD calculations and displays them on the pane
	 *		
	 *
	 *  @param hourlyRate - received from input file. 
    *  @return void
	 */
	public static void calculateYTD(double hourlyRate)
	{
		double grossTot = 0;
		double fedTot = 0;
		double stTot = 0;
		double insTot = 0;
		double retTot = 0;	
		double netTot = 0;
		double rtot = 0;
		double otot = 0;
		double otRate = hourlyRate * 1.5;
		
		// Calculate totals and populate the arrays. 
		for (int t=0; t<=counter; t++) {
		
			rtot = hourlyRate * regHours[t];
			otot = otRate * otHours[t];
			grossTot = rtot + otot;
	
			fedTot = grossTot * fedRATE;	
			stTot = grossTot * stRATE;
			insTot = insRATE * counter;
			retTot = grossTot * retRATE;
			netTot = grossTot - fedTot - stTot - insTot - retTot;
			
			grossFinal += grossTot;
			fedFinal += fedTot;
			stFinal += stTot;
			insFinal += insTot;
			retFinal += retTot;	
			netFinal += netTot;
		}	 
		 
		// Set the textfields on the pane to reflect the totals calcuated
		grossYTDTF.setText("$" + String.format("%.2f", grossFinal));
		fedYTDTF.setText("$" + String.format("%.2f", fedFinal));
	   stYTDTF.setText("$" + String.format("%.2f", stFinal));
		insYTDTF.setText("$" + String.format("%.2f", insFinal));
		retYTDTF.setText("$" + String.format("%.2f", retFinal));
		netYTDTF.setText("$" + String.format("%.2f", netFinal));
		
	} // end calculateYTD method

	
	/** Method that displays the recent pay period info to the pane
	 *		Also used to update the form when new timecard info is added to the system
	 *
	 *  @param none 
    *  @return void
	 */
	public static void displayRecentPayPeriod()
	{
		empnumTF.setText("" + empNum);
		lnameTF.setText("" + fname);
		fnameTF.setText("" + lname);
		
		begPayPeriodTF.setText("" + begDate[counter]);
		endPayPeriodTF.setText("" + endDate[counter]);

		regRateTF.setText("" + hourlyRate);
		regHoursTF.setText("" + regHours[counter]);
		double rtot = hourlyRate * regHours[counter];
		regTotalTF.setText("$" + String.format("%.2f", rtot));
		
		otRateTF.setText("" + otRate);
		otHoursTF.setText("" + otHours[counter]);
		double otot = otRate * otHours[counter];
		otTotalTF.setText("$" + String.format("%.2f", otot));
		
		double gtot = rtot + otot;
		grsPayTF.setText("$" + String.format("%.2f", gtot));
		
		double fedAmt = gtot * fedRATE;	
		double stAmt = gtot * stRATE;
		double insAmt = insRATE;
		double retAmt = gtot * retRATE;
		double netAmt = gtot - fedAmt - stAmt - insAmt - retAmt;
		
		fedPercentageTF.setText("20%");
		fedTotalTF.setText("$" + String.format("%.2f", fedAmt));
		
		stPercentageTF.setText("8%");
		stTotalTF.setText("$" + String.format("%.2f", stAmt));

		insPercentageTF.setText("$50.00");
		insTotalTF.setText("$" + String.format("%.2f", insAmt));
		
		retPercentageTF.setText("5%");
		retTotalTF.setText("$" + String.format("%.2f", retAmt));
		
		netPayTF.setText("$" + String.format("%.2f", netAmt));
		
		calculateYTD(hourlyRate);
	} // end displayRecentPayPeriod method
	
	
	/** Event Handler method for when Add New Timecard Info button is triggered
	 * 
	 */
	private static class AddInfoHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Declare local variables for getting input from user & validating that information
			String getInfo = "";
			String errorMsg;
			
			String start;
			String end;
			int rh = 0;
			int oh = 0;
			
			Date currentTrans = new Date(begDate[counter]);
			Date newTrans = new Date();
						
			// Get Pay Period Beginning Date & until the user enters a validate input, keep requesting the info.
			do {
				getInfo = JOptionPane.showInputDialog("Please enter the Pay Period's Beginning Date (mm/dd/yy)");
				start = getInfo;
				newTrans = new Date(getInfo);
			} while (getInfo == "" || getInfo == null || getInfo.length() == 0);
			
			// Get Pay Period Ending Date & until the user enters a validate input, keep requesting the info.
			do {
				getInfo = JOptionPane.showInputDialog("Please enter the Pay Period's Ending Date (mm/dd/yy)");
				end = getInfo;
			} while (getInfo == "" || getInfo == null || getInfo.length() == 0);
			
			getInfo = "-1";
			
			// Get Regular Hours & until the user enters a validate input, keep requesting the info.			
			do {
			
				if (rh > 40) {
					errorMsg = "Only Regular Hours up to 40 are allowed.  All hours over 40 should be entered as overtime hours.";
					JOptionPane.showMessageDialog(null, errorMsg, "Error with Regular Hours Entered",
									JOptionPane.INFORMATION_MESSAGE);
				}
											
				getInfo = JOptionPane.showInputDialog("Please enter the number of Regular Hours that were worked");
				
				// Make sure input is numeric
				if (validateNumberInput(getInfo))
					rh = Integer.parseInt(getInfo);
			} while ( rh <= 0 || rh > 40 );
			
			// Get Overtime Hours & until the user enters a validate input, keep requesting the info.			
			if (rh == 40) {

				do {
				
					getInfo = JOptionPane.showInputDialog("Please enter the number of Overtime Hours that were worked");
					
					// Make sure the input is numeric
					if (validateNumberInput(getInfo))
						oh = Integer.parseInt(getInfo);
				} while ( oh <= 0 );
			}			
			
			// Enter the user's additional information into the arrays and display on the pane
			if ( start != null && end != null ) {
			
				counter++;
				begDate[counter] = start;
				endDate[counter] = end;
				regHours[counter] = rh;
				otHours[counter] = oh;	
			
				displayRecentPayPeriod();				
				
				errorMsg = "The new timecard information has been added to the system and displayed on the main form." + "\n";
				errorMsg += "Please note your input file has not been updated.";
				JOptionPane.showMessageDialog(null, errorMsg, "Thank you for your entry",
									JOptionPane.INFORMATION_MESSAGE);
			
			} else {
				errorMsg = "You have left one of the fields blank so no data was added to the system.  Please try again.";
				JOptionPane.showMessageDialog(null, errorMsg, "Error with Input",
									JOptionPane.INFORMATION_MESSAGE);
			}
						
		}	
	} // end AddInfoHandler method
	

	/** Event Handler for when View W-2 button is triggered.
	 *		Displays the W2 information for the current employee
	 */
	private static class ViewW2ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		
			String outputString;
			outputString = "W-2 COMPANY COPY" + "\n"
							 + "\n" 
							 + "EMPLOYEE ID              " + empNum + "\n"
							 + "EMPLOYEE NAME        " + fname + " " + lname + "\n"
		  					 + "\n" 
							 + "1.   Wages, Tips, etc     $" 
							 + String.format("%.2f", grossFinal) + "\n"
							 + "2.   Federal Withholding     $" 
							 + String.format("%.2f", fedFinal) + "\n"
							 + "3.   State Withholding      $"
							 + String.format("%.2f", stFinal) + "\n"
							 + "4.   Insurance Contributions    $"
							 + String.format("%.2f", insFinal) + "\n"
							 + "5.   Retirement Contributions   $"
							 + String.format("%.2f", retFinal) + "\n"
							 + "6.   NET PAY      $"
							 + String.format("%.2f", netFinal) + "\n";

			JOptionPane.showMessageDialog(null, outputString, "W-2 Information Preview",
									JOptionPane.INFORMATION_MESSAGE);
									
		}
	} // end ViewW2ButtonHandler method


	/** Event Handler for when Input File Example button is triggered.
	 *		View Sample method to display a sample of what the input file should look like
	 */
	private static class InputFileButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		
			String outputString;
			outputString = "Emp# LastName FirstName RegularRate" + "\n"
							 + "PayPeriodBeginningDate PayPeriodEndDate RegularHours OvertimeHours" + "\n"
							 + "\n" 
							 + "EXAMPLE:" + "\n"
							 + "0202 Smith John 10.35" + "\n"
							 + "1/1/10 1/14/10 30 0" + "\n"
							 + "1/15/10 1/28/10 40 10" + "\n"
							 + "1/29/10 2/11/10 40 15" + "\n";

			JOptionPane.showMessageDialog(null, outputString, "Input File Example",
									JOptionPane.INFORMATION_MESSAGE);
		
		
		}		
	} // end InputFileButtonHandler method

	
	/** Event Handler for when Exit button is triggered.
	 *		Closes the program
	 */
	private static class ExitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);	
		}	
	} // end ExitButtonHandler Action Listener
		
			
	/** Main Method to drive the Coders Central Payroll program
	 *		shows the user interface to the user and reads from the input file
	 *
	 *  @param - args - command line arguments (none required for this application).
    *  @throw FileNotFoundException if input file can not be located.
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
	
		CodersCentralPayroll app2Run = new CodersCentralPayroll();
		Scanner input = new Scanner(new FileReader("inputfile.txt"));		
		
		// START PROCESSING INFORMATION
		// Read in data from input file
		while(input.hasNext()){
		
			empNum = input.next();
			lname = input.next();		
			fname = input.next();
			hourlyRate = input.nextDouble();
			otRate = hourlyRate * 1.5;
			
			while(input.hasNext()) {
				counter++;
				begDate[counter] = input.next();
				endDate[counter] = input.next();
				regHours[counter] = input.nextDouble();
				otHours[counter] = input.nextDouble();
			}			
		}

		// Close input file		
		input.close();
		
		// Display the information gathered from the input file on the pane
		displayRecentPayPeriod();
				
	} // end main	
} // end class




