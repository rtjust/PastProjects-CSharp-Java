/*
 * Final Project. Calculate payroll. If the hours are over 40 hours,
 * add in overtime pay. Show output screen and output to text file with
 * information. (EmployeePayroll.txt)
 *
 * @author     Adam Klose
 * @created    July 27, 2010
 */

package hourcalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class hourcalc extends JFrame {

   // declares GUI variables
   private JLabel dateL, nameL, payrateL, hoursworkedL, otworkedL;

   private JTextField dateTF, nameTF, payrateTF, hoursworkedTF, otworkedTF;

   private JButton exitB, calculateB;

   private ExitButtonHandler ebHandler;
   private CalculateButtonHandler cbHandler;
   
   private static final int WIDTH = 400;
   private static final int HEIGHT = 200;

   public static FileOutputStream Output;
   public static PrintStream file;

   public hourcalc()
   {
      //Create the labels
      dateL = new JLabel("Enter Pay Date: ",
                                  SwingConstants.RIGHT);
      nameL = new JLabel("Enter Employee Name: ",
                                  SwingConstants.RIGHT);
      payrateL = new JLabel("Enter Employee Pay Rate: ",
                                  SwingConstants.RIGHT);
      hoursworkedL = new JLabel("Enter Regular Hours Worked: ",
                                  SwingConstants.RIGHT);
      otworkedL = new JLabel("Enter Overtime Hours Worked: ",
                                  SwingConstants.RIGHT);
      
      //Create the text fields
      dateTF = new JTextField(10);
      nameTF = new JTextField(10);
      payrateTF = new JTextField(10);
      hoursworkedTF = new JTextField(10);
      otworkedTF = new JTextField(10);
      
      //Create Exit Button
      exitB = new JButton("Exit");
      ebHandler = new ExitButtonHandler();
      exitB.addActionListener(ebHandler);

      //Create Calculate Button
      calculateB = new JButton("Calculate");
      cbHandler = new CalculateButtonHandler();
      calculateB.addActionListener(cbHandler);

      //Set the title of the window
      setTitle("Hourly Employee Payroll Program");

      //Get the container
      Container pane = getContentPane();

      //Set the layout
      pane.setLayout(new GridLayout(6, 2));

      //Place components in the pane
      pane.add(dateL);
      pane.add(dateTF);
      pane.add(nameL);
      pane.add(nameTF);
      pane.add(payrateL);
      pane.add(payrateTF);
      pane.add(hoursworkedL);
      pane.add(hoursworkedTF);
      pane.add(otworkedL);
      pane.add(otworkedTF);
      pane.add(exitB);
      pane.add(calculateB);

      //Set the size of the window and display it
      setSize(WIDTH, HEIGHT);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   // event handler for exit button
   private class ExitButtonHandler implements ActionListener
   {
       public void actionPerformed(ActionEvent e)
       {
           System.exit(0);
       }
   }
   // event handler for calculate button
   private class CalculateButtonHandler implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         double payRate, hours, basePay, overtimePay, overtimeHours, netPay;
         String payDate, name, hoursErr, outputStr;

         payDate = (dateTF.getText());
         name = (nameTF.getText());
         payRate = Double.parseDouble(payrateTF.getText().is);
         hours = Double.parseDouble(hoursworkedTF.getText());
         overtimeHours = Double.parseDouble(otworkedTF.getText());
         basePay = payRate * hours;
         overtimePay = (1.5 * payRate) * overtimeHours;
         netPay = basePay + overtimePay;

         // throw error if hours entered is more than 40
         if (hours > 40) {
         hoursErr = "Hours worked must be 40 or less. Please enter "
                 + "the data again. Any additional time over 40 is considered"
                 + " overtime.";
         
                 JOptionPane.showMessageDialog(null, hoursErr,
                 "Error",
                 JOptionPane.ERROR_MESSAGE); }
         
        // or continue with output
        else {

        outputStr = "Regular Pay: $" + basePay + "\n" +
                     "Overtime Pay: $" + overtimePay + "\n" +
                     "Total Pay: $" + netPay + "\n\n" +
                     "Summary available in the EmployeePayroll.txt file.";

        JOptionPane.showMessageDialog(null, outputStr,
                 "Total Pay for " + name + ".",
                 JOptionPane.INFORMATION_MESSAGE);

          }

       try {
	 // Create text file, publish information, and close it.
	 FileWriter fstream = new FileWriter("EmployeePayroll.txt", true);
         BufferedWriter out = new BufferedWriter(fstream);
         out.write("***Pay Calculation***\n");
         out.write("Pay Date: " + payDate + "\n");
         out.write("Employee Name: " + name + "\n");
         out.write("Pay Rate: " + payRate + "\n");
         out.write("Regular Hours: " + hours + "\n");
         out.write("Overtime Hours: " + overtimeHours + "\n");
         out.write("Regular Pay: $" + basePay + "\n");
         out.write("Overtime Pay: $" + overtimePay + "\n");
         out.write("Total Pay: $" + netPay + "\n");

         //Close the output stream
         out.close();
	  }
	  catch (Exception f){//Catch exception if any
		  System.err.println("Error: " + f.getMessage());
	  }          
      }
   }

   public static void main(String[] args)
   {
       hourcalc hourObject = new hourcalc();
   }
}
