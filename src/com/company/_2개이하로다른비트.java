package com.company;

import java.util.Arrays;

public class _2개이하로다른비트 {
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            //짝수
            if (n % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                StringBuilder temp = new StringBuilder();
                String binaryString = Long.toBinaryString(numbers[i]);
                if (!binaryString.contains("0")) {
                    // 맨 앞을 10을 넣어줌
                    temp.append("10");
                    temp.append(binaryString.substring(1));

                    String s = "";
                    s += temp;
                    answer[i] = Long.valueOf(s,2);

                    //answer[i] = Long.parseLong(binaryString.substring(1).replace("0", "1"));
                } else {
                    //가장 처음으로 나오는 0 찾기
                    int firstZero = binaryString.lastIndexOf('0');
                    // 0 다음 나오는 1 찾기
                    int firstOne = binaryString.indexOf('1', firstZero);

                    //앞부터 마지막 0 까지 문자열 더해주기
                    temp.append(binaryString, 0, firstZero);
                    // 0부분을 1로 변환
                    temp.append("1");
                    // 1로 변한 뒤 다음 1이 나올 때 까지 부분 더해주기
                    temp.append(binaryString, firstZero + 1, firstOne);
                    // 1이 나온 부분 0으로 변환
                    temp.append("0");
                    // 뒤에 부분 다 넣어주기
                    temp.append(binaryString, firstOne + 1,binaryString.length());
                    String s = "";
                    s += temp;
                    answer[i] = Long.valueOf(s,2);


                }
            }
        }


        return answer;
    }
    // 343 101010111
    public static void main(String[] args) {
        long[] numbers = {343,1015,779,891};

        System.out.println(Arrays.toString(solution(numbers)));
    }
}
