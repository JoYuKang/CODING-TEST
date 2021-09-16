package com.company;


import java.util.*;

public class 입실퇴실 {

    public static int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < enter.length; i++) {
            queue.add(leave[i]);
        }

        for (int i = 0; i < enter.length; i++) {
            arrayList.add(enter[i]);
            if (arrayList.contains(queue.peek())) {
                if (arrayList.size() >= 2) {
                    while (true) {
                        if (arrayList.size() == 0) {
                            break;
                        }
                        if (arrayList.get(arrayList.size() - 1).equals(queue.peek())) {
                            answer[queue.peek() - 1] += arrayList.size() - 1;
                            arrayList.remove(queue.poll());
                            for (int j = 0; j < arrayList.size(); j++) {
                                answer[arrayList.get(j) - 1]++;
                            }
                        }
                        boolean check = arrayList.contains(queue.peek());
                        while (check) {
                            arrayList.remove(queue.poll());
                            check = arrayList.contains(queue.peek());
                        }
                        if (!check) {
                            break;
                        }

                    }
                } else {
                    arrayList.remove(queue.poll());
                }

            } else {
                if (arrayList.size() > 1) {
                        
                    for (int j = 0; j < arrayList.size(); j++) {
                        answer[arrayList.get(j) - 1]++;

                    }
                    if (arrayList.size() > 2) {
                        answer[arrayList.size() - 1] += arrayList.size() - 2;
                    }

                }

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
