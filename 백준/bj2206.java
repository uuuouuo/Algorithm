package 백준;

import java.io.*;
import java.util.*;

// 그래프 탐색 문제
public class bj2206 { // 벽부수고 이동하기
    // 최단경로, 못가면 -1 !!!!
    // 벽을 뚫지 않은 상황/ 뚫은 상황 나눠서 생각해야 함
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // 들어간 값이 이상해서 삽질함.. 항상 확인하기
        // for(int i=0; i<n; i++) {
        // for (int j = 0; j < m; j++) {
        // System.out.print(map[i][j] + " ");
        // }
        // System.out.println();
        // }

        int MAX = 1000000000;
        answer = MAX;
        solution(map, n, m, new boolean[n][m][2]);
        if (answer == MAX)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    static class Point {
        int r, c, cnt;
        boolean isOk;

        public Point(int r, int c, int cnt, boolean isOk) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.isOk = isOk;
        }
    }

    static void solution(int[][] map, int n, int m, boolean[][][] check) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1, true));
        check[0][0][0] = true;
        check[0][0][1] = true;

        int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r, c = cur.c, cnt = cur.cnt;
            boolean isOk = cur.isOk;

            if (r == n - 1 && c == m - 1) {
                if (answer > cnt)
                    answer = cnt;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m)
                    continue;

                if (map[nr][nc] == 1 && isOk && !check[nr][nc][1]) {
                    check[nr][nc][1] = true;
                    q.add(new Point(nr, nc, cnt + 1, false));
                } else if (map[nr][nc] == 0 && isOk && !check[nr][nc][0]) {
                    check[nr][nc][0] = true;
                    q.add(new Point(nr, nc, cnt + 1, true));
                } else if (map[nr][nc] == 0 && !isOk && !check[nr][nc][1]) {
                    check[nr][nc][1] = true;
                    q.add(new Point(nr, nc, cnt + 1, false));
                }

            }
        }
    }

}
