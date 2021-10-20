package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 교점에별만들기 {
    public static String[] solution(int[][] line) {

        List<List<Integer>> arr = new ArrayList<>();


        int A = 0;
        int B = 0;
        int E = 0;
        int C = 0;
        int D = 0;
        int F = 0;
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

                    if ((A * D - B * C) == 0 || (B * F - E * D) % (A * D - B * C) != 0 || (E * C - A * F) % (A * D - B * C) != 0) {
                        continue;
                    }
                    int x = (B * F - E * D) / (A * D - B * C);
                    int y = (E * C - A * F) / (A * D - B * C);

                    List<Integer> temp = Arrays.asList((int) x, (int) y);
                    arr.add(temp);
                    xMax = Math.max(xMax, x);
                    xMin = Math.min(xMin, x);
                    yMax = Math.max(yMax, y);
                    yMin = Math.min(yMin, y);
                }
            }


        String[] answer = new String[yMax - yMin + 1];
        System.out.println(arr);
        int cnt = 0;
        int mid = (xMax - xMin + 1) / 2;
        for (int i = yMax; i >= yMin; i--) {
            StringBuilder sb = new StringBuilder();
            sb.append(".".repeat(xMax - xMin + 1));

            for (int j = 0; j < arr.size(); j++) {
                if (i != arr.get(j).get(1)) {
                    continue;
                }
                int destinationX = mid - arr.get(j).get(0);
                sb.setCharAt(destinationX, '*');

            }

            answer[cnt] = sb.toString();
            sb.replace(0, sb.length(), "");
            cnt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        System.out.println(Arrays.toString(solution(line)));
    }
}
