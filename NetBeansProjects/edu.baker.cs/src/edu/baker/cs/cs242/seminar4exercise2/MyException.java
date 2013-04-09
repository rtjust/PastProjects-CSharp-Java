/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.baker.cs.cs242.seminar4exercise2;

/**
 *
 * @author Rob
 */
public class MyException extends Exception {
    public MyException()
    {
         super("MyException thrown!");
         System.out.println("Immediate attention required!");
    }

    public MyException(String msg)
    {
        super(msg);
        System.out.println("Attention required!");
    }
           

}
