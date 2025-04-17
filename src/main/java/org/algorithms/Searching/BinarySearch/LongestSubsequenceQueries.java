package org.algorithms.Searching.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

/*
To find the longest subsequence with sum below any given number,
we can sort the given array in ascending order and keep taking the elements till the sum is less than k.
 For answering multiple queries, we can precompute the prefix sum and do binary search over it.




 Didn't complete on my own
 */
public class LongestSubsequenceQueries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            Arrays.sort(a);

            long[] sum = new long[n];
            sum[0] = a[0];
            for (int i = 1; i < n; i++) {
                sum[i] = sum[i - 1] + a[i];
            }

            while (q-- > 0) {
                long k = sc.nextLong();
                int pos = lowerBound(sum, k);
                System.out.println(pos);
            }
        }

        sc.close();
    }

    // Custom lower_bound implementation
    public static int lowerBound(long[] arr, long key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
