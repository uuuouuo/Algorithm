
public class SWEA_기초BFS연습 {

    private int N;
    private int[][] arr;

    void bfs_init(int map_size, int map[][]) {
        N = map_size;
        arr = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                arr[r][c] = map[r][c];
            }
        }
    }

    int bfs(int x1, int y1, int x2, int y2) {
        int result = -1;

        boolean[][] check = new boolean[N][N];
        Point[] queue = new Point[N * N];
        int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

        int start = -1, end = -1;
        queue[++end] = new Point(y1 - 1, x1 - 1, 0);
        while (start != end) {
            Point cur = queue[++start];
            int r = cur.r, c = cur.c, cnt = cur.cnt;
            if (r == y2 - 1 && c == x2 - 1) {
                result = cnt;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (!isOk(nr, nc) || check[nr][nc] || arr[nr][nc] == 1)
                    continue;
                check[nr][nc] = true;
                queue[++end] = new Point(nr, nc, cnt + 1);
            }

        }
        return result;
    }

    private boolean isOk(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= N)
            return false;
        return true;
    }

    private class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
