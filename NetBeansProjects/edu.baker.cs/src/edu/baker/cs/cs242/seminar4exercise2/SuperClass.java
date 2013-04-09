/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.baker.cs.cs242.seminar4exercise2;

/**
 *
 * @author Rob
 */
public class SuperClass {
    protected int x;
    private String str;

    public void print()
    {
        System.out.println(x + " " + str);
    }

    public SuperClass()
    {
        str = "";
        x = 0;
    }

    public SuperClass(String s, int a)
    {
        str = s;
        x = a;
    }
}
