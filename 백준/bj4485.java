package 백준;

import java.io.*;
import java.util.*;

public class bj4485 { // 녹색옷입은애가젤다지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;

            int[][] map = new int[n][n];
            int[][] dijk = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dijk[i][j] = Integer.MAX_VALUE;
                }
            }

            solution(map, dijk, n);
            System.out.println("Problem " + cnt + ": " + dijk[n - 1][n - 1]);
            cnt++;
        }
    }

    static class Point {
        int r, c, cost;

        public Point(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }

    static void solution(int[][] map, int[][] dijk, int n) {
        int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
        PriorityQueue<Point> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        q.add(new Point(0, 0, map[0][0]));
        dijk[0][0] = map[0][0];
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r, c = cur.c, cost = cur.cost;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n)
                    continue;
                if (dijk[nr][nc] > cost + map[nr][nc]) {
                    dijk[nr][nc] = cost + map[nr][nc];
                    q.add(new Point(nr, nc, dijk[nr][nc]));
                }
            }
        }
    }
}
