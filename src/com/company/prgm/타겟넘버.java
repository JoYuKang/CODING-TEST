package com.company.prgm;

import java.util.Stack;

public class 타겟넘버 {

    static int answer = 0;

    public static int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);

        return answer;
    }

    private static void dfs(int[] numbers, int target, int length, int sum) {
        if (length == numbers.length) {
            if (target == sum) {
                answer++;
            }
            return;
        }
        sum += numbers[length];
        dfs(numbers, target, length + 1, sum);
        // 현재 인덱스의 정수를 -로 합해준다.
        sum -= numbers[length] *2;

        dfs(numbers, target, length + 1, sum);

    }


    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }
}
