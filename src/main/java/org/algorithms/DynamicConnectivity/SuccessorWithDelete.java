package org.algorithms.DynamicConnectivity;

import java.util.Arrays;

/*
Successor with delete. Given a set of n integers
S={0,1,...,n−1} and a sequence of requests of the following form:
Remove x from S

Find the successor of x: the smallest y in S such that y≥x.

design a data type so that all operations (except construction)  take logarithmic time or better in the worst case.
 */
public class SuccessorWithDelete {

    int [] S;
    SuccessorWithDelete(int[] arr)
    {
        S=arr;
        Arrays.sort(S);
    }

    public void remove(int a)
    {
        for (int i = 0; i < S.length; i++) {
            if(S[i]==a)
            {
                S[i]=-1;
                return;
            }
        }
    }

    public int successor(int x)
    {  int y=x;
        for (int i = (S.length)-1; i >= 0; i--) {
            if(S[i]==x)
            {
                return y;
            }
            else if(S[i]!=-1)
            {
                y=S[i];
            }
        }
        return y;
    }

    public static void main(String[] args)
    {
        //not the best solution
        int[] arr={1,4,2,54,3,2,53,12,57,78,14};
        //1,-1,2,3,4,-1,14,53,54,-1,78
        SuccessorWithDelete successor=new SuccessorWithDelete(arr);
        successor.remove(2);
        successor.remove(57);
        successor.remove(12);
        System.out.println( successor.successor(54));
        System.out.println( successor.successor(2));
        System.out.println( successor.successor(1));
    }
}
