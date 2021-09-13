package com.company;

public class 상호평가 {
    public static String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < scores.length; i++) {
            int max = 0;
            int min = 101;
            int totalsum = 0;
            int count = 0;
            int maxmincount = 0;
            for (int j = 0; j < scores[i].length; j++) {
                if (max < scores[j][i]) {
                    max = scores[j][i];
                }
                if (min > scores[j][i]) {
                    min = scores[j][i];
                }
                totalsum += scores[j][i];
                if (i == j) {
                    count = scores[i][j];
                }
            }

            int length = scores[i].length;

            for (int j = 0; j < scores[i].length; j++) {
                if (count == scores[j][i]) {
                    maxmincount++;
                }
            }


            if ((max == count || min == count) && maxmincount == 1) {
                totalsum -= count;
                length -= 1;
            }
            answer.append(grade(totalsum / length));
        }


        return answer.toString();
    }

    public static String grade(int grade) {
        String a = "";
        String[] c = {"A", "B", "C", "D", "F"};
        if (grade >= 90) {
            a = c[0];
        } else if (grade >= 80) {
            a = c[1];
        } else if (grade >= 70) {
            a = c[2];
        } else if (grade >= 50) {
            a = c[3];
        } else {
            a = c[4];
        }

        return a;
    }

    public static void main(String[] args) {
        int[][] scores = {{75, 50, 100}, {75, 100, 20}, {100, 100, 20}};
        System.out.println(solution(scores));
    }
}
