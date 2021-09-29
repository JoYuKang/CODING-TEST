package com.company.prgm;

public class 다음큰숫자 {

    public static int solution(int n) {
        int answer = 0;
        int cnt = bitCount(n);

       n++;
        while (cnt != bitCount(n)) {
            n++;
        }

        answer = n;

        return answer;

        // 기존 코드
//        while (true) {
//            n++;
//            if (cnt == bitCount(n)) {
//                return n;
//            }
//        }

    }

    //bitCount 직접구현
    public static int bitCount(int num) {
        int cnt = 0;
        String str = Integer.toBinaryString(num);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                cnt++;
            }
        }

        return cnt;
    }


    public static void main(String[] args) {
        int n = 78;
        System.out.println(solution(n));
    }
}
