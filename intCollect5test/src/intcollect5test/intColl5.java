/*
 * To change this license header, choose License Headers in Project Properties.
 * This class is for use in CIS2168 Fall 2015, we are creating a new Int Collect class using the Java API linked list class
 */
package intcollect5test;

import java.util.*;

/**
 *
 * @author Jonathan
 */
public class intColl5 
{
  
 private LinkedList<Integer> intList;

// default constructor for intColl5, sets intList to null and howMany to 0
public intColl5()
{
   intList = new LinkedList<>();
}

// alternate constructor for intColl5, used just in case anyone passes in an integer value, same as default
public intColl5(int i)
{
   intList = new LinkedList<>();
}

//insert method inserts an integer into the linked list
public void insert(int i)
{
    intList.add(i); //take integer value and insert into list
}

// method to omit an integer from the list
public void omit(int i)
{
    intList.remove(new Integer(i));
}


//this method prints the contest of the linked list
public void print()
{
   ListIterator listIter = intList.listIterator();  //create new list iterator
   
   while (listIter.hasNext()) //while the list iterator has another value to read
   {
       System.out.println(" " + listIter.next()); //print next integer
   }
}


//this method uses the .size method of LinkedList to get how many elements are in the list
public int get_howMany()
{
    int howMany = intList.size();
    return howMany;
}

//this method uses list iterator to see if an integer belongs in the list
public boolean belongs(int i)
{
    return intList.contains(new Integer (i));
}

//this method copies the list into another list
public void copy(intColl5 obj)
{  
    this.intList.clear();
    ListIterator listIter = obj.intList.listIterator(); //new list iterator

    if(obj != this)
    {
      while(listIter.hasNext())
      {
        int n = (int) listIter.next();
        intList.add(n);
      }
    }
 }

//this method scans each list and gives back a boolean true if each list is equal
public boolean equals(intColl5 obj)
{
   
    return (this != obj) && intList.equals(obj.intList);
    
}

}