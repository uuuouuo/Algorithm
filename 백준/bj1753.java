package 백준;

import java.io.*;
import java.util.*;

public class bj1753 { // 최단경로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        List<Node>[] list = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[to].add(new Node(from, w)); // 방향이 있었음
        }

        int[] dist = new int[v + 1];
        int INF = Integer.MAX_VALUE;
        for (int i = 1; i < v + 1; i++)
            dist[i] = INF;

        solution(list, dist, v, k);

        for (int i = 1; i <= v; i++)
            System.out.println(dist[i] == INF ? "INF" : dist[i]);

    }

    static class Node {
        int node, cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    static void solution(List<Node>[] list, int[] dist, int v, int start) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        boolean[] check = new boolean[v + 1];

        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (!check[cur.node])
                check[cur.node] = true; // 왜 이때 체크하는 걸까

            for (Node next : list[cur.node]) {
                // 가려고 하는 노드가 방문하지 않았고(!check[next.node])
                // 가려고하는 노드(next.node)의 지금까지 저장된 거리(dist[next.node])보다
                // 현재 노드를 거쳐 해당 노드(cur.cost + next.cost)로 가는 거리가 더 작으면 갱신
                if (!check[next.node] && dist[next.node] > cur.cost + next.cost) {
                    dist[next.node] = cur.cost + next.cost;
                    q.add(new Node(next.node, dist[next.node]));
                }
            }
        }
    }

}
