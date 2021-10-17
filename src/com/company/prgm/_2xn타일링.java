package com.company.prgm;

import java.util.Arrays;

public class _2xn타일링 {

    public static int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            int temp = arr[i - 1] + arr[i - 2];
            arr[i] = temp % 1000000007;

        }
        //System.out.println(Arrays.toString(arr));
        answer = arr[n];

        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }
}
