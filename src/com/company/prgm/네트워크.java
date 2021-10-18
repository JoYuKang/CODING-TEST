package com.company.prgm;

public class 네트워크 {


    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean visit[];
        visit = new boolean[computers[0].length];

        for (int i = 0; i < computers.length; i++) {
            if (!visit[i]) {
                dfs(i, computers, visit);
                answer++;
            }
        }
        return answer;
    }

    private static void dfs(int n, int[][] computers,boolean[] visit) {
        visit[n] = true;
        for (int i = 0; i < computers[0].length; i++) {
            if (!visit[i] && computers[n][i] == 1) {
                dfs(i, computers,visit);

            }
        }

    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(n, computers));
    }
}
