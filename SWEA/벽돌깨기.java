package SWEA;

import java.util.*;

public class 벽돌깨기 {

    // r, c, 벽돌에 적힌 숫자, 남은 제거 숫자(벽돌 숫자 - 1)
    static class Info {
        int r, c, n;

        public Info(int r, int c, int n) {
            this.r = r;
            this.c = c;
            this.n = n;
        }
    }

    static int N, W, H, map[][], tmp[][], result[], answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            W = sc.nextInt();
            H = sc.nextInt();

            map = new int[H][W];
            for (int r = 0; r < H; r++) {
                for (int c = 0; c < W; c++) {
                    map[r][c] = sc.nextInt();
                }
            }
            result = new int[N];
            answer = Integer.MAX_VALUE;
            go(0);
            System.out.println("#" + t + " " + answer);
        }

    }

    // 최대한 많은 벽돌을 깨트리는 방법 -> 중복순열
    static void go(int idx) {
        if (idx == N) {
            q = new LinkedList<>();
            tmp = cloneMap();
            l: for (int c : result) {
                for (int r = 0; r < H; r++) {
                    int n = tmp[r][c];
                    if (n != 0) {
                        q.add(new Info(r, c, n));
                        breakBric(r, c);
                        downBric();
                        continue l;
                    }
                }
            }
            answer = Math.min(answer, getAns());
            return;
        }

        for (int i = 0; i < W; i++) {
            result[idx] = i;
            go(idx + 1);
        }
    }

    static int[][] cloneMap() {
        int[][] tmp = new int[H][W];
        for (int i = 0; i < H; i++)
            System.arraycopy(map[i], 0, tmp[i], 0, W);
        return tmp;
    }

    static Queue<Info> q;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

    static void breakBric(int row, int col) {
        // row 내려가면서 0아닌부분 찾기
        while (!q.isEmpty()) {
            Info cul = q.poll();
            int r = cul.r, c = cul.c, num = cul.n;
            if (tmp[r][c] != 0) {
                tmp[r][c] = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    for (int n = 0; n < num - 1; n++) {
                        // map 범위 안이거나 0이 아니면
                        if (isOk(nr, nc) && tmp[nr][nc] != 0)
                            q.add(new Info(nr, nc, tmp[nr][nc]));
                        nr += dr[d];
                        nc += dc[d];
                    }
                }
            }
        }
    }

    static boolean isOk(int nr, int nc) {
        if (nr < 0 || nc < 0 || nr >= H || nc >= W)
            return false;
        return true;
    }

    static void downBric() {
        Queue<Integer> q;
        for (int c = 0; c < W; c++) {
            q = new LinkedList<>();
            for (int r = H - 1; r >= 0; r--) {
                if (tmp[r][c] != 0) {
                    q.add(tmp[r][c]);
                    tmp[r][c] = 0;
                }
            }
            int row = H - 1;
            while (!q.isEmpty()) {
                tmp[row--][c] = q.poll();
            }
        }
    }

    static int getAns() {
        int cnt = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (tmp[r][c] != 0)
                    cnt++;
            }
        }
        return cnt;
    }
}
