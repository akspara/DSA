package org.algorithms.Searching.BinarySearch;

/*
Given a sorted and rotated array arr[] of n distinct elements, the task is to find the index of given key in the array. If the key is not present in the array, return -1.

Examples:

Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3
Output: 8
Explanation: 3 is present at index 8 in arr[].


Input: arr[] = [3, 5, 1, 2], key = 6
Output: -1
Explanation: 6 is not present in arr[].


Input: arr[] = [33, 42, 72, 99], key = 42
Output: 1
Explanation: 42 is found at index 1.

Complexity less than n
 */

import java.util.ArrayList;
import java.util.Arrays;

public class RotatedSortedSearch {

    public static void main(String[] args)
    {
        ArrayList<Integer> array=new ArrayList<>(Arrays.asList(28,30,45,60,67,69,5,7,8,10,20,23));
        RotatedSortedSearch minimum=new RotatedSortedSearch();
        System.out.println("key element is found at index "+minimum.find(array,10));

    }

    private Integer find(ArrayList<Integer> array,int key) {
        int low=0;
        int high=array.size()-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(array.get(mid)==key)
                return mid;
            if(array.get(mid)<=array.get(high))
            {
                //right side is sorted
                //check where the key lies
                if(key>array.get(mid) && key<=array.get(high))
                {
                    //key is present in right side;
                    low=mid+1;
                }
                else
                    high=mid-1;

            }
            else
            {
                //left side is sorted
                if(key>=array.get(low) && key<array.get(mid))
                {
                    //key is present in right side;
                    high=mid-1;
                }
                else
                    low=mid+1;

            }

        }
        return -1;
    }
}
