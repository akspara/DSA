package org.algorithms.Searching.LinearSearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
Task

Determine the employee rating.

Example

Assumptions

N = 12
workload = [2, 3, 7, 8, 7, 6, 3, 8, 12, 11, 12, 10]
Approach

Workload with consecutive hours > 6 = [2, 3, 7, 8, 7, 6, 3, 8, 12, 11, 12, 10] =>  Longest Interval =  [8,12,11,12,10]
 */

public class EmployeeRating {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr_workload = br.readLine().split(" ");
        int[] workload = new int[N];
        for(int i_workload = 0; i_workload < arr_workload.length; i_workload++)
        {
            workload[i_workload] = Integer.parseInt(arr_workload[i_workload]);
        }

        int out_ = solve(N, workload);
        System.out.println(out_);

        wr.close();
        br.close();
    }
    static int solve(int N, int[] workload){
        int result = 0;
        int nextMax=0;
        for(int i=0;i<workload.length;i++)
        {
                if(workload[i]>6)
                {
                    nextMax+=1;
                }
                else
                {
                    result=Math.max(result,nextMax);
                    nextMax=0;
                }
        }
        result=Math.max(result,nextMax);
        return result;
    }
}