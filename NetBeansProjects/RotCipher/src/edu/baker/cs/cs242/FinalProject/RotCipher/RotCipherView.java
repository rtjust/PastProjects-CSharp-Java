/*
 * @(#)RotCipherView.java        1.0 8/4/10
 *
 * Copyright (c) 2010 Rob Just
 */

package edu.baker.cs.cs242.FinalProject.RotCipher;

/**
 * Class: RotCipherView
 * Description: This class contains FrameView that houses the GUI components.
 * It also contains the event handlers for the controls and methods called by
 * those event handlers.
 * The programs purpose is to cipher\decipher text entered or loaded from a file.
 * The text is then run through the RotCipher object to be cipher\deciphered.
 * The output from the RotCipher object is displayed in a text area.
 * The result can then be saved to a file.
 * The initComponents() method was generated by NetBeans using the Matisse GUI
 * editor. This method creates and positions the GUI elements.
 *
 *
 * @author     Rob Just
 * @created    August 4th, 2010
 */
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

/**
 * The application's main frame.
 */
public class RotCipherView extends FrameView
{

    public RotCipherView(SingleFrameApplication app)
    {
        super(app);
        initComponents();  // Auto generated code from NetBeans GUI editor
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        cipherDecipherButton = new javax.swing.JButton();
        resultTAScrollPane = new javax.swing.JScrollPane();
        cipherResultTextArea = new javax.swing.JTextArea();
        cipherTAScrollPane = new javax.swing.JScrollPane();
        cipherTextArea = new javax.swing.JTextArea();
        inputLabel = new javax.swing.JLabel();
        resultLabel = new javax.swing.JLabel();
        loadFileButton = new javax.swing.JButton();
        rot47Radio = new javax.swing.JRadioButton();
        saveFileButton = new javax.swing.JButton();
        rot13Radio = new javax.swing.JRadioButton();
        typeLabel = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        clearTextButton = new javax.swing.JButton();
        cipherRadioGroup = new javax.swing.ButtonGroup();

        mainPanel.setMaximumSize(new java.awt.Dimension(0, 0));
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cipherDecipherButton.setText("Run Cipher\\Decipher");
        cipherDecipherButton.setToolTipText("");
        cipherDecipherButton.setName("cipherDecipherButton"); // NOI18N
        cipherDecipherButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cipherDecipherButtonMouseClicked(evt);
            }
        });
        mainPanel.add(cipherDecipherButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 120, 140, -1));

        resultTAScrollPane.setName("resultTAScrollPane"); // NOI18N

        cipherResultTextArea.setColumns(20);
        cipherResultTextArea.setEditable(false);
        cipherResultTextArea.setFont(cipherResultTextArea.getFont());
        cipherResultTextArea.setLineWrap(true);
        cipherResultTextArea.setRows(5);
        cipherResultTextArea.setWrapStyleWord(true);
        cipherResultTextArea.setName("cipherResultTextArea"); // NOI18N
        resultTAScrollPane.setViewportView(cipherResultTextArea);

        mainPanel.add(resultTAScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 439, 130));

        cipherTAScrollPane.setName("cipherTAScrollPane"); // NOI18N

        cipherTextArea.setColumns(20);
        cipherTextArea.setFont(cipherTextArea.getFont());
        cipherTextArea.setLineWrap(true);
        cipherTextArea.setRows(5);
        cipherTextArea.setWrapStyleWord(true);
        cipherTextArea.setName("cipherTextArea"); // NOI18N
        cipherTAScrollPane.setViewportView(cipherTextArea);

        mainPanel.add(cipherTAScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 440, 128));

        inputLabel.setText("Text to cipher\\decipher:");
        inputLabel.setName("inputLabel"); // NOI18N
        mainPanel.add(inputLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        resultLabel.setText("Result of cipher\\decipher:");
        resultLabel.setName("resultLabel"); // NOI18N
        mainPanel.add(resultLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        loadFileButton.setText("Load text from file \"CipherInputFile.txt\"");
        loadFileButton.setName("loadFileButton"); // NOI18N
        loadFileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadFileButtonMouseClicked(evt);
            }
        });
        mainPanel.add(loadFileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 440, -1));

        cipherRadioGroup.add(rot47Radio);
        rot47Radio.setText("Rot47");
        rot47Radio.setName("rot47Radio"); // NOI18N
        mainPanel.add(rot47Radio, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));

        saveFileButton.setText("Save text to file \"CipherOutputFile.txt\"");
        saveFileButton.setName("saveFileButton"); // NOI18N
        saveFileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveFileButtonMouseClicked(evt);
            }
        });
        mainPanel.add(saveFileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 439, -1));

        cipherRadioGroup.add(rot13Radio);
        rot13Radio.setSelected(true);
        rot13Radio.setText("Rot13");
        rot13Radio.setName("rot13Radio"); // NOI18N
        mainPanel.add(rot13Radio, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        typeLabel.setText("Type of cipher:");
        typeLabel.setName("typeLabel"); // NOI18N
        mainPanel.add(typeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, -1));

        exitButton.setText("Exit");
        exitButton.setName("exitButton"); // NOI18N
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });
        mainPanel.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 350, 140, -1));

        clearTextButton.setText("Clear Text Fields");
        clearTextButton.setToolTipText("");
        clearTextButton.setName("clearTextButton"); // NOI18N
        clearTextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearTextButtonMouseClicked(evt);
            }
        });
        mainPanel.add(clearTextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 170, 140, -1));

        setComponent(mainPanel);
    }// </editor-fold>//GEN-END:initComponents

    // cipherDecipherButton click event handler
    private void cipherDecipherButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cipherDecipherButtonMouseClicked
        performCipher();
    }//GEN-LAST:event_cipherDecipherButtonMouseClicked

    // loadFileButton click event handler
    private void loadFileButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadFileButtonMouseClicked
            loadTextFromFile();
    }//GEN-LAST:event_loadFileButtonMouseClicked

    // saveFileButton click event handler
    private void saveFileButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveFileButtonMouseClicked
            saveTextToFile();
    }//GEN-LAST:event_saveFileButtonMouseClicked

    // exitButton click event handler
    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        System.exit(0); // Shutdown the JVM
    }//GEN-LAST:event_exitButtonMouseClicked
    
    // clearTextButton click event handler
    private void clearTextButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearTextButtonMouseClicked
        int selectedOption;
        
        // Ask to clear text area fields
        selectedOption = JOptionPane.showConfirmDialog(mainPanel, "Are you sure"
                + " you want to clear the text fields?", "Clear fields",
                JOptionPane.YES_NO_OPTION);

        // Clear the text fields if the user answers Yes
        if (selectedOption == JOptionPane.YES_OPTION)
        {
           cipherTextArea.setText("");
           cipherResultTextArea.setText("");
        }
        
    }//GEN-LAST:event_clearTextButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cipherDecipherButton;
    private javax.swing.ButtonGroup cipherRadioGroup;
    private javax.swing.JTextArea cipherResultTextArea;
    private javax.swing.JScrollPane cipherTAScrollPane;
    private javax.swing.JTextArea cipherTextArea;
    private javax.swing.JButton clearTextButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel inputLabel;
    private javax.swing.JButton loadFileButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JScrollPane resultTAScrollPane;
    private javax.swing.JRadioButton rot13Radio;
    private javax.swing.JRadioButton rot47Radio;
    private javax.swing.JButton saveFileButton;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables

    private RotCipher cipher = new RotCipher(); // Create RotCipher object

    // Loads text from specified file into cipherTextArea
    private void loadTextFromFile()
    {
          StringBuilder cipherText = new StringBuilder();
          try
          {
              Scanner inFile = new Scanner(new FileReader("CipherInputFile.txt"));
              
              // Read each line from file and add newline character
              while (inFile.hasNext())
              {
                  cipherText.append(inFile.nextLine());
                  cipherText.append("\n");
              }

              // Success, display message
              JOptionPane.showMessageDialog(mainPanel, "Text was loaded from file: "
                    + "CipherInputFile.txt", "File opened",
                    JOptionPane.INFORMATION_MESSAGE, null);

              cipherTextArea.setText(cipherText.toString());
              inFile.close(); // Close the file
          }
          catch (FileNotFoundException ex)
          {
                JOptionPane.showMessageDialog(mainPanel, "Unable to open file "
                + "CipherInputFile.txt. Please make sure the file exists.",
                "File open error", JOptionPane.ERROR_MESSAGE, null);
          }

    }

    // Saves text from cipherResultTextArea to file specified
    private void saveTextToFile()
    {
        String cipherText = "";    
        cipherText = cipherResultTextArea.getText();
        Scanner inFile = new Scanner(cipherText);
        try
        {
            PrintWriter outFile = new PrintWriter("CipherOutputFile.txt");
            // Write each line to the file
            while (inFile.hasNext())
            {
                outFile.println(inFile.nextLine());
            }

            // Success, display message
            JOptionPane.showMessageDialog(mainPanel, "Text was saved to file: "
                    + "CipherOutputFile.txt", "File saved",
                    JOptionPane.INFORMATION_MESSAGE, null);

            outFile.close(); // Close the file
        }
        catch (FileNotFoundException ex)
        {
             JOptionPane.showMessageDialog(mainPanel, "Unable to save file "
             + "CipherOutputFile.txt. Please make sure the file isn't "
             + "already in use or write protected.", "File save error",
             JOptionPane.ERROR_MESSAGE, null);
        }
    }

    // Uses the RotCipher object to cipher\decipher cipherTextArea and output it
    // to the cipherResultTextArea
    private void performCipher()
    {
        String cipherInputText = "";
        String cipherResultText = "";

        cipherInputText = cipherTextArea.getText();

        // Validate user entry, if empty display error, otherwise run cipher
        if (cipherInputText.isEmpty())
        {
            JOptionPane.showMessageDialog(mainPanel, "Please enter some text "
                    + "or load text from a file before running the cipher. "
                    + "\nPlease try again.", "No text entered",
                    JOptionPane.ERROR_MESSAGE, null);
        }
        else
        {
            if (rot13Radio.isSelected())
            {
                cipherResultText = cipher.getRot13String(cipherInputText);
            }
            else if (rot47Radio.isSelected())
            {
                cipherResultText = cipher.getRot47String(cipherInputText);
            }
        cipherResultTextArea.setText(cipherResultText);
        }
    }


}
