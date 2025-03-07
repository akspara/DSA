package org.algorithms.Searching.LinearSearch;

import java.util.ArrayList;
import java.util.Arrays;

/*
Find MEX for each element of the array
The MEX of an array is the minimum value that does not exist in that array from
the start of the array to the present index when iterating through the array.

Example= 0 8 7 1 1 4 3 7 0 2
Output = 1 1 1 2 2 2 2 2 2 5

at 0 the minimum value is 1 since 0 exists in array, till index 3 it will be same, now we got 1 so 0,1,8,7
are present in array now the MEX would be 2 and so on
 */

public class FindMEX {
    static boolean[] foundedElement=new boolean[20];

    public static void main(String[] args)
    {
//        Scanner s = new Scanner(System.in);
//        int arraySize = Integer.parseInt(s.nextLine());
//        String[] array = s.nextLine().split(" ");
//        ArrayList<Integer> problem= new ArrayList<Integer>(arraySize);
//        for(String number:array)
//        {
//            problem.add(Integer.parseInt(number));
//        }
        ArrayList<Integer> problem= new ArrayList<Integer>(Arrays.asList(0,8,7 ,1 ,1 ,4 ,3 ,7 ,0 ,2));
        findMEX(problem);
    }

    private static void findMEX(ArrayList<Integer> problem) {
        int MEX=0;
        int currentFound=0;
        for (int i = 0; i < problem.size(); i++) {
            currentFound= problem.get(i);
            foundedElement[currentFound]=true;
            if(MEX==currentFound)
            {
              MEX=findUnvisitedSmallestValue(MEX);
            }
                System.out.print(MEX+" ");

        }
    }

    static int findUnvisitedSmallestValue(int startIndex) {
        for (int j =startIndex ; j < foundedElement.length ; j++) {
            if(!foundedElement[j])
            {
                return j;
            }
        }
        return 0;
    }

}
