/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcoll1test;



/*
this is a public class Intcoll1 (short for intcollect), it is meant to take in integers > 0 and place them in an array
and do operations on said array
*/
public class intColl1 
{
   private int[] c; //private array c to be used as storage for integers

   public intColl1()
   {
      	c = new int[500+1]; //array c is 500 + 1 in size
      	c[0] = 0;
   }

   public intColl1(int i) //constructor for intcoll1
   {
      	c = new int[i+1];
    	c[0] = 0;
   }

   /*
   copy method takes an intcollect object and copies it to another intcollect object
   */
   public void copy(intColl1 obj)
   {
      	if (this != obj) //if the two objects are not identical
      	{
		c = new int[obj.c.length]; //create new array that is of equal size to the other object
		int j = 0;
		while (obj.c[j] != 0) //copy each number that is not a zero
		{
			c[j] = obj.c[j]; j++;
		}
		c[j] = 0;
	}
   }

   /*
   belongs method inputs a parameter, int i, and checks the array to see if the integer is in the array
   */
   public boolean belongs(int i)
   {
      	int j = 0;
      	while ((c[j] != 0)&&(c[j] != i)) j++; //while integer is not equal to zero, scan array for a match
      	return ((i>0)&&(c[j] == i)); 
   }

   /*
   insert method takes a parameter int i, checks to see if integer is not in the array, then if it isn't, it inserts it into the array. 
   If there is no more space in the array, then insert creates a new array that is double the size of the previous array and inserts parameter i
   */
   
   public void insert(int i)
   {
      	if (i > 0)
	{
	 	int j = 0;
	     	while ((c[j] != 0) && (c[j] != i)) j++; //scan the array while int is not 0 nor already in the array
		if (c[j] == 0) //if you get to the end of the array
	     	{
			if (j == c.length - 1) //if j is equal to the length of array c minus one
		   	{
                         int[] d;  //create new array d that is twice the size of c
                         d = new int[2*c.length];
                         //d[] = 0;
                         for(int k = 0; k < c.length; k++)
                         {
                             d[k] = c[k];//deep copy contents of c to d
                         }
		   	c = d;
                        }
		   	c[j] = i; c[j + 1] = 0; //the final spot in the array is now int i, the next number in the array is zero
		}
	}
   }

   /*
   omit method take in a parameter int i, checks array c, and if int i is already a member of array c, then it removes it from the array
   */
   
   public void omit(int i)
   {
	if (i>0) //if i is greater than zero
	{
      		int j = 0;
      		while ((c[j] != 0)&&(c[j] != i)) j++; //scans the array while in is neither zero nor in the array
      		if (c[j] == i) //if int i is in the array
      		{
         		int k = j+1; //int k is equal to j + 1 in the array
         		while (c[k] != 0) k++; //while k is not zero, increase k
         		c[j] = c[k-1]; c[k-1]=0; //place whichever number was at the bottom of the list and place it where int i was omitted
      		}
	}
   }
/*
   get method to recieve the number of integers in the collection
   */
   public int get_howmany()
   {
      	int j=0, howmany=0; //initial conditions, j is zero, howmany is zero

      	while (c[j]!=0) {howmany++; j++;} //count every number in collection that is not zero
      	return howmany; //return how many as an integer
   }

   /*
   print method prints the collection of the object list
   */
   public void print()
   {
      	int j = 0;
      	System.out.println();
      	while (c[j] != 0) //print every member of c that is not 0
      	{
         	System.out.println(c[j]); j++;
      	}
   }

   /*
   equals method reads two objects of intcollect and compares the integers in each collection, if the collections are identical, then it
   returns a boolean true
   */
   public boolean equals(intColl1 obj)
   {
      	int j = 0; boolean result = true;
      	while ((c[j] != 0)&&result)
      	{
         	result = obj.belongs(c[j]); j++;
      	}
      	j = 0;
      	while ((obj.c[j] != 0)&&result)
      	{
         	result = belongs(obj.c[j]); j++;
      	}
      	return result;
   }
}
