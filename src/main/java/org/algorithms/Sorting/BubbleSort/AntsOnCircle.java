package org.algorithms.Sorting.BubbleSort;

import java.util.*;

public class AntsOnCircle {

    /*
    In a country X
, all the ants move in a circle. There is a circle marked with N
 marks with numbers from 1 to N
 clockwise. There are M ants on the circle. No two ants stand on the same mark initially.
 It is also known in which direction each ant will move. If two ants meet during the movement,
  then each of them begins to move in a different direction. Your task is to determine where the ants will be after T seconds of such movement.
  Ants can move only 1 step at a time , clockwise or anticlockwise
     */

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String[] array = s.nextLine().split(" ");
        int N=Integer.parseInt(array[0]);
        int M=Integer.parseInt(array[1]);
        int T=Integer.parseInt(array[2]);
        Integer[] finalPos=new Integer[M];
        for (int i = 0; i < M; i++) {
            String[] array2 = s.nextLine().split(" ");
            int x=Integer.parseInt(array2[0]);
            int y=Integer.parseInt(array2[1]);
            if(y==1)
            {
                x=(x+T%N)%N;
                if (x==0)
                    x=N;
            }
            if(Integer.parseInt(array2[1])==-1)
            {
                x= (N-T%N+x)%N;
                if (x==0)
                    x=N;
            }
            finalPos[i]=x;
        }

        showResult(finalPos,M);
    }

    private static void showResult(Integer[] antsArr, int N) {
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j <N-1-i ; j++) {
                if(antsArr[j]>antsArr[j+1])
                {
                    int temp=antsArr[j];
                    antsArr[j]=antsArr[j+1];
                    antsArr[j+1]=temp;
                }
            }
        }

        for (int i = 0; i < antsArr.length; i++) {
            System.out.print(antsArr[i]+" ");
        }
    }
}
