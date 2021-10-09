package com.company.prgm;

import java.util.*;

public class 더맵게 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        while (queue.size() >= 2 && queue.peek() < K) {
            int a = queue.poll();
            int b = queue.poll();
            queue.add(a + b * 2);
            answer++;
        }

        if (!queue.isEmpty() && K > queue.peek()){
            return -1;
        }
        return answer;

    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }
}
