package org.algorithms.Searching.LinearSearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
A{} and B{} are two sets, C is a subset where C{a+b |a belongs to set A and b belongs to set B}

you will get A{} and set C{} find set B{} from it.
 */
public class EasySumSet {

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n=Integer.parseInt(s.nextLine());
        String[] A = s.nextLine().split(" ");
        int m=Integer.parseInt(s.nextLine());
        String[] C = s.nextLine().split(" ");

        findSumset(n,A,m,C);
    }

    private static void findSumset(int n, String[] a, int m, String[] c) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Integer diff=Integer.parseInt(c[j])-Integer.parseInt(a[i]);
                if(hashMap.containsKey(diff))
                {
                    hashMap.put(diff, hashMap.get(diff)+1);
                }
                else {
                    hashMap.put(diff, 1);
                }
            }
        }

        hashMap.forEach((key,value)->
        {
            if(value==n)
            {
                System.out.print(key+" ");
            }
        });
    }
}
