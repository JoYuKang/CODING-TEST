package com.company.prgm;

import java.util.Arrays;
import java.util.HashSet;


public class 영어끝말잇기 {
    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        HashSet<String> arr = new HashSet<>();
        arr.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            String check = words[i - 1];
            if (arr.contains(words[i]) || check.charAt(check.length() - 1) != words[i].charAt(0)) {
                answer[0] = arr.size() % n + 1;
                if ((arr.size() + 1) % n != 0) {
                    answer[1] = (arr.size() + 1) / n + 1;
                } else {
                    answer[1] = (arr.size() + 1) / n;
                }
                break;
            }
            arr.add(words[i]);
        }


        return answer;
    }

    public static void main(String[] args) {
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(solution(n, words)));
    }
}
