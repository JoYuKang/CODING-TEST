package com.company;

import java.util.Arrays;
import java.util.Stack;

public class 크레인인형뽑기게임 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int temp1 = 0;
        for (int i = 0; i < moves.length; i++) {
            int num = 0;
            boolean check = false;
            while (board[num][moves[i] - 1] == 0) {
                num++;
                if (num == board.length) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                if (!stack.empty()) {
                    temp1 = stack.peek();
                }
                stack.add(board[num][moves[i] - 1]);
                if (stack.peek() == temp1) {
                    answer++;
                    stack.pop();
                    stack.pop();
                }
                board[num][moves[i] - 1] = 0;
            }


        }


        return answer * 2;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));


    }
}
