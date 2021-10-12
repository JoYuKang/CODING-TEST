package com.company.prgm;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {
    public static String[] solution(String[] strings, int n) {

/*
        String[] temp = new String[strings.length];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = strings[i].charAt(n) + strings[i];
        }

        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            int count = temp[i].length();
            temp[i] = temp[i].substring(1, count);
        }


        return temp;

 */
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // n번째 문자가 같을 경우에 원본 스트링을 사전순으로 정렬하기 위해 compareTo사용
                if (o1.charAt(n) == o2.charAt(n)) {
                    return o1.compareTo(o2);
                } else {
                    return o1.charAt(n) - o2.charAt(n);
                }
            }
        });

        return strings;
    }

    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        System.out.println(Arrays.toString(solution(strings, n)));
    }
}
