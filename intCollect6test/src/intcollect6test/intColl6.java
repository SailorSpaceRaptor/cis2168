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
            p.info = prev.info; //p.info = prev.info
        }
        else if (p.right != null ^ p.left != null) //case 2 node with only one subtree
        {
            if (p.right != null) 
            { p.right = prev.right;}
            else
            { p.left = prev.left;}
            
         p.info = prev.info;   
            
        }
        else //third case, root node
        {   
            btNode old = p; //remove largest node from left subtree
            p.info = traverse(p.left);
            p.left = old.left;
            p.right = old.right;
            
        }
    }
}

//this method prints the members of the tree in descending order
public void print()
{
  
   printTree(c);
   
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
 /*  public static btNode copytree(btNode t) 
   { 
      btNode root=null;
      if (t!=null)
      {
         root=new btNode();
         root.setinfo(t.getinfo()); 
         root.setleft(copytree(t.getleft()));
         root.setright(copytree(t.getright()));
      }
      return root;
   }
*/

//this method uses an inorder traverse to put a binary tree into an array for use in comparisons (i.e equals())
   public static int toarray(btNode t, int[] a, int i)
   {
      int num_nodes=0;
      if (t!=null)
      {
         num_nodes=toarray(t.left, a, i);
         a[num_nodes+i]=t.info;   
         num_nodes=num_nodes+1+toarray(t.right, a, num_nodes+i+1);
      }
      return num_nodes;
   } 

   //a method to be used with omit, it traverses the left subtree and returns its largest value
   private int traverse(btNode t)
   {
       int large = 0;
       while(t.left != null) //preorder traverse through left subtree
       {
        large = t.info;
        int i = traverse(t.left);
        int j = traverse(t.right);
        
        if(i > j)
            i = large;
        else
            j = large;
       }
        return large;
   }
   
//this method tells us how many objects are in the list
   public int get_howMany()
   {
       return howMany;
   }
}
