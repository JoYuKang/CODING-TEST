package com.company;


import java.util.Stack;

public class 괄호회전하기 {

    public static int solution(String s) {
        int answer = 0;
        Stack<String> stack = new Stack<>();
        boolean check = true;
        for (int i = 0; i < s.length(); i++) {
            stack.clear();
            check = true;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '(' || s.charAt(j) == '[' || s.charAt(j) == '{') {
                    stack.add(String.valueOf(s.charAt(j)));
                } else {
                    if (stack.empty()) {
                        check = false;
                        break;
                    } else {
                        if (s.charAt(j) == ')' && stack.peek().equals("(")) {
                            stack.pop();
                        } else if (s.charAt(j) == ']' && stack.peek().equals("[")) {
                            stack.pop();
                        } else if (s.charAt(j) == '}' && stack.peek().equals("{")) {
                            stack.pop();
                        } else {
                            check = false;
                            break;
                        }
                    }
                }

            }
            if (check) {
                for (int k = 0; k < i; k++) {
                    if (s.charAt(k) == '(' || s.charAt(k) == '[' || s.charAt(k) == '{') {
                        stack.add(String.valueOf(s.charAt(k)));
                    } else {
                        if (stack.empty()) {
                            check = false;
                            break;
                        } else {
                            if (s.charAt(k) == ')' && stack.peek().equals("(")) {
                                stack.pop();
                            } else if (s.charAt(k) == ']' && stack.peek().equals("[")) {
                                stack.pop();
                            } else if (s.charAt(k) == '}' && stack.peek().equals("{")) {
                                stack.pop();
                            } else {
                                check = false;
                                break;
                            }
                        }
                    }

                }
            }

            if (stack.empty() && check) {
                answer++;
            }

        }
        return answer;
    }


    public static void main(String[] args) {
        String s = "[](){}";
        System.out.println(solution(s));
    }
}
