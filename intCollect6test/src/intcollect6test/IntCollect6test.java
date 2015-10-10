/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcollect6test;

/**
 *
 * @author Jonathan
 */
public class IntCollect6test
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        intColl6 c = new intColl6();
        
        c.insert(23);
        c.insert(200);
        c.insert(37);
        c.insert(42);
        
        c.print();
        
        int howMany = c.get_howMany();
        
        System.out.println("Let's see how many objects are in this list");
        System.out.println(howMany);
        
        System.out.println("We will now omit");
        c.omit(23);
        
        c.print();
    }
    
}
