package 프로그래머스;

import java.util.*;

class Solution {

    static int answer, max, result[];
    static List<Integer> list[];
    static Queue<Info> q;
    static boolean[] check;

    static class Info {
        int node, dis;

        public Info(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    public int solution(int n, int[][] edge) {
        answer = 0;
        max = 0;
        list = new ArrayList[n + 1];
        result = new int[n + 1];
        q = new LinkedList<>();
        check = new boolean[n + 1];

        init(n, edge);
        bfs(n);

        return getAns(n);
    }

    static void init(int n, int[][] edge) {
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
    }

    static void bfs(int N) {

        check[1] = true;
        q.add(new Info(1, 0));
        int n = 2;

        while (!q.isEmpty()) {
            Info cur = q.poll();
            int from = cur.node;
            int dis = cur.dis;

            for (int i = 0; i < list[from].size(); i++) {
                int next = list[from].get(i);
                if (!check[next]) {
                    max = Math.max(dis, max);
                    result[next] = dis;
                    check[next] = true;
                    q.add(new Info(next, dis + 1));
                }
            }
        }
    }

    static int getAns(int n) {
        for (int i = 2; i <= n; i++) {
            if (result[i] == max)
                answer++;
        }
        return answer;
    }
}