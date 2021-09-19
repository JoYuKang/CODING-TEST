package com.company;

import java.util.*;

public class 프린터 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        //우선순위가 높은 순으로 정렬되는 queue 내림차순
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int[] temparr = new int[priorities.length];
        for (int i = 0; i < priorities.length; i++) {
            temparr[i] = priorities[i];
        }
        Arrays.sort(temparr);
        for (int priority : priorities) {
            queue.add(priority);
        }
        System.out.println(Arrays.toString(temparr));

        //큐에서 값 뽑아서 비교 후 맞으면 큐에서 값을 빼고 answer에 ++ 후 locatrion과 비교하여 값이 맞다면 retrun 후 종료
        //방법 1
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                int n = queue.peek();
                if (n == priorities[i]) {
                    queue.poll();
                    answer++;
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }

        //배열을 오름차순으로 정렬 후 하나씩 비교 방법 2
        int n = priorities.length - 1;
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (temparr[n] == priorities[i]) {
                    queue.poll();
                    n--;
                    answer++;
                    if (location == i) {
                        queue.clear();
                        break;
                    }
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        int[] priorities = {1, 4, 9, 1, 7, 1};
        int location = 0;

        System.out.println(solution(priorities, location));
    }
}
