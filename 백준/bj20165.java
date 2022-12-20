package 백준;

import java.io.*;
import java.util.*;

public class bj20165 { // 인내의 도미노 장인 호석

    static class Point {
    int r, c;
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
    static int N, M, R, map[][]; // N: 행, M: 열, R: 라운드 수, map: 도미노 판
    static Map<String, Integer> dis; // 동서남북 문자열 저장
    static boolean[][] checked;
    static StringTokenizer st;
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dis = new HashMap<>();
        checked = new boolean[N][M];
        int answer = 0;

        init();

        for (int i = 0; i < R*2; i++) {
            st = new StringTokenizer(br.readLine());

            // 공격수 차례 -> 0, 2, 4.. 순이므로 짝수일 때
            if(i%2 == 0) answer += attack(Integer.parseInt(st.nextToken())-1
                    , Integer.parseInt(st.nextToken())-1
                    , dis.get(st.nextToken()));
            // 수비수 차례 -> 홀수일 때
            else defence(Integer.parseInt(st.nextToken())-1
                    , Integer.parseInt(st.nextToken())-1);
        }
        System.out.println(answer);
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(checked[r][c]) System.out.print("F ");
                else System.out.print("S ");
            }
            System.out.println();
        }
    }

    static int[] dr = {0, 0, 1, -1} // dr: 동서남북 순으로 행 이동 위치
            , dc = {1, -1, 0, 0}; // dc: 동서남북 순으로 열 이동 위치
    private static int attack(int row, int col, int d) {
        if(checked[row][col]) return 0; // 이미 쓰러진 도미노라면 return

        int result = 0; // 쓰러트린 도미노 개수
        Queue<Point> q = new LinkedList<>(); // q: 쓰러트릴 수 있는 도미노 담는 역할

        q.add(new Point(row, col)); // 맨처음 쓰러트릴 도미노 담기
        checked[row][col] = true; // 쓰러트렸다는 표시

        // 더이상 쓰러트릴 수 있는 도미노가 없을 때까지 진행
        while(!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r, c = cur.c; // 현재 쓰러트릴 도미노 위치
            result++; // 쓰러트린 도미노 수 카운트

            for (int i = 1; i < map[r][c]; i++) { // 해당 도미노가 쓰러트릴 수 있는 개수만큼
                int nr = r+(dr[d]*i), nc = c+(dc[d]*i);

                // 도미노판 범위 밖으로 나가면 그만
                if(nr<0 || nc<0 || nr>=N || nc>=M) break;
                // 쓰러지지 않은 도미노라면 q에 담고 쓰러트렸다는 표시
                if(!checked[nr][nc]) {
                    checked[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }
        }
        return result;
    }

    // (r, c) 위치에 있는 도미노가 쓰러져있다면 세우는 함수
    private static void defence(int r, int c) {
        if(checked[r][c]) checked[r][c] = false;
    }

    // 도미노 판, 동서남북 방향 세팅 함수
    private static void init() throws IOException {
        // 도미노 판 입력
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 동서남북 배열 원소 위치 저장
        dis.put("E", 0);
        dis.put("W", 1);
        dis.put("S", 2);
        dis.put("N", 3);
    }
}

/**
 * N, M: 100
 * R: 10000
 */