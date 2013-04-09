/*
 * @(#)ShapeGenerator.java        1.0 9/15/10
 *
 * Copyright (c) 2010 Rob Just
 */

package edu.baker.cs.cs242.seminar6exercise2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Class: ShapeGenerator
 * Description: This class is an applet that displays controls to create a series
 * of shapes of different number and color.
 *
 * @author     Rob Just
 * @created    September 15th, 2010
 */
public class ShapeGenerator extends JApplet implements ItemListener {

    // Constants for shapes
    private final int CIRCLE = 0;
    private final int OVAL = 1;
    private final int RECTANGLE = 2;
    private final int SQUARE = 3;

    private Color currentColor = Color.RED; // Current selected Color
    private int totalShapes = 0; // Total number of shapes to draw
    private int currentShape = 0; // Currently selected shape

    // Controls
    private JComboBox shapeColorDD;
    private JCheckBox oneCB, twoCB, fourCB, eightCB, sixteenCB;
    private JRadioButton circleRB, ovalRB, rectRB, squareRB;
    private ButtonGroup shapeSelectGroup;

    // Color names for the color control drop down
    private String[] shapeColors = {"Red", "Blue", "Green", "Yellow", "Pink",
                                    "Black", "Cyan", "Magenta"};

    // Method to initialize the applet, draws controls
    public void init() {
        Container c = getContentPane();
        c.setLayout(null);

        oneCB = new JCheckBox("1");
        twoCB = new JCheckBox("2");
        fourCB = new JCheckBox("4");
        eightCB = new JCheckBox("8");
        sixteenCB = new JCheckBox("16");

        circleRB = new JRadioButton("Circle");
        ovalRB = new JRadioButton("Oval");
        rectRB = new JRadioButton("Rectangle");
        squareRB = new JRadioButton("Square");

        shapeColorDD = new JComboBox(shapeColors);

        oneCB.setSize(80, 30);
        twoCB.setSize(80, 30);
        fourCB.setSize(80, 30);
        eightCB.setSize(80, 30);
        sixteenCB.setSize(80, 30);

        circleRB.setSize(80, 30);
        ovalRB.setSize(80, 30);
        rectRB.setSize(80, 30);
        squareRB.setSize(80, 30);

        shapeColorDD.setSize(80, 30);

        oneCB.setLocation(10, 20);
        twoCB.setLocation(10, 50);
        fourCB.setLocation(10, 80);
        eightCB.setLocation(10, 110);
        sixteenCB.setLocation(10, 140);

        circleRB.setLocation(110, 20);
        ovalRB.setLocation(110, 50);
        rectRB.setLocation(110, 80);
        squareRB.setLocation(110, 110);

        shapeColorDD.setLocation(210, 20);

        oneCB.addItemListener(this);
        twoCB.addItemListener(this);
        fourCB.addItemListener(this);
        eightCB.addItemListener(this);
        sixteenCB.addItemListener(this);

        circleRB.addItemListener(this);
        ovalRB.addItemListener(this);
        rectRB.addItemListener(this);
        squareRB.addItemListener(this);

        shapeColorDD.addItemListener(this);

        circleRB.setSelected(true);
        oneCB.setSelected(true);

        c.add(oneCB);
        c.add(twoCB);
        c.add(fourCB);
        c.add(eightCB);
        c.add(sixteenCB);

        c.add(circleRB);
        c.add(ovalRB);
        c.add(rectRB);
        c.add(squareRB);

        c.add(shapeColorDD);

        shapeSelectGroup = new ButtonGroup();
        shapeSelectGroup.add(circleRB);
        shapeSelectGroup.add(ovalRB);
        shapeSelectGroup.add(rectRB);
        shapeSelectGroup.add(squareRB);
    }

    // Method to paint the shapes each time a control's state is changed
    public void paint(Graphics g)
    {
        super.paint(g);

        final int SHAPE_WIDTH = 100;
        final int SHAPE_HEIGHT = 100;

        int x;
        int y;

        int i;

        for (i = 0; i < totalShapes; i++)
        {
            g.setColor(currentColor);

            x = 200 + (i * 10);
            y = 200 + (i * 10);

            switch (currentShape)
            {
                case 0:
                    g.drawOval(x, y, SHAPE_WIDTH, SHAPE_HEIGHT);
                    break;
                case 1:
                    g.drawOval(x, y, SHAPE_WIDTH, SHAPE_HEIGHT + 100);
                    break;
                case 2:
                    g.drawRect(x, y, SHAPE_WIDTH, SHAPE_HEIGHT + 100);
                    break;
                case 3:
                    g.drawRect(x, y, SHAPE_WIDTH, SHAPE_HEIGHT);
                    break;
            }

        }

    }

    // Event handler that listens for a state change and then updates the
    // relevant variable, calls repaint()
    public void itemStateChanged(ItemEvent e) {
        // Number of shapes
        if (e.getSource() == oneCB)
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
                totalShapes += 1;
            if (e.getStateChange() == ItemEvent.DESELECTED)
                totalShapes -= 1;
        }

        if (e.getSource() == twoCB)
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
                totalShapes += 2;
            if (e.getStateChange() == ItemEvent.DESELECTED)
                totalShapes -= 2;
        }

        if (e.getSource() == fourCB)
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
                totalShapes += 4;
            if (e.getStateChange() == ItemEvent.DESELECTED)
                totalShapes -= 4;
        }

        if (e.getSource() == eightCB)
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
                totalShapes += 8;
            if (e.getStateChange() == ItemEvent.DESELECTED)
                totalShapes -= 8;
        }

        if (e.getSource() == sixteenCB)
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
                totalShapes += 16;
            if (e.getStateChange() == ItemEvent.DESELECTED)
                totalShapes -= 16;
        }

        // Type of shape
        if (e.getSource() == circleRB)
            currentShape = CIRCLE;
        else if (e.getSource() == ovalRB)
            currentShape = OVAL;
        else if (e.getSource() == rectRB)
            currentShape = RECTANGLE;
        else if (e.getSource() == squareRB)
            currentShape = SQUARE;      

        // Color of shape
        if (e.getSource() == shapeColorDD)
        {
            switch (shapeColorDD.getSelectedIndex())
            {
                case 0:
                    currentColor = Color.RED;
                    break;
                case 1:
                    currentColor = Color.BLUE;
                    break;
                case 2:
                    currentColor = Color.GREEN;
                    break;
                case 3:
                    currentColor = Color.YELLOW;
                    break;
                case 4:
                    currentColor = Color.PINK;
                    break;
                case 5:
                    currentColor = Color.BLACK;
                    break;
                case 6:
                    currentColor = Color.CYAN;
                    break;
                case 7:
                    currentColor = Color.MAGENTA;
                    break;
            }
        }
       
        repaint();
    }


}
