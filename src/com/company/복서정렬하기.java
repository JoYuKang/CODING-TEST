package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class 복서정렬하기 {
    public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];

        Character[] arr = {'N', 'W', 'L'};
        double[] Wrate = new double[weights.length];
        int[] sameWeightW = new int[weights.length];

        for (int i = 0; i < weights.length; i++) {
            double[] cntW = new double[weights.length];
            int[] cntN = new int[weights.length];
            for (int j = 0; j < head2head.length; j++) {
                if (head2head[i].charAt(j) == arr[0]) {
                    cntN[i]++;
                }
                if (head2head[i].charAt(j) == arr[1]) {
                    cntW[i]++;
                    if (weights[i] < weights[j]) {
                        sameWeightW[i]++;
                    }
                }
            }
            if(weights.length - cntN[i] == 0){
                Wrate[i] =0;
            }else{
                Wrate[i] = cntW[i] / (weights.length - cntN[i]);
            }

        }

  //      System.out.println("Wrate" + Arrays.toString(Wrate));

  //      System.out.println("sameWeightW" + Arrays.toString(sameWeightW));
        for (int i = 0; i < weights.length; i++) {
            int cnt = 0;
            for (int j = 0; j < weights.length; j++) {
                if (Wrate[i] < Wrate[j]) {
                    cnt++;
                } else if (Wrate[i] == Wrate[j]) {
                    if (sameWeightW[i] < sameWeightW[j]) {
                        cnt++;
                    } else if (sameWeightW[i] == sameWeightW[j]) {
                        if (weights[i] < weights[j]) {
                            cnt++;
                        } else if (weights[i] == weights[j]) {
                            if (i > j) {
                                cnt++;
                            }
                        }
                    }
                }
            }
            answer[cnt] = i + 1;
            System.out.println(Arrays.toString(answer));
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] weights = {60,70,60};
        String[] head2head = {"NNN","NNN","NNN"};

        System.out.println(Arrays.toString(solution(weights, head2head)));

    }
}
