package com.company.prgm;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            int temp = truck_weights[i];
            while (true) {
                //큐가 비여있으면 더해준다 시간 ++;
                if (queue.isEmpty()) {
                    queue.add(temp);
                    answer++;
                    sum += temp;
                    break;
                }
                // size = 길이, 길이가 꽉 찬다면 다리를 다 지나갔다.
                else if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                }
                // 큐가 비어있지 않은 상태에서 다리를 다 지나지 않음
                else {
                    // 다음 들어올 트럭의 무게가 다리의 지탱무게를 넘어서서 0을 넣어 큐의 사이즈를 늘린다(그 전 트럭이 한칸 전진)
                    if (sum + temp > weight) {
                        queue.add(0);
                        answer++;
                    }
                    // 다음 트럭이 들어와도 무게가 넘지 않음 다음 트럭이 다리에 들어간다
                    else {
                        queue.add(temp);
                        answer++;
                        sum += temp;
                        break;
                    }
                }
            }
        }
        // 마지막 트럭은 다리를 혼자 완전히 지나가기 위해 길이만큼 시간을을 더해주어 return한다.
        return answer + bridge_length;
    }


    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}
