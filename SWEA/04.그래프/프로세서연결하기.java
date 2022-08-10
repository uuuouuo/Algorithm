import java.util.*;
import java.io.*;

public class 프로세서연결하기 {

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
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            N = Integer.parseInt(br.readLine());
            List<Point> core = new ArrayList<>();
            int[][] board = new int[N][N];

            totalCore = 0;
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    board[r][c] = Integer.parseInt(st.nextToken());
                    if (board[r][c] == 1)
                        totalCore++;
                    if (r == 0 || c == 0 || r == N - 1
                            || c == N - 1 || board[r][c] != 1)
                        continue;
                    core.add(new Point(r, c));
                }
            }

            max = 0;
            answer = Integer.MAX_VALUE;
            dfs(0, 0, 0, core, board);

            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }

    static int N, max, answer, totalCore;

    private static void dfs(int idx, int coreCnt, int length, List<Point> list, int board[][]) {
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        if ((totalCore - idx + 1 + coreCnt) < max)
            return;

        // 모든 코어 다 돌았다면 계산
        if (idx == list.size()) {
            if (coreCnt > max) {
                max = coreCnt;
                answer = length;
            } else if (coreCnt == max
                    && answer > length)
                answer = length;
            return;
        }

        Point cur = list.get(idx);
        int r = cur.r, c = cur.c;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d], nc = c + dc[d];
            int cnt = 0;

            while (true) {
                // 끝까지 도달
                if (!isOk(nr, nc, N)) {

                    // 전선 설치
                    while (true) {
                        nr -= dr[d];
                        nc -= dc[d];

                        if (nr == r && nc == c)
                            break;
                        board[nr][nc] = 2;
                    }

                    // 다음 코어로
                    dfs(idx + 1, coreCnt + 1, length + cnt, list, board);

                    // 전선 빼기
                    while (true) {
                        nr += dr[d];
                        nc += dc[d];

                        if (!isOk(nr, nc, N))
                            break;
                        board[nr][nc] = 0;
                    }

                    break;
                }

                // 설치할 수 없다면
                if (board[nr][nc] != 0) {
                    // 다음 코어로
                    dfs(idx + 1, coreCnt, length, list, board);
                    break;
                }

                cnt++; // 전선 길이 추가
                nr += dr[d];
                nc += dc[d];
            }
        }

    }

    static boolean isOk(int r, int c, int N) {
        if (r < 0 || c < 0 || r >= N || c >= N)
            return false;
        return true;
    }

}
