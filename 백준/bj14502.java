package 백준;

import java.util.*;

public class bj14502 {

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, map[][], tmp[][], answer;
    static List<Point> zero, virus;

    public static void main(String[] args) {
        // 바이러스 상하좌우 퍼짐 -> bfs
        // 벽의 개수 3 -> 조합

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        zero = new ArrayList<>();
        virus = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = sc.nextInt();
                if (map[r][c] == 2)
                    virus.add(new Point(r, c));
                if (map[r][c] == 0)
                    zero.add(new Point(r, c));
            }
        }

        result = new Point[3];
        answer = 0;
        solve(0, 0);
        System.out.println(answer);

    }

    static Point[] result;

    static void solve(int start, int idx) {
        if (idx == 3) {
            tmp = cloneMap();
            for (Point res : result)
                tmp[res.r][res.c] = 1;

            go();
            answer = Math.max(answer, getAns());
            return;
        }

        for (int i = start; i < zero.size(); i++) {
            result[idx] = zero.get(i);
            solve(i + 1, idx + 1);
        }
    }

    static int getAns() {
        int cnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (tmp[r][c] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    static int[][] cloneMap() {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < tmp.length; i++)
            tmp[i] = Arrays.copyOf(map[i], map[i].length);
        return tmp;
    }

    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 }; // 상하좌우

    static void go() {

        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < virus.size(); i++) {
            q.add(virus.get(i));
        }

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r, c = cur.c;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];

                if (isOk(nr, nc) && tmp[nr][nc] == 0) {
                    q.add(new Point(nr, nc));
                    tmp[nr][nc] = 2;
                }
            }
        }

    }

    static boolean isOk(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= M)
            return false;
        return true;
    }

}
