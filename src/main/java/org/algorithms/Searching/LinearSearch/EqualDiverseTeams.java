package org.algorithms.Searching.LinearSearch;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EqualDiverseTeams
{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testcase = Integer.parseInt(s.nextLine());
        for (int i = 0; i < testcase; i++) {
            String[] NAndK = s.nextLine().split(" ");
            String[] array = s.nextLine().split(" ");
            int N = Integer.parseInt(NAndK[0]);
            int K = Integer.parseInt(NAndK[1]);
            System.out.println(getResult(N, K, array));
        }
    }
    /*
Took help to solve this solution
*/
    private static String getResult(int n, int k, String[] array) {
        //code
        HashMap<Integer, Integer> uniqueCount = new HashMap<>();
        for (String element : array) {
            //got all unique subjects from all students
            Integer ele = Integer.parseInt(element);
            if (uniqueCount.containsKey(ele)) {
                uniqueCount.put(ele, uniqueCount.get(ele) + 1);
            } else {
                uniqueCount.put(ele, 1);
            }
        }
        Set<Integer> unique = new HashSet<>();
        Set<Integer> frequent = new HashSet<>();
        for(Integer i: uniqueCount.keySet()) {
            if(uniqueCount.get(i) == 1) {
                unique.add(i);
            } else {
                frequent.add(i);
            }
        }
        if(unique.size() + 2 * frequent.size() >= 2 * k &&
          unique.size() + frequent.size() <= 2 * k) {
            return "YES";
        }
        return "NO";
    }
}
