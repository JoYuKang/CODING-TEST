package com.company.prgm;

import java.util.Scanner;

public class test {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] arr = new int[10000001];
        arr[2] = 1;
        arr[3] = 1;
        int answer = 0;
        int n = in.nextInt();
        for (int i = 4; i < 10000001; i++) {
            int a = 9999;
            int b = 9999;
            int c = 9999;
            for (int j = 1; j <= 3; j++) {
                if (j == 1) {
                    a = arr[i - 1];
                }
                else if (j == 2) {
                    if (i % 2 == 0) {
                        b = arr[i / 2];
                    }

                }
                else {
                    if (i % 3 == 0) {
                        b = arr[i / 3];
                    }
                }

            }
            int min = Math.min(a, b);
            min = Math.min(min, c);
            arr[i] = min + 1 ;

        }
        System.out.println(arr[n]);

    }


}
