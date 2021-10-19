package com.company.prgm;

import java.util.Arrays;

public class 체육복 {
    public static int solution(int n, int[] lost, int[] reserve) {

        int[] student = new int[n];
        Arrays.fill(student, 1);
        for (int l : lost) student[l - 1] -= 1;
        for (int r : reserve) student[r - 1] += 1;

        for (int i = 0; i < n; i++) {
            if (student[i] >= 1) continue;
            if (i > 0 && student[i - 1] > 1) {
                student[i - 1] -= 1;
                student[i] += 1;
            } else if (i + 1 < student.length && student[i + 1] > 1) {
                student[i + 1] -= 1;
                student[i] += 1;
            }
        }


        return (int) Arrays.stream(student).filter(i -> i > 0).count();
    }

    public static void main(String[] args) {
        int n = 5;

        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(solution(n, lost, reserve));
    }

}
