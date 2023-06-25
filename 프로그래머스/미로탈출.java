package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

class 미로탈출 {

    static int N, M, answer;
    static int[][] S, E, L;
    static char[][] board;

    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        answer = 0;
        S = new int[1][2];
        E = new int[1][2];
        L = new int[1][2];
        board = new char[N][M];

        // 시작점, 레버, 도착점 저장
        // 시작점 => 레버
        // 레버 => 도착점
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(maps[i].charAt(j) == 'S') {
                    S[0][0] = i;
                    S[0][1] = j;
                }
                if(maps[i].charAt(j) == 'E') {
                    E[0][0] = i;
                    E[0][1] = j;
                }
                if(maps[i].charAt(j) == 'L') {
                    L[0][0] = i;
                    L[0][1] = j;
                }
                board[i][j] = maps[i].charAt(j);
            }

        }
        // for(int i = 0; i < N; i++) {
        //     for(int j = 0; j < M; j++) {
        //         System.out.print(board[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        go(board, S[0][0], S[0][1], 'L');
        if(answer == 0) return -1;

        go(board, L[0][0], L[0][1], 'E');
        // System.out.println(answer);

        return answer;
    }

    static void go(char[][] maps, int row, int col, char D) {
        int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
        boolean[][] check = new boolean[N][M];
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(row, col, 0));
        check[row][col] = true;


        while(!q.isEmpty()) {
            Point cur = q.poll();

            int r = cur.r, c = cur.c, n = cur.n;

            if(maps[r][c] == D) {
                answer += n;
                break;
            }

            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];

                // X이거나, 미로 밖이면 패쓰
                if(nr < 0 || nc < 0 || nr >= N || nc >= M
                        || maps[nr][nc] == 'X'
                        || check[nr][nc]) continue;

                check[nr][nc] = true;
                q.add(new Point(nr, nc, n+1));
            }
        }

        if(D == 'E' && !check[E[0][0]][E[0][1]]) answer = -1;

    }

    static class Point {
        int r, c, n;
        public Point(int r, int c, int n) {
            this.r = r;
            this.c = c;
            this.n = n;
        }
    }
}
