package 프로그래머스;

import java.util.*;

class Solution {
    static class Info {
        int r, c, n;

        public Info(int r, int c, int n) {
            this.r = r;
            this.c = c;
            this.n = n;
        }
    }

    static int num, max, map[][], N, M;
    static Queue<Info> q;

    public int[] solution(int m, int n, int[][] picture) {
        num = 0;
        max = 0;
        map = new int[m][n];
        N = m;
        M = n;

        clone(picture);

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 0)
                    continue;
                q = new LinkedList<>();
                q.add(new Info(r, c, map[r][c]));
                map[r][c] = 0;
                go();
            }
        }
        int[] answer = new int[2];
        answer[0] = num;
        answer[1] = max;
        return answer;
    }

    // 상하좌우 같은 숫자의 영역이 있을때 큐에 넣기 -> 영역
    // 넣으면 0으로 변환
    // while문 끝나면 영역++ & max
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

    static void go() {
        int size = 0;
        while (!q.isEmpty()) {
            Info cur = q.poll();
            int r = cur.r, c = cur.c, n = cur.n;
            size++;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (isOk(nr, nc) && map[nr][nc] == n) {
                    q.add(new Info(nr, nc, n));
                    map[nr][nc] = 0;
                }
            }
        }
        num++;
        if (max < size)
            max = size;

    }

    static boolean isOk(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= M)
            return false;
        return true;
    }

    static void clone(int[][] picture) {
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.copyOf(picture[i], M);
        }
    }
}