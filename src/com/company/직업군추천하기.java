package com.company;
import java.util.*;

public class 직업군추천하기 {

    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";

        List<Integer> arr = new ArrayList<>();
        List<String> arr1 = new ArrayList<>();
        String[] menu = {"SI", "CONTENTS", "HARDWARE", "PORTAL", "GAME"};
        int max = 0;
        for (int i = 0; i < table.length; i++) {
            String[] temp = table[i].split(" ");
            int total = 0;
            for (int j = 1; j < temp.length; j++) {
                for (int k = 0; k < languages.length; k++) {
                    if (temp[j].equals(languages[k])) {
                        int count = (6 - j) * preference[k];
                        total += count;
                        break;
                    }
                }
            }
            if (max < total) {
                max = total;
            }

            arr.add(total);
        }
        for(int i = 0 ;i<arr.size();i++){
            if(arr.get(i)==max){
                arr1.add(menu[i]);
            }
        }
        Collections.sort(arr1);

        answer = arr1.get(0);


        return answer;
    }



    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#"
                        , "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++"
                        , "HARDWARE C C++ PYTHON JAVA JAVASCRIPT"
                        , "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP"
                        , "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = {"PYTHON", "C++", "SQL"};
        int[] preference = {7, 5, 5};
        System.out.println(solution(table, languages, preference));
    }
}
