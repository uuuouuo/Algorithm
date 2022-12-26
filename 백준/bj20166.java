package 백준;

import java.io.*;
import java.util.*;

public class bj20166 { // 문자열 지옥에 빠진 호석

    static int N, M, K, cnt;
    static char copyMap[][];
    static StringTokenizer st;
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행 길이
        M = Integer.parseInt(st.nextToken()); // 열 길이
        K = Integer.parseInt(st.nextToken()); // 만들어야하는 문자열 개수

        char[][] map = new char[N][M]; // 주어진 격자판
        copyMap = new char[N+2][M+2]; // 확장된 격자판 => 8방향 검사할 때 편리하게 하기위해 사전 작업

        // 초기 격자판 생성
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int c = 0; c < M; c++) {
                map[r][c] = str.charAt(c);
                copyMap[r+1][c+1] = str.charAt(c);
            }
        }

        // 확장된 격자판 생성
        for (int r = 0; r < N+2; r++) {
            for (int c = 0; c < M+2; c++) {
                // 각 꼭지점일 때
                if((r==0 && c==0) || (r==0 && c==M+1) || (r==N+1 && c==M+1) || (r==N+1 && c==0))
                    copyMap[r][c] = copyMap[Math.abs(r-N)][Math.abs(c-M)];
                // 테두리 중 상하일 때
                else if(r == 0 || r == N+1)
                    copyMap[r][c] = copyMap[Math.abs(r-N)][c];
                // 테두리 중 좌우일 때
                else if(c == 0 || c == M+1)
                    copyMap[r][c] = copyMap[r][Math.abs(c-M)];
            }
        }
        System.out.println();
        for (int r = 0; r < N+2; r++) {
            for (int c = 0; c < M+2; c++) {
                System.out.print(copyMap[r][c]+" ");
            }
            System.out.println();
        }

        for (int i = 0; i < K; i++) {
            String str = br.readLine();
            cnt = 0; // 해당 문자열 만들 수 있는 개수
            for (int r = 1; r < N+1; r++) {
                for (int c = 1; c < M+1; c++) {
//                    System.out.println(r+" "+c);
                    if(str.charAt(0) == copyMap[r][c])
                        solution(str, r, c);
//                System.out.print(copyMap[r][c] + " ");
                }
//            System.out.println();
            }
            System.out.println(cnt);
        }

    }

    private static void solution(String str, int row, int col) { // str: 만들어야하는 문자열, row: 시작 행 위치, col: 시작 열위치
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0}, dc = {-1, 0, 1, 1, 1, 0, -1, -1};
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row, col, copyMap[row][col]+""));

        while(!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r, c = cur.c;
            String s = cur.s;
//            System.out.println(r+" "+c+" "+s);
            if(s == str) {
                cnt++;
                continue;
            }
            for (int d = 0; d < 8; d++) {
                int nr = r+dr[d], nc = c+dc[d];
//                System.out.println(nr+" "+nc);
                if(nr<0 || nc<0 || nr>=N+2 || nc>=M+2) continue;
                if(str.charAt(s.length()) == copyMap[nr][nc])
                    q.add(new Point(nr, nc, str.substring(0, s.length()+1)));
            }

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
