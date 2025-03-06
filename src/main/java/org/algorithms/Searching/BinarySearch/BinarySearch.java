package org.algorithms.Searching.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {

    public String getInteger(int n,ArrayList<Integer> sortedArray)
    {
        int low=0;
        int high=sortedArray.size();
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(sortedArray.get(mid)==n)
            {
                return "Element found at index:"+mid;
            }
           else if( n<sortedArray.get(mid))
            {
                high=mid-1;
            }
           else
            {
                low=mid+1;
            }
        }
        return "Not Found";
    }
    //sorted array
    public static void main(String[] args)
    {
        ArrayList<Integer> sortedArray=new ArrayList<>(Arrays.asList(1,2,4,8,12,14,19,24,29,35,39,45,51,62,63,71,79));
        BinarySearch b=new BinarySearch();
        System.out.println(b.getInteger(4,sortedArray));
        System.out.println(b.getInteger(46,sortedArray));
        System.out.println(b.getInteger(63,sortedArray));

    }
}
