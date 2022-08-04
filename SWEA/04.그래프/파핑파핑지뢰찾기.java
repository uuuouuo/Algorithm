import java.util.*;
import java.io.*;

public class 파핑파핑지뢰찾기 {

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    if (str.substring(j, j + 1).equals("*"))
                        map[i][j] = -1;
                }
            }

            List<Point> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != -1 && isZero(i, j, N, map))
                        list.add(new Point(i, j));
                }
            }

            int click = 0;
            int size = list.size();
            check = new boolean[N][N];
            for (int i = 0; i < size; i++) {
                Point cur = list.get(i);
                int r = cur.r, c = cur.c;
                if (check[r][c])
                    continue;
                solution(r, c, map, check, N);
                click++;

            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (check[i][j] || map[i][j] == -1)
                        continue;
                    click++;
                }
            }
            sb.append(click + "\n");
        }
        System.out.println(sb);
    }

    static boolean[][] check;

    static void solution(int row, int col, int[][] map, boolean[][] check, int N) {
        int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
        int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row, col));
        check[row][col] = true;

        l: while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r, c = cur.c;
            List<Point> tmp = new ArrayList<>();
            for (int d = 0; d < 8; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (!isOk(nr, nc, N) || check[nr][nc])
                    continue;

                if (map[nr][nc] == -1)
                    continue l;
                tmp.add(new Point(nr, nc));
            }
            int size = tmp.size();
            for (int i = 0; i < size; i++) {
                Point p = tmp.get(i);
                check[p.r][p.c] = true;
                q.add(tmp.get(i));
            }
        }
    }

    static boolean isZero(int row, int col, int N, int[][] map) {
        int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
        int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row, col));

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r, c = cur.c;
            for (int d = 0; d < 8; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (!isOk(nr, nc, N))
                    continue;
                if (map[nr][nc] == -1)
                    return false;
            }
        }
        return true;
    }

    static boolean isOk(int r, int c, int N) {
        if (r < 0 || c < 0 || r >= N || c >= N)
            return false;
        return true;
    }

}
