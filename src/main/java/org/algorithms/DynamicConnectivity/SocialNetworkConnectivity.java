package org.algorithms.DynamicConnectivity;

/*
Given a social network containing
n members and a log file containing
m timestamps at which times pairs of members formed friendships, design an algorithm to
determine the earliest time at which all members are connected (i.e., every member is a friend of a
friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that
friendship is an equivalence relation. The running time of your algorithm should be
mlogn or better and use extra space proportional to n
 */
public class SocialNetworkConnectivity {

    int[] connects;
    int[] root; //will store the root of each row

    public SocialNetworkConnectivity(int n)
    {
        //constructor to initialize connects
        connects=new int[n];
        root=new int[n];
        for (int i = 0; i < n; i++) {
            connects[i]=i;
            root[i]=i;  //each root is same
        }
    }

    private  boolean setRootOfAll(int finalVal,int changeVal)
    {
        //used to check if roots of all elements are same or not
        //will also set the roots of all elements on change
        int value=-1;
        boolean flag=true;
        for (int i = 1; i <root.length ; i++) {
            if(root[i]==changeVal)
            {
                root[i]=finalVal;
            }
            if(value==-1)
            {
                value=root[i];
            }
            else if(root[i]!=value)
            {
                flag = false;
            }
        }
        return flag;
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
        int temp=connects[childRoot];
        connects[childRoot]=parentRoot;
        //set all childRoot as parent root.And check at the same time
       if(setRootOfAll(parentRoot,temp))
       {
           System.out.println("All friends are connected");

       }

    }

    public static void main(String[] args) {

        SocialNetworkConnectivity socialNetworkConnectivity =new SocialNetworkConnectivity(10);
        socialNetworkConnectivity.Union(0,5);
        socialNetworkConnectivity.Union(1,2);
        socialNetworkConnectivity.Union(3,8);
        socialNetworkConnectivity.Union(5,6);
        socialNetworkConnectivity.Union(2,7);
        socialNetworkConnectivity.Union(3,4);
        socialNetworkConnectivity.Union(4,9);
        socialNetworkConnectivity.Union(0,9);
        socialNetworkConnectivity.Union(1,3);
        //All are connected here
    }
}
