package com.company.BaekJoon;

import java.util.Scanner;

public class 팰린드롬수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String a = sc.next();
            if (a.equals("0")) {
                break;
            }
            boolean flag = true;

            for (int i = 0; i < a.length() - 1 - i; i++) {
                if (a.charAt(i) != a.charAt(a.length() - 1 - i)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println("yes");
            else
                System.out.println("no");

        }

    }
}
