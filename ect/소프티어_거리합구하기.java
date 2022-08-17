

import java.util.*;

public class 소프티어_거리합구하기 {

    static class Info {
        int from, sum;

        public Info(int from, int sum) {
            this.from = from;
            this.sum = sum;
        }
    }

    static class Node {
        int to, t;

        public Node(int to, int t) {
            this.to = to;
            this.t = t;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Node> list[] = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int to = sc.nextInt();
            int from = sc.nextInt();
            int t = sc.nextInt();
            list[to].add(new Node(from, t));
            list[from].add(new Node(to, t));
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                System.out.println(i + "->" + list[i].get(j).to + " : " + list[i].get(j).t);
            }
        }

        for (int i = 1; i <= N; i++) {
            ans = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    continue;

                q = new LinkedList<>();
                boolean[] visited = new boolean[N + 1];

                q.add(new Info(i, 0));
                bfs(list, visited, N, j);

            }
            System.out.println(ans);
        }

    }

    static int ans;
    static Queue<Info> q;

    static void bfs(List<Node> list[], boolean[] visited, int N, int end) {
        while (!q.isEmpty()) {
            Info cur = q.poll();
            int from = cur.from;
            int sum = cur.sum;
            visited[from] = true;

            if (from == end) {
                ans += sum;
                return;
            }

            for (int i = 0; i < list[from].size(); i++) {
                Node node = list[from].get(i);
                if (visited[node.to])
                    continue;

                q.add(new Info(node.to, sum + node.t));
            }
        }
    }

}