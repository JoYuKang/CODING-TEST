package com.company.test;

import java.util.Scanner;

public class Time {

    public static boolean check(int h, int m, int s) {
        if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cnt = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= num; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    // 매 시각 안에 '3'이 포함되어 있다면 카운트 증가
                    if (check(i, j, k)) cnt++;
                    String s = "";
                    s += i + "" + j + "" + k;
                    ;
                    if (s.contains("3")) {

                        count++;
                    }
                }
            }
        }
        System.out.println(cnt);
        System.out.println(count);

    }
}
