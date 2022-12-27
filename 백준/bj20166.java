package 백준;

import java.io.*;
import java.util.*;

/**
 * bfs => O(N^2)
 * 최대 개수 N: 100
 */
public class bj20166 { // 문자열 지옥에 빠진 호석

    static int N, M, K; // N: 행 길이, M: 열 길이, K: 좋아하는 문자 개수
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0}, dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    static char board[][]; // board: 격자판
    static Map<String, Integer> map; // map: 좋아하는 문자(key)의 생성 개수(value)
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        input();
        go();
    }

    private static void go() {

        // bfs 통해 board 의 문자마다 좋아하는 문자 만들 수 있는지 확인
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                bfs(r, c);
            }
        }

        sb = new StringBuilder();

        map.forEach((k, v) -> {
            sb.append(v+"\n");
        });

        System.out.println(sb.toString());
    }

    private static void bfs(int row, int col) {
        Queue<Point> q =  new LinkedList<>();

        q.add(new Point(row, col, board[row][col]+""));

        while(!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r, c = cur.c; // 현재 위치 (r, c)
            String s = cur.s; // 현재 만들어진 문자열 s

            if(map.containsKey(s)) map.put(s, map.get(s)+1);
            if(s.length() >= 5) continue;

            // 8방향으로 이동했을 때
            for (int d = 0; d < 8; d++) {
                int nr = (r+dr[d]) % N, nc = (c+dc[d]) % M;

                if(nr < 0) nr += N;
                if(nc < 0) nc += M;

//                // 격자판의 꼭지점일 때
//                if((nr==-1 && nc==-1) || (nr==-1 && nc==M) || (nr==N && nc==M) || (nr==N && nc==-1)) {
//                    nr = Math.abs(r-N+1);
//                    nc = Math.abs(c-M+1);
//                }
//                // 테두리 중 상하일 때
//                else if(nr == -1 || nr == N) {
//                    nr = Math.abs(r-N+1);
//                }
//                // 테두리 중 좌우일 때
//                else if(nc == -1 || nc == M) {
//                    nc = Math.abs(c-M+1);
//                }

                q.add(new Point(nr, nc, s+board[nr][nc]));
            }
        }
    }

    private static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        map = new HashMap<>();

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int c = 0; c < M; c++) {
                board[r][c] = str.charAt(c);
            }
        }

        for (int i = 0; i < K; i++) {
            map.put(br.readLine(), 0);
        }
    }

    static class Point {
        int r, c;
        String s;

        public Point(int r, int c, String s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

}
