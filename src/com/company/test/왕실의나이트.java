package com.company.test;

import java.util.Scanner;

public class 왕실의나이트 {


    public static void main(String[] args) {
        int[][] steps = {{-2, -1}, {-1, -2}, {2, -1}, {1, -2}, {-2, 1}, {-1, 2}, {2, 1}, {1, 2}};
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int column = s.charAt(0) - 'a';
        int low = s.charAt(1) - '0' -1 ;
        int cnt = 0;
        //System.out.println(column);
        //System.out.println(low);
        for (int i = 0; i < steps.length; i++) {
            if (steps[i][0] + column > 0 && steps[i][1] + low > 0 && steps[i][0] + column < 8 && steps[i][1] + low < 8) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
