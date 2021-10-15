package com.company.prgm;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {


    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int answer, x, y, nx, ny;
        // 상 하 좌 우
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        boolean[][] visit = new boolean[n][m];
        Queue<Integer> queue = new LinkedList<>();
        // 시작 좌표 고정 및 방문 확인
        queue.add(0);
        queue.add(0);
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            //좌표값 넣기
            x = queue.poll();
            y = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                // 상하죄우 이동 좌표
                nx = x + dx[i];
                ny = y + dy[i];
                // 범위에서 벗어나면 continue
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 0 == 벽이면 지나가지 못함
                if (maps[nx][ny] == 0) continue;
                // 방문확인 후 방문 안했으면 해당 좌표값으로 이동 및 이동 횟수 추가
                if (!visit[nx][ny]) {
                    queue.add(nx);
                    queue.add(ny);
                    maps[nx][ny] = maps[x][y] + 1;
                    visit[nx][ny] = true;
                }
            }
        }
        // 도착 좌표 설정
        answer = maps[n - 1][m - 1];
        // 마지막 좌표까지 도착하지 못했다면
        if (maps[n - 1][m - 1] == 1){
            answer = -1;
        }

        return answer;
    }


    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        System.out.println(solution(maps));
    }
}
