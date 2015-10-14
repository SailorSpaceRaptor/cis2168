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
public class intColl6 
{
    private btNode c = new btNode(0,null,null);
    private int howMany;
    
    private static class btNode {

        int info;
        btNode left, right;

        private btNode(int i) {
            info = i;
            left = null;
            right = null;
        }

        private btNode(int i, btNode l, btNode r) {
            info = i;
            left = l;
            right = r;
        }
    }

//constructors for intCollect6
public intColl6()
{
   c = null;
   howMany = 0;
    
}

public intColl6(int i)
{
    c = null;
    howMany = 0;
}
/*This method recieves an input and places it into the binary tree 
*/
public void insert(int i)
{
    btNode p = c;
    btNode prev = null;
    while( p != null && p.info != i)
    {
        prev = p;
        if (i < p.info)
            p = p.left;
            
        else
            p = p.right;
    }
    if (p == null)
    {
        howMany ++;
        p = new btNode(i);
        if (prev == null)
        {
            c = p;
        }
        else
            if (i < prev.info)
            {
                prev.left = p;
            }
        else
            {
                prev.right = p;  
            }  
    }

}

//this method omits a member from the binary tree
public void omit(int i)
{
    btNode p = c;
    btNode prev = null;
    while(p != null && p.info != i)
    {
        prev = p;
        if (i < p.info)
            p = p.left;
        else
            p = p.right;
    }
    if (p != null)
    {
        howMany --; 
        if (p.right == null && p.left == null) //case 1 leaf node
        {
          if (p.info < prev.info)
              prev.left = null;
          else
              prev.right = null;
        }
  
      else if (p.right != null ^ p.left != null) //case 2 node with only one subtree
        {
          if(p.info < prev.info)
          {
              prev.left = p.right;
          }   
          else
          {
             prev.right = p.left;
          }
        }
       
      else //third case, root node
        {   
           btNode old = p; //saves old node to be overwritten
 
           prev = p;
  
           while(p.left != null) //searches tree to find the new root
           {
               prev = p;
               p = p.left;
           }
           old.info = p.info;
           prev.right = p.right;
           prev.left = p.left;
        }
    }
}

//this method prints the members of the tree in descending order
public void print()
{
   printTree(c);
}

//This method copies one object into another
public void copy(intColl6 obj)
{   
    if (obj != this)
    {
    c = copyTree(obj.c);
    howMany = obj.get_howMany(); 
    }
    
}

//this method traverses the binary tree and returns a true if the number in question is in the collection
public boolean belongs(int i)
{
    btNode p = c; //points to root
    
    while(p != null && p.info != i)
    {
        if (i < p.info)  //traverses through, if int is less than p goes to the left sub tree
            p = p.left;
        else //if int is greater than p goes to right subtree
            p = p.right;
    }
    return (p != null);
}

//this method tests equality between two binary trees and returns a boolean true if equal
public boolean equals(intColl6 obj)
{
    boolean isEqual = true;

     int[] d = new int [howMany];
     int[] b = new int [howMany];
     int point_1, point_2;
     
    if (this.howMany == obj.howMany)//check to see if each has the same number of objects
    { 
        d = new int[this.howMany];//create two arrays from lists
        b = new int[obj.howMany];
        point_1 = toArray(obj.c, b, 0);
        point_2 = toArray(c, d,0);
    }  

for(int i = 0; (i < d.length && i < b.length); i++)//compare objects in array
      isEqual = (b[i] == d[i]);

return isEqual;
 
}


//private method uses an inorder traverse to print the members of the binary tree, is then called by the print method
private static void printTree(btNode t)
{
    if (t != null)
    {
        printTree(t.left);
        System.out.println(t.info);
        printTree(t.right);
    }
}

//this method uses a post order traverse to copy a tree to be used in other methods
   private static btNode copyTree(btNode t) 
   { 
      btNode rt = null;
      btNode L = null;
      btNode R = null;
      
      if( t != null)
      {
        L = copyTree(t.left);
        R = copyTree(t.right);
        rt = new btNode(t.info,L,R);
      }
      return rt;
      
   }


//this method uses an inorder traverse to put a binary tree into an array for use in comparisons (i.e equals())
   public static int toArray(btNode t, int[] a, int i)
   {
      int num_nodes=0;
      if (t!=null)
      {
         num_nodes=toArray(t.left, a, i);
         a[num_nodes+i]=t.info;   
         num_nodes=num_nodes+1+toArray(t.right, a, num_nodes+i+1);
      }
      return num_nodes;
   } 


//this method tells us how many objects are in the list
   public int get_howMany()
   {
       return howMany;
   }
}
