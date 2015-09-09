/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcoll3test;

/**
 *
 * @author Jonathan
 */
public class IntColl3Test 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Intcoll3 P = new Intcoll3();
        Intcoll3 Q = new Intcoll3();
        
        P.insert(3);
        P.insert(4);
        P.insert(10);
        P.insert(90);
        P.insert(30);
        P.insert(42);
        P.insert(52);
        P.insert(600);
        
        P.print();
        
        int howmany = (P.get_howmany());
        
        System.out.println("There are " + howmany + " objects in the collection");
        
        System.out.println("We will now test omit function by removing 90.");
        
        P.omit(90);
        
        int howmany2 = (P.get_howmany());
        System.out.println("There are now " + howmany2 + " objects in the collection");
        P.print();
        
        System.out.println("We will now copy P into Q");
        
        Q.copy(P);
        
        Q.print();
        
        System.out.println("Let's test to see if 42 belongs in Q");
        
        if(Q.belongs(42) == true)
        {
            System.out.println("Yes, 42 totally belongs in Q");
        }
        else
        {
            System.out.println("Failure");
        }
    
    System.out.println("lastly we will check for equality amongst Q and P");
    
    if(P.equals(Q))
    {
        System.out.println("both collections are equal");
    }
    else
    {
        System.out.println("failure");
    }
    
    }
}