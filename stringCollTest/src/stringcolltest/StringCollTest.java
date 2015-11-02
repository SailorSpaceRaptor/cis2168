/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringcolltest;

/**
 *
 * @author Jonathan
 */
public class StringCollTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        stringColl s = new stringColl();
        stringColl t = new stringColl();
        multiStringcoll m = new multiStringcoll();
        multiStringcoll n = new multiStringcoll();
        
        s.insert("foot");
        s.insert("sausage");
        s.insert("abc");
        s.insert("PYT");
        s.insert("Thriller");
        s.insert("Beat It");
        s.insert("Bad");
        
        s.print();
        System.out.println("try to omit sausage from the collection");
        
        s.omit("sausage");
        
        s.print();
        
        System.out.println("Omit PYT from list");
        s.omit("PYT");
        
        s.print();
        
        System.out.println("now copy each list");
        
        t.copy(s);
        
        t.print();
        
        System.out.println("Does Thriller belong in this list?");
        
        if(s.belongs("Thriller") == 1)
        {
            System.out.println("We're talkin' Thrilleeeeeer!! Thrilleeeer niiight!");
        }
        else
        {
            System.out.println("You've been struck by a smoooooth criminal");
        }
        
        System.out.println("---------------------------------now testing multiStringColl--------------------------------------------------------");
        
        m.insert("a");
        m.insert("a");
        m.insert("a");
        m.insert("hello world");
        m.insert("hello");
        m.insert("Estelle Getty");
        m.insert("Estelle Getty");
        m.insert("Estelle Getty");
        m.insert("Bea Arthur");
        m.insert("Betty White");
        m.insert("Bea Arthur");
        m.insert("Bea Arthur");
        m.insert("Bea Arthur");
        m.insert("Bea Arthur");
        
         
       m.print();
       
       System.out.println("There are too many Bea Arthurs!");
       m.omit("Bea Arthur");
       
       m.print();
       System.out.println("Now try to get rid of Betty");
       
       m.omit("Betty White");
       
       m.print();
       System.out.println("Testing copy method");
       n.copy(m);
       
       
       n.print();
       
       System.out.println("check to see if Bea Arthur is still in the list");
       
       if(m.belongs("Bea Arthur") == 1)
       {
           System.out.println("BEEEEA ARRRTHUUUUR!!!");
       }
       else
       {
       System.out.println("I am saddened by the lack of Bea Arthur.");    
       }
       
       System.out.println("check for equality");
       
       if(n.equals(m)== true)
       {
        System.out.println("The Golden Girls approve");   
       }
       else
       {
           System.out.println("You failed the golden girls.");
       }
    
    System.out.println("Let's try to omit then try equals again");
    n.omit("Bea Arthur");
    if(n.equals(m))
    {
     System.out.println("Close, so so close");   
    }
    else
    {
        System.out.println("2 for 2!");
    }
    }
    
}
