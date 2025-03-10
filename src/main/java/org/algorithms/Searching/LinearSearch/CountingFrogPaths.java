package org.algorithms.Searching.LinearSearch;

import java.util.Scanner;

/*
There is a frog initially placed at the origin of the coordinate plane. In exactly t
 second, the frog can either move up 1
 unit, move right 1 unit, or stay still. In other words, from position
(x.y), the frog can spend 1 second to move to:
-(x+1,y)
-(x,y+1)
-(x,y)

After t seconds, a villager who sees the frog reports that the frog lies on or inside a square of side-length
 with coordinates
(x+s,y),
(x,y+s),
(x,y),(x+s,y+s)
85 19 51 186
. Calculate how many points with integer coordinates on or inside this square could be the frog's position after exactly
 seconds

 */
public class CountingFrogPaths {

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String[] array = s.nextLine().split(" ");
        int X=Integer.parseInt(array[0]);
        int Y=Integer.parseInt(array[1]);
        int S=Integer.parseInt(array[2]);
        int T=Integer.parseInt(array[3]);
//Easier if you create a coordinate chart to see, there will be a pattern
        System.out.println(calculateFrogPos(X,Y,S,T));
    }

    private static int calculateFrogPos(int x, int y, int s, int t) {
        int timeRemaining=t-(x+y);
        if(timeRemaining<0)
            return 0;
        else if (timeRemaining<s) {
            return ((timeRemaining+1)*(timeRemaining+2))/2;
        } else if (timeRemaining>=s*2) {
            return (s+1)*(s+1);
        }
        else {
            return (((timeRemaining+1)*(timeRemaining+2))/2)+calculateReverseSum(s,timeRemaining-s);
        }
    }

    private static int calculateReverseSum(int startValue, int endValue) {
        int sum=0;
        int x=endValue;
        while(x>0) {
            sum = sum + startValue;
            startValue -= 1;
            x -= 1;
        }
        return sum;
    }
}
