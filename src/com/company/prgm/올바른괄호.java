package com.company.prgm;

import java.util.Stack;

public class 올바른괄호 {
    private static boolean solution(String s) {
        boolean answer = false;
        Stack<String > stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) =='('){
                stack.add(String.valueOf(s.charAt(i)));
            }
            else{
                if(stack.empty()){
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.empty()){
            answer = true;
        }


        return answer;
    }

    public static void main(String[] args) {
        String s = "()()";
        System.out.println(solution(s));

    }


}
