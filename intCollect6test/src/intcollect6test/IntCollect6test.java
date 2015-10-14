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
        intColl6 d = new intColl6();
        
        c.insert(75);
        c.insert(50);
        c.insert(23);
        c.insert(200);
        c.insert(37);
        c.insert(30);
        c.insert(42);
        
        c.print();
        
        int howMany = c.get_howMany();
        
        System.out.println("Let's see how many objects are in this list");
        System.out.println(howMany);
        
        System.out.println("We will now omit");
        c.omit(75);
        
        c.print();
        
        int howMany2 = c.get_howMany();
        System.out.println("There are now " + howMany2 + " objects in the list.");
    
    System.out.println("Now we will copy the list.");
    
    d.copy(c);
    d.print();
    
    System.out.println("Now we will test to see if 42 belongs in the list");
    if(c.belongs(42))
        System.out.println("42 totally belongs in the list");
    else
        System.out.println("FAILURE!");
            
    System.out.println("Now we'll verify the two lists are equal");
    if(d.equals(c))
        System.out.println("Yup, these two are totally equal");
    else
        System.out.println("FAILURE!");
    
    }
    
}
