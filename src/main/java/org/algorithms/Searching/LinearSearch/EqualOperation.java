package org.algorithms.Searching.LinearSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
you have an array of numbers a[], each step you can do one operation in a[i] to split them into X and Y where X+Y= a[i].
print the minimum number of operations required to make all integers of the array equal.

example=[2,2,4]
Test case 1: Choose i = 2 and split A[2] = 4 into X = 2, Y = 2 making A = [2,2,2]. Now all elements of the array are equal.

Test case 2:
[1,2,3]
Choose i = 2 and split A[2] = 2 into X = 1, Y = 1 making A = [1, 3, 1, 1].
Choose i = 2 and split A[2] = 3 into X = 2, Y = 1 making A = [1, 1, 1, 2, 1].
Choose i = 4 and split A[4] = 2 into X = 1, Y = 1 making A = [1, 1, 1, 1, 1, 1]. Now all elements of the array are equal.
 */
public class EqualOperation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());;
        for (int t = 0; t < testCases; t++) {
            int n= Integer.parseInt(br.readLine());
            String[] array= br.readLine().split(" ");
            System.out.println(equalOperation(array,n));
        }

    }

    private static long equalOperation(String[] array,int n) {
        int min=0;
        long summ=0;
        for (int i = 0; i <n ; i++) {
            if(i==0)
                min= Integer.parseInt(array[i]);
            else
            {
                min=Math.min(min,gcd(min, Integer.parseInt(array[i])));
            }
        }
        //now we found the HCF which will be the minimum value we can break all the string to.

        for (String s : array) {
            //we see that it takes us this many steps to split the number into minimum val.
            summ += (long) (Integer.parseInt(s) - min) / min;
        }
        return summ;
    }

    private static int gcd(int first, int second) {
        if(first==0)
            return second;
        if(first>second)
           return gcd(first%second,second);
        else
            return gcd(second%first,first);
    }

}
