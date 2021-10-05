package com.company.prgm;

public class 올바른괄호_클린코드 {
    private static boolean solution(String s) {
        int count = 0;
        for(int i = 0;i<s.length();i++){

            if(s.charAt(i) == '('){
                count++;
                continue;
            }
            if (count==0) return false;
            count--;
        }
        return count ==0;
    }

    public static void main(String[] args) {
        String s = "()()";
        System.out.println(solution(s));

    }


}
