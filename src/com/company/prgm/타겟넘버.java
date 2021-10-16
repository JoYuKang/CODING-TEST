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
        // 기존 + 해준 SUM에서 - 를 두 번 해주면 -한 값으로 SUM이 계산
        sum -= numbers[length] * 2;

        dfs(numbers, target, length + 1, sum);

    }


    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }
}
