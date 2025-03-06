package org.algorithms.Searching.BinarySearch;

/*
Given a sorted array of distinct elements arr[] of size n that is rotated at some unknown point, the task is to find the minimum element in it.

Examples:

Input: arr[] = [5, 6, 1, 2, 3, 4]
Output: 1
Explanation: 1 is the minimum element present in the array.


Input: arr[] = [3, 1, 2]
Output: 1
Explanation: 1 is the minimum element present in the array.


Input: arr[] = [4, 2, 3]
Output: 2
Explanation: 2 is the only minimum element in the array.

less than n complexity
 */

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumInSorted {
    public Integer findMinimum(ArrayList<Integer> array)
    {
        int low=0;
        int high=array.size()-1;
        while(low<high)
        {
            if(array.get(low) < array.get(high))
                return array.get(low);
            int mid=(low+high)/2;
            if(array.get(mid)<=array.get(high))
            {
                high=mid;
            }
            else
                low=mid+1;
        }
        return array.get(low);
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> array=new ArrayList<>(Arrays.asList(28,30,45,60,67,69,5,7,8,10,20,23));
        MinimumInSorted minimum=new MinimumInSorted();
        System.out.println("minimum element="+minimum.findMinimum(array));

    }
}
