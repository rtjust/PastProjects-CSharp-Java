/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.baker.cs.cs242.seminar2exercise3;
import java.util.Vector;
/**
 *
 * @author Rob
 */
public class insertionSort {

     public static void main(String args[])
    {
           // int[] list = { 18, 8, 11, 9, 15, 20, 32, 61, 22, 48, 75, 83, 35, 3 };
          //  insertSort(list, 14);
         Vector<String> strList = new Vector<String>();
         Vector<Integer> intList = new Vector<Integer>();

         strList.addElement("Hello");
         intList.addElement(10);
         strList.addElement("Happy");
         intList.addElement(20);
         strList.addElement("Sunny");
         intList.addElement(30);

         System.out.println("strList: " + strList);
         System.out.println("intList: " + intList);

         strList.insertElementAt("Joy", 2);
         intList.removeElement(20);

         System.out.println("strList: " + strList);
         System.out.println("intList: " + intList);


     }

     public static void insertSort(int[] list, int listLength)
    {
         int firstOutOfOrder, location;
         int temp;
         int comparisons = 0;

         for (firstOutOfOrder = 1; firstOutOfOrder < listLength; firstOutOfOrder++)
         {
             
             
             if (list[firstOutOfOrder] < list[firstOutOfOrder - 1]){
                 comparisons++;
                 System.out.println(list[firstOutOfOrder] + " is less than " + list[firstOutOfOrder - 1]);
                 System.out.println("inside if: " + comparisons);
                 temp = list[firstOutOfOrder];
                 location = firstOutOfOrder;

                 do
                 {
                     list[location] = list[location - 1];
                     location--;                 
                     comparisons++;
                     System.out.println("inside do: " + comparisons);
                     //System.out.println(temp + " is less than " + list[location - 1]);
                 } while (location > 0 && list[location - 1] > temp);

                 list[location] = temp;
             }
        }


         System.out.println(comparisons);
     }
}
