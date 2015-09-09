/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcoll3test;
import java.util.*;

/**
 *
 * @author Jonathan
 */
public class Intcoll3 
{
   private boolean[] c; //private array c to be used as storage for integers
   int howMany = 0;
   
   public Intcoll3()
   {
      	c = new boolean[500+1]; //array c is 500 + 1 in size
      	  
   }

   /*
   copy method takes an intcollect object and copies it to another intcollect object
   */
   public void copy(Intcoll3 obj)
   {
      	if (this != obj) //if the two objects are not identical
      	{
		c = new boolean[obj.c.length]; //create new array that is of equal size to the other object
		
		for(int j = 0; j < obj.c.length; j++)
                {
                    while (obj.c[j] == true) //copy each number that is not a false
		{
			c[j] = obj.c[j]; j++;
		}
                }
	}
   }

   /*
   belongs method inputs a parameter, int i, and checks the array to see if the integer is in the array
   */
   public boolean belongs(int i)
   {
      	return ((i<c.length) && (c[i])); 
   }

   /*
   insert method takes a parameter int i, checks to see if integer is not in the array, then if it isn't, it inserts it into the array. 
   If there is no more space in the array, then insert creates a new array that is double the size of the previous array and inserts parameter i
   */
   
   public void insert(int i)
    {
      	if (i > 0)
	{
	 	if (i >= c.length) //if i is greater than length of c
                {
                    boolean[] d; //create new boolean array twice as large as c
                    d = new boolean [i*2]; 
                    for(int k = 0; k < c.length; k++) 
                    {
                        d[k] = c[k]; //deep copy
                    }
                    d[i] = true;
                    c = d;
                }
                    c[i] = true;
                    howMany ++;
	}
   }

   /*
   omit method take in a parameter int i, checks array c, and if int i is already a member of array c, then it removes it from the array and decrements howMany
   */
   
   public void omit(int i)
   {
	if (i>0) //if i is greater than zero
	{
      		int j = 0;
      		while ((c[j] == true)) j++; //scans the array to check for truth
      		if (c[i] == true) //if int i is in the array
      		{
         		int k = j+1; //int k is equal to j + 1 in the array
         		while (c[k] == true) k++; //while k is true, increase k
         		c[i] = false; //change i to false 
                        howMany-- ;
                }
	}
   }
/*
   get method to recieve the number of integers in the collection
   */
   public int get_howmany()
   {
      	return howMany; //return how many as an integer
   }

   /*
   print method prints the collection of the object list
   */
   public void print()
   {
      	
      	for(int j = 0; j < c.length; j++) //print every member of c that is true
      	{
            if(c[j] == true)
            {
                System.out.println(j);
            }
      	}
   }

   /*
   equals method reads two objects of intcollect and compares the integers in each collection, if the collections are identical, then it
   returns a boolean true
   */
    public boolean equals(Intcoll3 obj) 
    {
        //int j = 0;
        boolean result = (obj.get_howmany() == howMany);
        
        for(int j = 0; j < c.length; j++)
        {  
            result = (obj.belongs(j) == c[j]);
        }
        return result;
    }
}