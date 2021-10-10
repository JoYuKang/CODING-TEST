package com.company;

import java.util.*;

public class 전력망을둘로나누기 {
    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int val1 = 0;
        int val2 = 0;
        for (int i = 0; i < wires.length; i++) {
            val1 = relationCnt(i, wires);
            val2 = n - val1;
            int total = Math.abs(val1 - val2);
            answer = Math.min(total, answer);
        }

        return answer;

    }

    public static int relationCnt(int idx, int[][] wires) {

        Queue<Integer> que = new LinkedList<>();
        List<int[]> list = new ArrayList<>(Arrays.asList(wires));
        //{{1, 2}, {2, 3}, {3, 4}}
        int parent = list.get(idx)[0];
        que.add(parent);
        list.remove(idx);
        int cnt = 0;

        while (!que.isEmpty()) {
            int temp = que.remove();
            for (int i = 0; i < list.size(); i++) {
                int[] arr = list.get(i);
                boolean flag = true;
                if (arr[1] == temp) {
                    que.add(arr[0]);
                    list.remove(arr);
                    flag = false;
                }
                if (arr[0] == temp) {
                    que.add(arr[1]);
                    list.remove(arr);
                    flag = false;
                }
                if (flag == false) {
                    i--;
                }
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(solution(n, wires));
    }
}
