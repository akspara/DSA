package org.algorithms.Searching.LinearSearch;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
Alice has N students in his class, numbered 1 through N
.The i-th student has expertise in a subject numbered Ai.
Alice has to divide the students into two teams. The uniqueness of a team is defined as the number of distinct subjects
such that there is atleast one student in the team with expertise in the subject.
For example, the uniqueness of a team denoted by
A=[1,2,3,2,4] is 3.
Alice wants to distribute the students of the class into two teams such that each student belongs to exactly one team
 and the uniqueness of each team is exactly K. Will he be able to do so?
 */
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
