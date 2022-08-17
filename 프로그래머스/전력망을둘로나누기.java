package 프로그래머스;

import java.util.*;

class 전력망을둘로나누기 {

    static List<Integer> list[];

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        list = new ArrayList[n + 1];
        setList(n, wires);
        for (int i = 0; i < n - 1; i++) {
            check = new boolean[n + 1];
            int top1 = wires[i][0];
            int top2 = wires[i][1];
            int tmp = 0;
            for (int j = 1; j <= n; j++) { // 걍 시작점 찾으려고
                if (top1 == j || top2 == j)
                    continue;
                tmp = go(n, wires, j, top1, top2);
                break;
            }
            answer = Math.min(Math.abs(n - tmp - tmp), answer);
        }

        return answer;
    }

    static boolean[] check;

    static int go(int n, int[][] wires, int start, int top1, int top2) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int size = list[cur].size();
            check[cur] = true;
            cnt++;
            for (int i = 0; i < size; i++) {
                int next = list[cur].get(i);

                if (check[next] || (next == top1 && cur == top2)
                        || (next == top2 && cur == top1))
                    continue;
                q.add(next);
            }
        }
        return cnt;
    }

    static void setList(int n, int[][] wires) {
        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int from = wires[i][0];
            int to = wires[i][1];
            list[from].add(to);
            list[to].add(from);
        }
    }
}