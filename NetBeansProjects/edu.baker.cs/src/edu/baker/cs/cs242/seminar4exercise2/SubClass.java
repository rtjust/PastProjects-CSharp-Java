/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baker.cs.cs242.seminar4exercise2;

/**
 *
 * @author Rob
 */
public class SubClass extends SuperClass {

    private int y;

    @Override
    public void print() {
        System.out.println("SubClass: " + y);
        super.print();
    }

    public SubClass() {
        super();
        y = 0;
    }

    public SubClass(String s, int a, int b) {
        super("Hello Super", a + b);
        y = b;
    }
}
