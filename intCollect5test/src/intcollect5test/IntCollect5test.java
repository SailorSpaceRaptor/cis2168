/*
 * intCollect5 client written for CIS 2168 Fall 2015, this client uses several commands to test the intColl5 class
 */
package intcollect5test;

/**
 *
 * @author Jonathan
 */
public class IntCollect5test 
{

    public static void main(String[] args) 
    {
        intColl5 c = new intColl5();
        intColl5 d = new intColl5();
        
        c.insert(42);
        c.insert(56);
        c.insert(255);
        c.insert(98);
        
        c.print();
        
       int howMany = c.get_howMany();
       System.out.println("The list currently has " + howMany + "objects");
       
       System.out.println("Now omit 42 from list");
       
       c.omit(42);
       
       c.print();
       
       int howMany2 = c.get_howMany();
       System.out.println("The list now has " + howMany2 + " objects");
       
       System.out.println("We will check to see if 255 belongs in the list.");
       
       if (c.belongs(255))
       {
           System.out.println("255 totally belongs in the list");
       }
       else
           System.out.println("FAILURE!");
       
       System.out.println("We will now try to copy contents of list c into list d");
       
       d.copy(c);
       
       d.print();
       
       System.out.println("Lastly we will check for equality between the two lists");
       
       if(c.equals(d))
       {
           System.out.println("Lists are 100% equal");
       }
       else
       {
           System.out.println("FAILURE!");
       }
       
       
    }
    
}
