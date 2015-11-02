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

/*
multiStringcoll copies stringColl to keep track of the number of each individual string. It is structured in a binary search tree and uses the similar methods as
stringColl

*/

public class multiStringcoll
{
    private int total_howMany;
    private btNode c;
   

//default constructor for multiStringcoll is same as stringColl but 

//alternate constructor for multiStringcoll is same as stringColl
    
    public int get_howMany()
    {
       return total_howMany;
    }

    /*this insert method is nearly identical to the stringColl insert but instead of passing over 
    a repeat, it adds it to the collection and keeps track of how many copies of the string is in there
    */
   public void insert(String s)
   {
     btNode p = c;
        btNode prev = null;
        while (p != null&& !(p.info.compareTo(s) == 0) ) //iterator over the tree
        {
            prev = p;
            if (p.info.compareTo(s) > 0) 
            {
                p = p.left;
            } 
             else 
            {
                p = p.right;
            }
        }
        if (p == null) {
            total_howMany++;
            p = new btNode(s);
            if (prev == null) {
                c = p;
            } else if (prev.info.compareTo(s) > 0) {
                prev.left = p;
            } else {
                prev.right = p;
            }
            p.strCount ++; //increment p.strCount
           
        }
        else
            {
                p.strCount++; //increment p.strCount
            }
        
    }

   
    // This omit method is identical to stringColl.omit, but if it incounters a repeat string it only omits the repeat
    // and decrements its individual count
   
public void omit(String s)
{
    btNode p = c;
    btNode prev = null;
     while (p != null && !(p.info.compareTo(s) == 0)) {
            prev = p;
            if (p.info.compareTo(s) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
   if (p != null)
     {
        if (p.strCount > 1)
      {
        p.strCount --;
     }
     else
     {
         if (p != null) {
            total_howMany--;
            if (p.right == null && p.left == null) //case 1 leaf node
            {
                if (prev.info.compareTo(p.info) > 0) {
                    prev.left = null;
                } else {
                    prev.right = null;
                }
            } else if (p.right != null && p.left == null) //case 2 node with only one subtree
            {
                if (prev.info.compareTo(p.info) > 0) {
                    prev.right = p.right;
                } else {
                    prev.left = p.right;
                }

            } else if (p.right == null && p.left != null) {
                if (prev.info.compareTo(p.info) > 0) {
                    prev.right = p.left;
                } else {
                    prev.left = p.left;
                }
            } else //third case, root node
            {
                btNode old = p; //saves old node to be overwritten
                btNode oldPrev = prev;
                prev = p;

                p = p.left;

                while (p.right != null) //searches tree to find the new root
                {
                    prev = p;
                    p = p.right; //largest member of left subtree will come out of this loop
                }

                if (p == old.left) {
                    prev.left = p.left;
                } else {
                    prev.right = p.left;
                }
                p.left = old.left;
                p.right = old.right;

                if (oldPrev != null) {
                    oldPrev.left = p;
                } else {
                    c = p;
                }
            }
        }
     }
      }
  }//end omit


//this print method is the same as stringColl
public void print()
{
    printTree(c);
}


//this equals method 
public boolean equals(multiStringcoll obj)
{
    boolean isEqual = true;

        String[] d = new String[total_howMany];
        String[] b = new String[total_howMany];
        int[] e = new int[total_howMany];
        int[] f = new int[total_howMany];
        //int point_1, point_2;

        if (this.total_howMany == obj.total_howMany)//check to see if each has the same number of objects
        {
            d = new String[this.total_howMany];//create two arrays from lists
            b = new String[obj.total_howMany];
            e = new int[obj.total_howMany]; //creates two more arrays for the how manys
            f = new int[obj.total_howMany];
            toArray(obj.c, b, 0);
            toArray(c, d, 0);
            toArray2(obj.c, e, 0);
            toArray2(c,f,0);
       
        }

        //this for loop checks all arrays against each other to check for equality
         for (int i = 0; i < d.length && i < b.length; i++)
       {
        for(int j = 0; j < e.length && i < f.length; i++)   
        {
            isEqual = (b[i].equals(d[i])) && (e[j] == f[j]) ;
        }
       }//end nested for
         

        return isEqual; 
    
}
 

//copy method is the same as in stringColl 
    public void copy(multiStringcoll obj) {
        if (obj != this) {
            c = copyTree(obj.c);
            total_howMany = obj.get_howMany();
            
        }
    }
    
    
//belongs method checks to see if a string belongs in the collection
        
public int belongs(String s) {
        btNode p = c; //points to root

        while (p != null && !p.info.equals(s)) {
            if (p.info.compareTo(s) < 0) //traverses through, if int is less than p goes to the left sub tree
            {
                p = p.left;
            } else //if int is greater than p goes to right subtree
            {
                p = p.right;
            }
        }
        return (p != null) ? 0:1;
    }
    

/***************************************************************************************************************************************************************************************
 * Private methods
***************************************************************************************************************************************************************************************/
 
//this subclass creates a node for the binary tree and is identical to other btNodes in previous assignments except it has the additional value of strCount
private static class btNode 
 {

        String info;
        btNode left, right;
        int strCount; //this value counts how many times the string shows up in the tree

        private btNode(String s) 
        {
            info = s;
            left = null;
            right = null;
            strCount = 0;
        }

        private btNode(String s, btNode l, btNode r, int strCount) {
            info = s;
            left = l;
            right = r;
            strCount = 0;
        }
    }

     private static void printTree(btNode t) 
     {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.info + " - " + t.strCount);
            printTree(t.right);
        }
    }

     //this method uses a post order traverse to copy a tree to be used in other methods, in this version there is also the added parameter for strCount
    private static btNode copyTree(btNode t) 
    {
        btNode rt = null;
        btNode L = null;
        btNode R = null;
        
        

        if (t != null) 
        {
            L = copyTree(t.left);
            R = copyTree(t.right);
            rt = new btNode(t.info, L, R, t.strCount);
            rt.strCount = t.strCount;
        }
        return rt;

    }
    
    //this method uses an inorder traverse to put a binary tree into an array for use in comparisons (i.e equals())
     private static int toArray(btNode t, String[] a, int i) 
    {
        int num_nodes = 0;
        if (t != null) {
            num_nodes = toArray(t.left, a, i);
            a[num_nodes + i] = t.info;
            num_nodes = num_nodes + 1 + toArray(t.right, a, num_nodes + i + 1);
        }
        return num_nodes;
    }

    private static int toArray2(btNode t, int[] a, int i) {
        int num_nodes = 0;
        if (t != null) {
            num_nodes = toArray2(t.left, a, i);
            a[num_nodes + i] = t.strCount;
            num_nodes = num_nodes + 1 + toArray2(t.right, a, num_nodes + i + 1);
        }
        return num_nodes;
    }
}