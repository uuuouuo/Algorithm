package 백준;

import java.util.*;

public class bj1012 {

    static int N, M, K, map[][], answer;
    static Queue<Point> q;

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            map = new int[M][N];
            q = new LinkedList<>();
            for (int i = 0; i < K; i++) {
                int row = sc.nextInt();
                int col = sc.nextInt();
                map[row][col] = 1;
            }

            answer = 0;
            for (int r = 0; r < M; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == 1)
                        go(r, c);
                }
            }
            System.out.println(answer);
        }
    }

    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

    private static void go(int row, int col) {
        q.add(new Point(row, col));
        while (!q.isEmpty()) {
            Point cul = q.poll();
            int r = cul.r, c = cul.c;

            if (map[r][c] == 0)
                continue;
            map[r][c] = 0;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (!isOk(nr, nc) || map[nr][nc] == 0)
                    continue;
                q.add(new Point(nr, nc));
            }
        }
        answer++;
    }

    private static boolean isOk(int r, int c) {
        if (r < 0 || c < 0 || r >= M || c >= N)
            return false;
        return true;
    }

}