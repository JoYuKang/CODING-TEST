package com.company;

public class 피보나치수 {
    public static int solution(int n) {
        long[] f = new long[n + 1];

        return (int) (fibo(n, f) % 1234567);
    }

    private static long fibo(int n, long[] f) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1]  % 1234567+ f[i - 2]  % 1234567;
        }
        System.out.println(f[n]);
        System.out.println();
        return  f[n];
    }

    public static void main(String[] args) {
        int n = 39;
        System.out.println(solution(n));
    }
}
