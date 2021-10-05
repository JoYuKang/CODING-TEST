package com.company.prgm;


import java.util.Map;
import java.util.TreeMap;

public class 완주하지못한선수 {
    public static String solution(String[] participant, String[] completion) {
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < participant.length; i++) {
            if (map.get(participant[i]) == null) {
                map.put(participant[i], 1);
                continue;
            }
            int val = map.get(participant[i]) + 1;
            map.put(participant[i], val);
        }


        for (int i = 0; i < completion.length; i++) {
            int val = map.get(completion[i]) - 1;
            map.put(completion[i], val);
        }

        for (int i = 0; i < map.size(); i++) {
            if (map.get(participant[i]) != 0) {
                answer.append(participant[i]);
                break;
            }
        }


        return answer.toString();
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));
    }

}
