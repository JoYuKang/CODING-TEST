package com.company.prgm;


public class 스킬트리 {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            boolean check = true;
            int skillLength = 0;

            for (int j = 0; j < skill_trees[i].length(); j++) {
                for (int k = 0; k < skill.length(); k++) {
                    if (skill_trees[i].charAt(j) == skill.charAt(k)) {
                        if (k != skillLength) {
                            check = false;
                        } else {
                            skillLength++;
                        }
                    }
                }
            }
            if (check) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill, skill_trees));
    }
}
