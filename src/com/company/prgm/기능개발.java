package com.company.prgm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class 기능개발 {
    public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int cnt = 1;
            int sum = progresses[i] + speeds[i] * cnt;
            while (sum < 100) {
                cnt++;
                sum = progresses[i] + speeds[i] * cnt;
            }
            queue.add(cnt);
        }

        while (!queue.isEmpty()) {
            int start = queue.poll();
            int cnt = 1;
            while (!queue.isEmpty() && start >= queue.peek()) {
                queue.poll();
                cnt++;
            }
            answer.add(cnt);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(solution(progresses, speeds));
    }
}
