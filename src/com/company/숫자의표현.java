package com.company;

public class 숫자의표현 {
    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            sum += i;
            if (sum == n) {
                answer++;
            }

            for (int j = i + 1; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }
}
