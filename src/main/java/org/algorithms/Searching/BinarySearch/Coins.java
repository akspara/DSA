package org.algorithms.Searching.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/*
There are N bags and each bag contains some coin(s). Your task is to select an integer X
 and remove all the bags in which the number of coins is equal to X
. Divide the remaining bags into two non-empty groups such that:

 The number of coin(s) in each bag of the first group is strictly smaller than X.
The number of coin(s) in each bag of the second group is strictly larger than X.
The total number of coins of one group is equal to the other.
 */

public class Coins {
    //partially accepted

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String bags=bf.readLine();
        String[] coinsString=bf.readLine().split(" ");
        ArrayList<Integer> coins=new ArrayList<>(Integer.parseInt(bags));
        for (String s : coinsString) {
            coins.add(Integer.parseInt(s));
        }
        System.out.println(isreducepossible(coins,Integer.parseInt(bags)));
    }

    private static String isreducepossible(ArrayList<Integer> coins, Integer bags) {
        Collections.sort(coins);
        int start=0;
        int end=bags-1;
        int startTotal=coins.get(start);
        int endTotal=coins.get(end);
        while(start<=end)
        {
                if(startTotal<endTotal)
                {
                    start+=1;
                    startTotal+= coins.get(start);
                } else if (endTotal<startTotal) {
                    end-=1;
                    endTotal+= coins.get(end);
                }
                else if(Objects.equals(coins.get(start), coins.get(end))
                || start+1==end) {
                    return  "YES";
                } else
                {
                    start+=1;
                    startTotal+= coins.get(start);
                }
        }
        return "NO";

    }
}
