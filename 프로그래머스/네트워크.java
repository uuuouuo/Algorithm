package 프로그래머스;

import java.util.*;

class 네트워크 {
    static List<Integer> list[];
    static boolean[] visited;
    static int answer;

    public int solution(int n, int[][] computers) {
        answer = 0;
        list = new ArrayList[n];
        visited = new boolean[n];
        init(n, computers);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }

        return answer;
    }

    static void init(int n, int[][] computers) {
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && i != j)
                    list[i].add(j);
            }
        }
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int l : list[node]) {
            if (visited[l])
                continue;
            dfs(l);
        }
    }
}