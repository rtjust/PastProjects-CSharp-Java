/*
 * @(#)RotCipherApp.java        1.0 8/4/10
 *
 * Copyright (c) 2010 Rob Just
 */

package edu.baker.cs.cs242.FinalProject.RotCipher;

/**
 * Class: RotCipherApp
 * Description: This class contains the main function that launches the
 * application window (contained in RotCipherView). Most of this code was
 * generated by NetBeans using the Matisse GUI editor.
 *
 * @author     Rob Just
 * @created    August 4th, 2010
 */
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class RotCipherApp extends SingleFrameApplication
{

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup()
    {
        show(new RotCipherView(this));
        getMainFrame().setTitle("Rot Cipher\\Decipher Utility"); // Set Title
        getMainFrame().setSize(650, 425); // Set size of window
        getMainFrame().setResizable(false); // Do not allow resizing
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root)
    {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of RotCipherApp
     */
    public static RotCipherApp getApplication()
    {
        return Application.getInstance(RotCipherApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args)
    {
        launch(RotCipherApp.class, args);
    }
}
