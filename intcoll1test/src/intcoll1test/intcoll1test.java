/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcoll1test;
import java.util.*;
/**
 *
 * @author Jonathan
 */
public class intcoll1test 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        intColl1 P = new intColl1(6);
        intColl1 Q = new intColl1();
        
        P.insert(3);
        P.insert(4);
        P.insert(10);
        P.insert(90);
        P.insert(30);
        P.insert(42);
        P.insert(52);
        
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
        
        System.out.println("To verify, we will test equality between P and Q");
        
        P.equals(Q);
        
        if(P.equals(Q)== true)
        {
            System.out.println("Collections are Equal");
        }
        else
        {
            System.out.println("failure");
        }
        
        System.out.println("One last test, does 42 belong to the collection?");
        
        if(P.belongs(42)== true)
        {
            System.out.println("42 totally belongs in this collection.");
        }
        else
        {
           System.out.println("failure");        
        }
    }
    
}
