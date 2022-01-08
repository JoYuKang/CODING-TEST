package com.company.prgm;

public class 문자열압축 {

    public static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String prev = s.substring(0, i);
            int count = 1;
            StringBuilder str = new StringBuilder();
            String last = "";
            for (int j = i; j < s.length(); j += i) {
                if (j + i > s.length()) {
                    last = s.substring(j);
                    continue;
                }
                String substring = s.substring(j, j + i);
                if (prev.equals(substring)) {
                    count++;
                } else {
                    str.append(prev);
                    if (count != 1) {
                        str.insert(0, count);
                    }
                    prev = substring;
                    count = 1;
                }
            }
            str.append(prev).append(last);
            if (count != 1) {
                str.insert(0, count);
            }

            answer = Math.min(answer, str.length());
        }


        return answer;
    }

    public static void main(String[] args) {

        String s = "aabbaccc";
        System.out.println(solution(s));


    }


}
