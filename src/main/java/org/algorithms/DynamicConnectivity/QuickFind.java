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

public class QuickFind {

    int[] connects;
    public QuickFind(int n)
    {
        //constructor to initialize connects
        connects=new int[n];
        for (int i = 0; i < n; i++) {
            connects[i]=i;
        }
    }

    public void Union(int first,int second)
    {
        // connect first with second
        int temporary= connects[second];
        connects[second]=connects[first];
        for(int i=0;i<connects.length;i++)
        {
            if(connects[i]==temporary)
            {
                connects[i]=connects[first];
            }
        }
    }

    public boolean find(int a, int b)
    {
        //is a connected to b
        return connects[a]==connects[b];
    }

    public void displayArray()
    {
        for (int connect : connects) {
            System.out.print(connect + " ");
        }
    }

    public static void main(String[] args) {

        QuickFind quickFind=new QuickFind(10);
        quickFind.Union(0,5);
        quickFind.Union(1,2);
        quickFind.Union(3,8);
        quickFind.Union(5,6);
        quickFind.Union(2,7);
        quickFind.Union(3,4);
        quickFind.Union(4,9);
        System.out.println(quickFind.find(8,9));
        System.out.println(quickFind.find(1,7));
        System.out.println(quickFind.find(8,1));
        System.out.println(quickFind.find(5,6));
        quickFind.displayArray();
        /*
    initialize complexity -N
    Union complexity - N
    Find complexity - 1

    Union is too expensive. It takes N^2 array accesses to process a sequence of
    N union commands on N objects.

    Quick Union is a better approach
     */
    }

}
