package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 교점에별만들기_리팩토링 {
    public static String[] solution(int[][] line) {
        String[] answer;
        List<List<Long>> arr = new ArrayList<>();

        long A;
        long B;
        long E;
        long C;
        long D;
        long F;
        int xMax = Integer.MIN_VALUE;

        int xMin = Integer.MAX_VALUE;

        int yMax = Integer.MIN_VALUE;

        int yMin = Integer.MAX_VALUE;

        for (int i = 0; i < line.length - 1; i++) {
            A = line[i][0];
            B = line[i][1];
            E = line[i][2];

            for (int j = i + 1; j < line.length; j++) {
                C = line[j][0];
                D = line[j][1];
                F = line[j][2];
                if ((A * D - B * C) == 0)
                    continue;
                if ((B * F - E * D) % (A * D - B * C) != 0 || (E * C - A * F) % (A * D - B * C) != 0) {
                    continue;
                }
                int x = ((int) (B * F - E * D) / (int) (A * D - B * C));
                int y = ((int) (E * C - A * F) / (int) (A * D - B * C));

                List<Long> temp = Arrays.asList((long) x, (long) y);
                arr.add(temp);
                xMax = Math.max(xMax, x);
                xMin = Math.min(xMin, x);
                yMax = Math.max(yMax, y);
                yMin = Math.min(yMin, y);
            }
        }
        List<String> board = new ArrayList<>();
        for (int i = yMin; i <= yMax; i++) {
            board.add(".".repeat((int) (xMax - xMin + 1)));
        }
        //System.out.println(yMax);

        //arr 안에 list 뽑기
        for (List<Long> destination : arr) {
                                //arr 안에 list 값 중 높이를 구하는 방법 get(1) -> (절대값)y - y의 최대값 ->(최소)0 or 양수
            StringBuilder sb = new StringBuilder(board.get((int) Math.abs(destination.get(1) - yMax)));

            System.out.println((int) Math.abs(destination.get(1) - yMax));
                                //arr 안에 list x의 값 구하기 get(0) -> (절대값)x - x의 최소값 -> (최소)0 or 양수
            sb.setCharAt((int) Math.abs(destination.get(0) - xMin), '*');
            board.set((int) Math.abs(destination.get(1) - yMax), sb.toString());
            System.out.println("destination :" + destination + " : " + sb);
        }

        answer = new String[board.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = board.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        System.out.println(Arrays.toString(solution(line)));
    }
}
