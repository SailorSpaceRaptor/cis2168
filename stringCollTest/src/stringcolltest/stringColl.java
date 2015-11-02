
package stringcolltest;

/**
 *
 * @author Jonathan
 * created for CIS 2168 this application uses the previous binary tree that we created in intColl6 and turns it into a tree for Strings instead of integers
 */
public class stringColl 
{

    //private btNode method creates new btNode to be used
   private btNode c;
   private int howMany;

    private static class btNode {

        String info;
        btNode left, right;

        private btNode(String s) {
            info = s;
            left = null;
            right = null;
        }

        private btNode(String s, btNode l, btNode r) {
            info = s;
            left = l;
            right = r;
        }
    }

//constructors for intCollect6
    public stringColl() {
        c = null;
        howMany = 0;

    }

    //alternate constructor, input size of container
    public stringColl(int i) {
        c = null;
        howMany = 0;
    }
    /*This method recieves an input and places it into the binary tree 
     */

    public void insert(String s) {
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
        if (p == null) {
            howMany++;
            p = new btNode(s);
            if (prev == null) {
                c = p;
            } else if (prev.info.compareTo(s) > 0) {
                prev.left = p;
            } else {
                prev.right = p;
            }
        }

    }

//this method omits a member from the binary tree
    public void omit(String s) {
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
        if (p != null) {
            howMany--;
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

//this method prints the members of the tree in descending order
    public void print() {
        printTree(c);
    }

//This method copies one object into another
    public void copy(stringColl obj) {
        if (obj != this) {
            c = copyTree(obj.c);
            howMany = obj.get_howMany();
        }

    }

//this method traverses the binary tree and returns a true if the number in question is in the collection
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

//this method tests equality between two binary trees and returns a boolean true if equal
    public boolean equals(stringColl obj) {
        boolean isEqual = true;

        String[] d = new String[howMany];
        String[] b = new String[howMany];
        int point_1, point_2;

        if (this.howMany == obj.howMany)//check to see if each has the same number of objects
        {
            d = new String[this.howMany];//create two arrays from lists
            b = new String[obj.howMany];
            point_1 = toArray(obj.c, b, 0);
            point_2 = toArray(c, d, 0);
        }

        for (int i = 0; (i < d.length && i < b.length); i++)//compare objects in array
        {
            isEqual = (b[i] == d[i]);
        }

        return isEqual;

    }

//private method uses an inorder traverse to print the members of the binary tree, is then called by the print method
    private static void printTree(btNode t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.info);
            printTree(t.right);
        }
    }

//this method uses a post order traverse to copy a tree to be used in other methods
    private static btNode copyTree(btNode t) {
        btNode rt = null;
        btNode L = null;
        btNode R = null;

        if (t != null) {
            L = copyTree(t.left);
            R = copyTree(t.right);
            rt = new btNode(t.info, L, R);
        }
        return rt;

    }

//this method uses an inorder traverse to put a binary tree into an array for use in comparisons (i.e equals())
    private static int toArray(btNode t, String[] a, int i) {
        int num_nodes = 0;
        if (t != null) {
            num_nodes = toArray(t.left, a, i);
            a[num_nodes + i] = t.info;
            num_nodes = num_nodes + 1 + toArray(t.right, a, num_nodes + i + 1);
        }
        return num_nodes;
    }

//this method tells us how many objects are in the list
    public int get_howMany() {
        return howMany;
    }
    
}