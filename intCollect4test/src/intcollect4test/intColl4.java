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
public class intColl4 
{
private ListNode c;
private int howMany;
 
public intColl4()//default constructor
        {
            c = null;
            howMany = 0;
        }

public intColl4(int i) //alternate constructor same as the default constructor
       {
           c = null;
           howMany = 0;
       }

// The inner class for ListNode     
private class ListNode
      {
           private int info;
           private ListNode link;

           public ListNode()
           {
               info=0; link=null;
           }
     }  
//belongs method takes in an integer and checks to see if it belongs in the linked list giving a boolean true if it does
public boolean belongs(int i)
{
    ListNode p = c;
    while(p != null && p.info != i)
            {
                p = p.link;
            }
    return (p != null);
}


//insert method takes an integer i and first checks to see if integer i belongs in the list, if not, then it creates a new list node object and link to identify the integer in the collection
public void insert (int i)
{
    ListNode p = c; //create list node
       while((p != null) && (p.info != i)) //if p is not null/empty and i is not already in the list
       {
        p = p.link; //link info
       }
       if (p == null) //if p is not in the list
       {
           howMany ++; //howMany increments
           p = new ListNode(); //p is new listNode object
           p.info = i; //p.info is now integer being passed in
           p.link = c; //link to position is now c
           c = p; //c is now equal to p
       }
}


/*
omit method takes in an integer i, checks to see if it belongs in a list, then if it is in the list it removes the object from the list. It then changes the pointer
to point to the next object in the list.
*/
public void omit(int i)
{
    ListNode prevs = null; //previous pointer equals null
    ListNode curnt = c; //current pointer equal to c
    
    while (( curnt != null) && (curnt.info != i)) // while current integer exists within the linked list
    {
        prevs  = curnt;//replace item with previous
        curnt = curnt.link; //update list call
    }
    
    if(curnt != null)
    {
      if (prevs == null) //if integer is at the beginning of the list 
      {
        c = curnt.link; //c is now equal to the current pointer
      }
      else
      {
        prevs.link = curnt.link; //previous link is now current link
      }
     howMany --; //decrement
    }
   
}



//the copy method takes a linked list object and deep copies the contents into a new linked list object
public void copy(intColl4 obj)
{
    
   if (this != obj)   //check for equality
      {
          ListNode p = obj.c; //create new object for current pointer
          howMany = obj.get_howmany();
          ListNode prev = null; //create prev pointer to keep track
          while (p != null)
          {
              ListNode n = new ListNode();//move current along and use prev to copy
              n.info = p.info;
              if(prev != null) //if previous pointer is not null
              {
                  prev.link = n;
              }
              else //else create new pointer to start
              {
                  c = n;
              }
              p = p.link; //current pointer is now linked
              prev = n; //prev pointer is now n
          }
          
         
   }
            
}




//the equals method compares two linked list objects and checks for equality giving a boolean true if they are
public boolean equals(intColl4 obj)
{
ListNode p = c; //current pointer for list node
    boolean equal = (howMany == obj.get_howmany());
    while(p != null && equal)
    {
        if(!obj.belongs(p.info))
        {
            equal = false;
        }
    else
        {
            p = p.link;
        }
    }
return equal;
}



//print method prints the contents of the linked list objects
public void print()
{
    ListNode p = c; 
    while(p != null) //while p exists
         {
          System.out.println(p.info); //print p info
          p = p.link; //set up the location for the next list member
         }
}

//get_howMany gets the amount of objects in a linked list and returns an integer value
   public int get_howmany()
   {
      	return howMany; //return how many as an integer
   }

}
