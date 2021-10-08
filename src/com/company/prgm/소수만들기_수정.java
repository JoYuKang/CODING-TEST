package com.company.prgm;

public class 소수만들기_수정 {
    public static int solution(int[] nums) {
        int answer = 0;
        boolean[] prime = new boolean[500000];
        prime[0] = prime[1] = true;
        for (int i = 2; i * i < prime.length; i += 1) {
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (!prime[nums[i] + nums[j] + nums[k]]) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        System.out.println(solution(num));
    }
}
