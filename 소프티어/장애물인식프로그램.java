package 소프티어;

import java.io.*;
import java.util.*;

// https://softeer.ai/practice/info.do?idx=1&eid=409
public class 장애물인식프로그램 {

    static int N, map[][];
    static List<Integer> list;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        list = new ArrayList<>(); // 각 블럭 장애물 개수

        int blockN = 0; // 총 블럭 수
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1) {
                    bfs(i, j);
                    blockN++;
                }
            }
        }

        System.out.println(blockN);

        Collections.sort(list); // 오름차순 정렬

        for(int n : list)
            System.out.println(n);
    }

    static void bfs(int row, int col) {
        Queue<Point> q = new LinkedList<>();
        int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

        q.add(new Point(row, col)); // 시작점
        map[row][col] = 0; // 방문 체크

        int cnt = 0; // 블럭 내 장애물 개수
        while(!q.isEmpty()) {
            Point cur = q.poll();
            cnt++; // 장애물 카운트

            // 동서남북 확인
            for(int d=0; d<4; d++) {
                int nr = cur.r + dr[d], nc = cur.c + dc[d];
                // 범위 밖이거나 0이면 패스
                if(nr<0 || nc<0 || nr>=N || nc>=N || map[nr][nc] == 0) continue;


                map[nr][nc] = 0; // 0으로 바꾸기 (방문 체크)
                q.add(new Point(nr, nc)); // q에 담기
            }
        }

        list.add(cnt);
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
