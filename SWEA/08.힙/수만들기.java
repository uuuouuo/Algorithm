import java.io.*;
import java.util.*;

public class 수만들기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int K = Integer.parseInt(br.readLine());

            solution(arr, N, K, sb);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void solution(int[] arr, int N, int K, StringBuilder sb) {
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        q.add(new Node(0, K)); // cnt, left

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int cnt = cur.cnt, left = cur.left;
            if (left == 0) {
                sb.append(cnt);
                break;
            }

            // System.out.println("cnt: "+cnt+" left: "+left);
            q.add(new Node(cnt + left, 0));

            for (int i = 0; i < N; i++) {
                q.add(new Node(cnt + left % arr[i], left / arr[i]));
            }
        }

    }

    static class Node implements Comparable<Node> {
        int cnt, left;

        public Node(int cnt, int left) {
            this.cnt = cnt;
            this.left = left;
        }

        public int compareTo(Node n) {
            return this.cnt - n.cnt;
        }
    }

}
