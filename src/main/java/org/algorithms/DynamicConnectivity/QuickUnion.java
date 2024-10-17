package org.algorithms.DynamicConnectivity;

/*
Problem Statement
Given a set of N objects.
・Union command: connect two objects.
・Find/connected query: is there a path connecting the two objects?

Goal. Design efficient data structure for union-find.
・Number of objects N can be huge.
・Number of operations M can be huge.
・Find queries and union commands may be intermixed
 */

//Quick Union with weighted approach and path compression
public class QuickUnion {
    int[] connects;
    int[] size; //will check the depth of each connect
    public QuickUnion(int n)
    {
        //constructor to initialize connects
        connects=new int[n];
        size=new int[n];
        for (int i = 0; i < n; i++) {
            connects[i]=i;
            size[i]=0;  //since nothing is connected the depth is 0
        }
    }

    private int rootCheck(int a)
    {
        //chase parent pointers until reach root
        while(a!=connects[a])
        {
            /*
           connects[a]=connects[connects[a]]; is an improvement
           Just after computing the root of a,set the id of each examined node to point to that root.
           Height tree will decrease further and find method will take less time to find root.
             */
            connects[a]=connects[connects[a]];
           a=connects[a];
        }
        return a;
    }

    public void Union(int child,int parent)
    {
        //change root of child to point to root of parent
        int parentRoot=rootCheck(parent);
        int childRoot=rootCheck(child);
        if(parentRoot==childRoot)
            return;

        /*
        WIGHTED DISTRIBUTION
        we have added weighted distribution where parent will always be the larger tree to help reduce the height of the tree
        and hence it will decrease the time taken to find root.
        By doing that Depth of any node x is at most lg N.
         */
        if(size[parentRoot]>size[childRoot])
        {
            connects[childRoot]=parentRoot;
            size[parentRoot]+=size[childRoot];
        }
        else {
            connects[parentRoot] = childRoot;
            size[childRoot]+=size[parentRoot];
        }

    }
    public boolean find(int a, int b)
    {
        //check if a and b have same root
        return  rootCheck(a)==rootCheck(b);
    }

    public void displayArray()
    {
        for (int connect : connects) {
            System.out.print(connect + " ");
        }
    }

    public static void main(String[] args) {

        QuickUnion quickUnion =new QuickUnion(10);
        quickUnion.Union(0,5);
        quickUnion.Union(1,2);
        quickUnion.Union(3,8);
        quickUnion.Union(5,6);
        quickUnion.Union(2,7);
        quickUnion.Union(3,4);
        quickUnion.Union(4,9);
        System.out.println(quickUnion.find(8,9));
        System.out.println(quickUnion.find(1,7));
        System.out.println(quickUnion.find(8,1));
        System.out.println(quickUnion.find(5,6));
        quickUnion.displayArray();
        /*
    initialize complexity -N
    Union complexity - lg N (includes cost of finding roots) by using the improved mechanism and not increasing tree height
    Find complexity - lg N

    worst complexity -N + M lg* N
    best approach
     */
    }
}
