import java.io.*;
import java.util.*;

public class 보급로 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int size = str.length();
                for (int j = 0; j < size; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            boolean[][] check = new boolean[N][N];
            bfs(sb, map, check, N);
        }
        System.out.println(sb);
    }

    static class Point implements Comparable<Point> {
        int r, c, time;

        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }

        public int compareTo(Point p) {
            return this.time - p.time;
        }
    }

    static void bfs(StringBuilder sb, int[][] map, boolean[][] check, int N) {
        int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, -1, 1 };
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(0, 0, map[0][0]));
        check[0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r, c = cur.c, time = cur.time;

            if (r == N - 1 && c == N - 1) {
                sb.append(time + "\n");
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (!isOk(nr, nc, N) || check[nr][nc])
                    continue;

                int ntime = time + map[nr][nc];
                check[nr][nc] = true;
                q.add(new Point(nr, nc, ntime));
            }
        }
    }

    static boolean isOk(int r, int c, int N) {
        if (r < 0 || c < 0 || r >= N || c >= N)
            return false;
        return true;
    }
}
