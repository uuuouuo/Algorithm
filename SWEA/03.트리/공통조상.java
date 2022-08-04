import java.io.*;
import java.util.*;

public class 공통조상 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()) + 1;
            int E = Integer.parseInt(st.nextToken());
            int[] node = new int[2];
            node[0] = Integer.parseInt(st.nextToken());
            node[1] = Integer.parseInt(st.nextToken());

            List<Integer>[] list = new ArrayList[V];
            for (int i = 1; i < V; i++) {
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                list[from].add(to);
                list[to].add(to);
            }

            boolean[] check = new boolean[V]; // 공통 조상 체크용
            boolean[] visited; // 방문 체크용

            for (int i = 0; i < 2; i++) {
                visited = new boolean[V];
                solution(sb, node[i], check, visited, list, V);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static void getSize(StringBuilder sb, List<Integer>[] list, int result, int N) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.add(result);
        visited[result] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            int size = list[cur].size();
            for (int i = 0; i < size; i++) {
                int next = list[cur].get(i);
                if (visited[next])
                    continue;
                visited[next] = true;
                q.add(next);
            }
        }
        sb.append(cnt);
    }

    static void solution(StringBuilder sb, int node, boolean[] check, boolean[] visited, List<Integer>[] list, int N) {
        visited[node] = true;
        check[node] = true;

        for (int i = 1; i < N; i++) {
            if (visited[i])
                continue;
            int size = list[i].size();
            for (int j = 0; j < size; j++) {
                if (list[i].get(j) == node) {
                    if (check[i]) {
                        sb.append(i + " ");
                        getSize(sb, list, i, N);
                        return;
                    }
                    solution(sb, i, check, visited, list, N);
                }
            }
        }
    }

}
