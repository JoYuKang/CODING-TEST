package com.company;

import java.util.*;

public class 교점에별만들기 {
    public static String[] solution(int[][] line) {

        List<List<Long>> arr = new ArrayList<>();

        long A;
        long B;
        long E;
        long C;
        long D;
        long F;
        double xMax = Integer.MIN_VALUE;
        xMax--;
        double xMin = Integer.MAX_VALUE;
        xMin++;
        double yMax = Integer.MIN_VALUE;
        yMax--;
        double yMin = Integer.MAX_VALUE;
        yMin++;
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
        //System.out.println(arr);
        String[] answer = new String[(int) (yMax - yMin + 1)];
        //System.out.println(arr);
        int cnt = 0;
        long mid = (long) ((xMax - xMin + 1) / 2);
        for (double i = yMax; i >= yMin; i--) {
            StringBuilder sb = new StringBuilder();
            sb.append(".".repeat((int) (xMax - xMin + 1)));

            for (int j = 0; j < arr.size(); j++) {
                if (i != arr.get(j).get(1)) {
                    continue;
                }
                int destinationX = (int) (mid + arr.get(j).get(0));
                sb.setCharAt(destinationX, '*');
            }

            answer[cnt++] = sb.toString();
            sb.replace(0, sb.length(), "");
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        System.out.println(Arrays.toString(solution(line)));
    }
}
