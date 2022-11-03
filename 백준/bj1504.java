package 백준;

import java.io.*;
import java.util.*;

// 특정한 두점을 거쳐야 한다면,
// 두가지 경우로 나눠 생각
// 첫번째, 1-V1-V2-N 의 최단거리
// 두번쨰, 1-V2-V1-N 의 최단거리
public class bj1504 { // 특정한최단경로

    static class Node {
        int node, cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    static int INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<Node>[] list = new ArrayList[v + 1];

        for (int i = 1; i <= v; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[to].add(new Node(from, w));
            list[from].add(new Node(to, w));
        }

        INF = 200000000; // Integer.MAX_VALUE로 했다가 삽질 (더하니까 음수로 바뀜) -> 간선(200000) * 최대거리(1000)

        st = new StringTokenizer(br.readLine());
        int node1 = Integer.parseInt(st.nextToken());
        int node2 = Integer.parseInt(st.nextToken());

        int res1 = 0;
        res1 += solution(list, v, 1, node1);
        res1 += solution(list, v, node1, node2);
        res1 += solution(list, v, node2, v);

        int res2 = 0;
        res2 += solution(list, v, 1, node2);
        res2 += solution(list, v, node2, node1);
        res2 += solution(list, v, node1, v);

        if (res1 >= INF && res2 >= INF)
            System.out.println(-1);
        else
            System.out.println(Math.min(res1, res2));
    }

    static int solution(List<Node>[] list, int N, int start, int end) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.node == end)
                break; // 목적지 도달하면 그만 (우선순위 큐기 때문에 제일 짧은 거리가 됨)

            if (visited[cur.node])
                continue;
            visited[cur.node] = true;

            for (Node next : list[cur.node]) {
                if (!visited[next.node] && dist[next.node] > cur.cost + next.cost) {
                    dist[next.node] = cur.cost + next.cost;
                    q.add(new Node(next.node, dist[next.node]));
                }
            }
        }

        return dist[end];
    }

}
