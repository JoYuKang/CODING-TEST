package com.company.prgm;

public class 다음큰숫자 {

    public static int solution(int n) {
        int cnt = Integer.bitCount(n);
        while (true){
            n++;
            if(cnt == Integer.bitCount(n)){
                return n;
            }
        }
    }



    public static void main(String[] args) {
        int n = 78;
        System.out.println(solution(n));
    }
}
