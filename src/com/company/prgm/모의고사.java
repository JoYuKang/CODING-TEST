package com.company.prgm;

import java.util.*;

public class 모의고사 {
    public static ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>();

        int[] a = {1, 2, 3, 4, 5};
        int acount = 0;
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int bcount = 0;
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int ccount = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % a.length]) {
                acount++;
            }
            if (answers[i] == b[i % b.length]) {
                bcount++;
            }
            if (answers[i] == c[i % c.length]) {
                ccount++;
            }
        }
        map.put(1, acount);
        map.put(2, bcount);
        map.put(3, ccount);
        int max = Collections.max(map.values());

        for (int i = 1; i <= 3; i++) {
            if (max == map.get(i)) {
                answer.add(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4, 2};
        System.out.println(solution(answers));
    }
}
