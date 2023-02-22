package 프로그래머스;

import java.util.*;

public class 무인도여행 {

    // 무인도로 가기
    // 지도 : 직사각형 형태
    // X: 바다, 1~9: 무인도 (숫자는 식량)
    // 식량 더한 수는 최대 머물 수 있는 날짜 수
    // 오름차순으로 섬에서 머물 수 있는 날 담기
    // 무인도 없으면 -1

    static int[][] I;
    public List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        I = new int[maps.length][maps[0].length()];

        // 2차원 배열로 지도 만들기
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                if(maps[i].charAt(j) == 'X') continue;
                I[i][j] = maps[i].charAt(j)-'0';
            }
        }

        // bfs
        for(int i=0; i<I.length; i++) {
            for(int j=0; j<I[i].length; j++) {
                // System.out.print(I[i][j]);
                if(I[i][j] == 0) continue; // 해당 칸이 0이면 확인할 필요 없음

                answer.add(go(i, j)); // 모두 더한 식량 수 저장
            }
            // System.out.println();
        }

        // 만약 list 크기가 0이면 -1 반환
        if(answer.size() == 0) answer.add(-1); // 무인도가 없으면 -1
        else Collections.sort(answer); // 있다면 오름차순 정렬

        return answer;
    }

    static int go(int row, int col) {
        Queue<Point> q = new LinkedList<>();
        int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
        int result = 0;

        q.add(new Point(row, col)); // 시작
        // !!!! 시작할 때도 처리하기 !!!!
        result += I[row][col];
        I[row][col] = 0;

        while(!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r, c = cur.c;

            for(int d = 0; d < 4; d++) {
                int nr = dr[d]+r, nc = dc[d]+c;

                // 범위 밖, 무인도가 아니라면 패쓰
                if(nr< 0 || nc<0 || nr>=I.length || nc>=I[0].length || I[nr][nc] == 0) continue;

                result += I[nr][nc]; // 식량 더하기
                I[nr][nc] = 0; // 방문했으면 0으로 만들기
                q.add(new Point(nr, nc));

            }
        }

        return result;

    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}

