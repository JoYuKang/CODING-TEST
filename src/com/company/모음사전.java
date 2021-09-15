package com.company;

import java.util.Arrays;

public class 모음사전 {
    public static int solution(String word) {
        int answer = 0;
        Character[] arr = {'A', 'E', 'I', 'O', 'U'};
        int num = 781; // ((((5 + 1)*5 + 1)* 5 + 1) * 5 + 1) = 781
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals(word.charAt(i))) {
                    answer += num * j + 1;
                    break;
                }
            }
            num = num / 5;
        }


        return answer;

    }

    public static void main(String[] args) {
        String word = "I";
        System.out.println(solution(word));

    }
}
