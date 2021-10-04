package com.company;

import java.util.Arrays;

public class 행렬테두리회전하기 {
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        int[][] temp = new int[rows][columns];
        int cnt = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = cnt;
                temp[i][j] = cnt++;
            }
        }
        //System.out.println(Arrays.deepToString(arr));
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            int min = arr[x1][y1];

            // 가로: 맨 윗줄, 맨 아래줄 최솟값 확인
            for (int j = y1; j <= y2; j++) {
                if (min > arr[x1][j])
                    min = arr[x1][j];
                if (min > arr[x2][j])
                    min = arr[x2][j];
            }

            //세로 : 맨 왼쪽 줄, 맨 오른쪽줄 최솟값 확인
            for (int j = x1; j <= x2; j++) {
                if (min > arr[j][y1])
                    min = arr[j][y1];
                if (min > arr[j][y2])
                    min = arr[j][y2];
            }

            //회전 수행: 맨 위 가로 ->
            for (int j = y1 + 1; j <= y2; j++) {
                temp[x1][j] = arr[x1][j - 1];
            }
            //회전 수행: 맨 아래 가로 ->
            for (int j = y1; j <= y2 - 1; j++) {
                temp[x2][j] = arr[x2][j + 1];
            }

            //회전 수행: 맨 왼쪽 세로
            for (int j = x1; j <= x2 - 1; j++) {
                temp[j][y1] = arr[j + 1][y1];
            }

            //회전 수행: 맨 오른쪽 세로
            for (int j = x1 + 1; j <= x2; j++) {
                temp[j][y2] = arr[j - 1][y2];
            }

            //board 배열에 회전 적용
            for (int k = 0; k < rows; k++) {
                for (int j = 0; j < columns; j++) {
                    arr[k][j] = temp[k][j];
                }
            }
            answer[i] = min;
        }

        return answer;
    }

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        System.out.println(Arrays.toString(solution(rows, columns, queries)));
    }
}
