package com.company;

import java.util.HashSet;

public class 없는숫자더하기 {

    public static int solution(int[] numbers) {
        int answer = 0;

        HashSet<Integer> arr = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            arr.add(numbers[i]);
        }
        for (int i = 1; i < 10; i++) {
            if (!arr.contains(i)) {
                answer += i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};

        System.out.println(solution(numbers));
    }

}
