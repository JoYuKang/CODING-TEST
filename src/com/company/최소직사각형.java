package com.company;

import java.util.Arrays;

public class 최소직사각형 {

    public static int solution(int[][] sizes) {
        int answer = 0;
        int[] low = new int[sizes.length];
        int[] high = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                low[i] = sizes[i][0];
                high[i] = sizes[i][1];
            } else {
                low[i] = sizes[i][1];
                high[i] = sizes[i][0];
            }
        }
        Arrays.sort(low);
        Arrays.sort(high);

        answer = low[low.length - 1] * high[high.length - 1];

        return answer;
    }
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes));
    }
}
