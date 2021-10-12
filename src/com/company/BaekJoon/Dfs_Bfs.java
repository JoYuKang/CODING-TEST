package com.company.BaekJoon;


import java.util.*;

public class Dfs_Bfs {

    static int n, m, k;
    static boolean[] visit;
    static ArrayList<Integer>[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        arr = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        // arr[i]를 ArrayList로 만들어 연결 노드에 따라 추가 되도록 구현
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        // 양 방향이기 때문에 둘다 넣어준다
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x].add(y);
            arr[y].add(x);
        }

        //System.out.println(Arrays.toString(arr));
        // 작은 순부터 나오게 정렬
        for (int i = 0; i < arr.length; i++) {
            Collections.sort(arr[i]);
        }

        dfs(k);
        System.out.println(sb);
        sb.delete(0, sb.length());
        for (int i = 1; i <= n; i++){
            visit[i] = false;
        }
        bfs(k);
        System.out.println(sb);


    }

    // x 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(" ");
        for (int i = 0; i < arr[x].size(); i++) {
            if (visit[arr[x].get(i)]) {
                continue;
            }
            dfs(arr[x].get(i));
        }

    }
    // start 에서 시작해서 갈 수 있는 정점들을 모두 탐색하기
    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visit[start] = true;

        while (!que.isEmpty()) {
            int z = que.poll();
            sb.append(z).append(" ");
            for (int i = 0; i < arr[z].size(); i++) {
                if(visit[arr[z].get(i)]){
                   continue;
                }

                que.add(arr[z].get(i));
                visit[arr[z].get(i)] = true;
            }
        }
    }
}
