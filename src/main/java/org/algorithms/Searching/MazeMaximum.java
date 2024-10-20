package org.algorithms.Searching;

import java.util.*;

/*
You are given a 2-D matrix of size N*M, its elements are integers. We will assume that
the rows of the matrix are numbered from top to bottom from 1 to N, the columns are
numbered from left to right from 1 to M to
Find the maximum possible value X, such that:
There exists at least one row AND one column where all the value of all the elements >=X
 */

public class MazeMaximum {


    public static void main(String[] args) throws Exception {
        //Input logic
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        String[] sides=name.split(" ");
        int N=Integer.parseInt(sides[0]);
        int M=Integer.parseInt(sides[1]);
        Integer[][] arr= new Integer[N][M];
        for(int i = 0; i<N; i++)
        {
            String columnCheck = s.nextLine();
            String[] columns= columnCheck.split(" ");
            for (int j=0;j<columns.length;j++)
            {
                arr[i][j]=Integer.parseInt(columns[j]);
            }
        }
        //Integer[][] arr= {{2,1,3},{4,2,4},{9,9,6}};
        Integer maxRow=-1;

        for(int i=0;i<N;i++)
        {
            Integer minRowI=0;
            for (int j=0;j< M;j++)
            {
                if(j!=0)
                {
                    minRowI=Math.min(arr[i][j],minRowI);
                }
                else
                {
                    minRowI=arr[i][j];

                }
            }
            if(i!=0)
            {
                maxRow=Math.max(maxRow,minRowI);
            }
            else
            {
                maxRow=minRowI;
            }
        }
        Integer maxCol=-1;
        for(int j=0;j<M;j++)
        {
            Integer minColJ=0;
            for (int i=0;i< N;i++)
            {
                if(i!=0)
                {
                    minColJ=Math.min(arr[i][j],minColJ);
                }
                else
                {
                    minColJ=arr[i][j];

                }
            }
            if(j!=0)
            {
                maxCol=Math.max(maxCol,minColJ);
            }
            else
            {
                maxCol=minColJ;
            }
        }
        System.out.println(Math.min(maxRow,maxCol));

    }
    }

