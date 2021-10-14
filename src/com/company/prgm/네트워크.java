package com.company.prgm;

public class 네트워크 {

    static boolean visit[];

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        visit = new boolean[computers[0].length];

        for (int i = 0; i < computers.length; i++) {
            if (!visit[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }

    private static void dfs(int n, int[][] computers) {
        visit[n] = true;
        for (int i = 0; i < computers[0].length; i++) {
            if (!visit[i] && computers[n][i] == 1) {
                dfs(i, computers);

            }
        }

    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(n, computers));
    }
}
