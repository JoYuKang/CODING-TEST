package com.company.prgm;

import java.util.Arrays;

public class 주식가격 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            int cnt = 0;
            for (int j = i; j < prices.length - 1; j++) {
                if (prices[i] <= prices[j]) {
                    cnt++;
                    answer[i] = cnt;
                } else {
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }
}
