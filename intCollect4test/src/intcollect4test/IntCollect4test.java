/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcollect4test;

/**
 *
 * @author Jonathan
 */
public class IntCollect4test 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        intColl4 g = new intColl4();
        intColl4 f = new intColl4();
        
        g.insert(42);
        g.insert(36);
        g.insert(89);
        g.insert(20);
        g.insert(39);
        g.insert(295);
        g.insert(150);
        
        int howMany = g.get_howmany();
        
        g.print();
        System.out.println("There are " + howMany + " objects in the list" );
        
        System.out.println("We will now omit the first value in the list, 150");
        
        g.omit(150);
        
        g.print();
        int howMany2 = g.get_howmany();
        
        System.out.println("There are now " + howMany2 + " objects in the list" );
        
        System.out.println("We will now check to see if 42 belongs in the list");
        if(g.belongs(42) == true)
            System.out.println("42 totally belongs in the list");
        else
            System.out.println("FAILURE!");
        
        System.out.println("We will now test the copy method");
        f.copy(g);
        
        System.out.println("Printing new list, F");
        f.print();
        
        System.out.println("We will now test for equality to make sure the lists are 100% equal");
        
        if(f.equals(g))
        {
            System.out.println("The two lists are totally equal.");
        }
        else
        {
            System.out.println("TOTAL FAILURE!!");
        }
        
    }
    
}
