/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.baker.cs.cs242.seminar4exercise2;

import edu.baker.cs.cs242.seminar4exercise2.MyException;


/**
 *
 * @author Rob
 */
public class TestClass {

    public static void main(String[] args) throws MyException
    {
        SuperClass superObject = new SuperClass("This is superclass", 2);
        SubClass subObject = new SubClass("DDDDDD", 3, 7);

        superObject.print();
        subObject.print();
        try
        {
            throw new MyException();
        }
        catch (MyException e)
        {
           // System.out.println(e.toString());
        }
        
    }
}
