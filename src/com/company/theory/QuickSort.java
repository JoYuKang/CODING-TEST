package com.company.theory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class QuickSort {
    public static void splitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return;
        }
        int pivot = dataList.get(0);
        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i) < pivot) {
                leftArr.add(dataList.get(i));
            } else {
                rightArr.add(dataList.get(i));
            }
        }
        ArrayList<Integer> mergedArr = new ArrayList<>();
        mergedArr.addAll(leftArr);
        mergedArr.addAll(Collections.singletonList(pivot));
        mergedArr.addAll(rightArr);
        System.out.println(dataList);
    }

    /*
    QuickSort.sort() 함수 만들기
    만약 리스트 갯수가 한개이면 해당 리스트 리턴
    그렇지 않으면, 리스트 맨 앞의 데이터를 기준점(pivot)으로 놓기
    left, right 리스트 변수를 만들고,
    맨 앞의 데이터를 뺀 나머지 데이터를 기준점과 비교(pivot)
    기준점보다 작으면 left.add(해당 데이터)
    기준점보다 크면 right.add(해당 데이터)
    결국 QuickSort.sort(left) + pivot + QuickSort.sort(right) 을 리턴하는 방식으로 재귀 호출
     */
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 10; index++) {
            testData.add((int)(Math.random() * 100));
        }

        splitFunc(testData);
    }


}
