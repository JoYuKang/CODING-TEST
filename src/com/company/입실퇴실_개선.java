package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class 입실퇴실_개선 {
    public static int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];

        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = 0;
        int m = 0;
        while (n < enter.length || m < enter.length) {
            arrayList.add(enter[n]);
            n++;
            for (int i = 0; i < arrayList.size() - 1; i++) {
                answer[arrayList.get(i) - 1]++;
            }
            answer[arrayList.get(arrayList.size() - 1) - 1] = arrayList.size() - 1;
            while (!arrayList.isEmpty() && arrayList.contains(leave[m])) {
                arrayList.remove((Integer) leave[m]);
                m++;
            }


        }


        return answer;
    }

    public static void main(String[] args) {
        int[] enter = {1, 3, 2, 4, 6, 5, 8, 7, 9, 10};
        int[] leave = {9, 5, 1, 10, 7, 4, 8, 6, 2, 3};
        System.out.println(Arrays.toString(solution(enter, leave)));
    }
}
