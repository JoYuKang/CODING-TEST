package com.company;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 전력망을둘로나누기_수정 {


    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int[][] arr = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];
        int cnt = 0;

        // 연결하기
        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        // 연결 배열 확인
        //System.out.println(Arrays.deepToString(arr));

        // 전력망 나누기
        for (int i = 0; i < wires.length; i++) {

            //연결된 부분 1 -> 0 으로 바꿔 연결 끊기
            arr[wires[i][0]][wires[i][1]] = 0;
            arr[wires[i][1]][wires[i][0]] = 0;

            // 초기화
            cnt = 0;
            // 방문확인 초기화
            visited = new boolean[n + 1];

            // BFS
            Queue<Integer> q = new LinkedList<>();
            //1부터 확인
            q.add(1);

            visited[1] = true;

            while (!q.isEmpty()) {
                int start = q.poll();
                //연결된 만큼 cnt를 늘려 개수 확인
                cnt++;

                for (int j = 1; j <= n; j++) {
                    if (visited[j] || arr[start][j] == 0) {
                        continue;
                    }
                        q.add(j);
                        visited[j] = true;
                }
            }

            arr[wires[i][0]][wires[i][1]] = 1; // 다시 연결하기
            arr[wires[i][1]][wires[i][0]] = 1;

            // 최소값 계산
            int tower = Math.abs(n - cnt * 2);
            if (answer > tower) {
                answer = tower;
            }
        }


        return answer;
    }


    public static void main(String[] args) {
        int n = 4;
        int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(solution(n, wires));
    }
}
