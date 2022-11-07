package 백준;

import java.io.*;
import java.util.*;

// 처음에 모든 나라는 한번만 돌면서 찾을때마다 1일씩 올리는 이상한 로직 구현
// 1일이 모든 나라를 도는 것이였고, 모든 나라를 돌고 이동이 없다면 끝
public class bj16234 { // 인구이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(map, n, l, r));
    }

    static class Point {
        int r, c, n;

        public Point(int r, int c, int n) {
            this.r = r;
            this.c = c;
            this.n = n;
        }

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int solution(int[][] map, int N, int L, int R) {
        int answer = 0;

        while (true) {
            boolean[][] check = new boolean[N][N];
            boolean isMove = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    List<Point> list = new ArrayList<>();
                    if (!check[i][j]) {
                        int sum = find(map, check, list, N, L, R, i, j);
                        if (sum != 0) {
                            if (!isMove)
                                isMove = true;
                            move(sum, list, map);
                            // print(map, N);

                        }

                    }
                }
            }
            if (!isMove)
                break;
            answer++;
        }

        return answer;
    }

    static int find(int[][] map, boolean[][] check, List<Point> result, int N, int L, int R, int row, int col) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row, col, map[row][col]));
        check[row][col] = true;

        int sum = 0;
        int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r, c = cur.c, n = cur.n;

            sum += map[r][c];
            result.add(new Point(r, c));

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || check[nr][nc])
                    continue;

                int gap = Math.abs(n - map[nr][nc]);
                if (L <= gap && gap <= R) {
                    q.add(new Point(nr, nc, map[nr][nc]));
                    check[nr][nc] = true;
                }
            }
        }

        if (result.size() == 1)
            return 0;
        return sum;

    }

    static void move(int sum, List<Point> result, int[][] map) {
        int num = sum / result.size();
        for (Point p : result) {
            map[p.r][p.c] = num;
        }
    }

    static void print(int[][] map, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
