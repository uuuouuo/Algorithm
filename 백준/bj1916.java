package 백준;

import java.io.*;
import java.util.*;

public class bj1916 { // 최소비용구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Info>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken()); // 출발도시
            int from = Integer.parseInt(st.nextToken()); // 도착도시
            int cost = Integer.parseInt(st.nextToken());

            list[to].add(new Info(from, cost));
        }

        int INF = Integer.MAX_VALUE;
        int[] cost = new int[N + 1];
        for (int i = 1; i <= N; i++)
            cost[i] = INF;

        st = new StringTokenizer(br.readLine());
        solution(list, cost, N, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

    }

    static void solution(List<Info>[] list, int[] cost, int N, int from, int to) {
        PriorityQueue<Info> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        boolean[] check = new boolean[N + 1];
        q.add(new Info(from, 0));
        cost[from] = 0;

        while (!q.isEmpty()) {
            Info cur = q.poll();

            if (cur.city == to) {
                System.out.println(cur.cost);
                break;
            }
            if (check[cur.city])
                continue;
            check[cur.city] = true;

            for (int i = 0; i < list[cur.city].size(); i++) {
                Info next = list[cur.city].get(i);
                if (!check[next.city] && cost[next.city] > cur.cost + next.cost) {
                    cost[next.city] = cur.cost + next.cost;
                    q.add(new Info(next.city, cost[next.city]));
                }

            }
        }
    }

    static class Info {
        int city, cost;

        public Info(int node, int cost) {
            this.city = node;
            this.cost = cost;
        }
    }

}
