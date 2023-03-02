package 코딩테스트._2023상반기;

public class SKP3 {
    static int N, M, answer[];
    // static boolean[][] check;
    public static int[] solution(String[][] boards) {
        N = boards.length;
        answer = new int[N];

        for(int t=0; t<N; t++) { // 한 맵
            M = boards[t].length;
            int[][] map = new int[M][M];
            answer[t] = 0;

            int startR = 0, startC = 0;

            for(int i=0; i<M; i++) {// 한 문자열
                for(int j=0; j<M; j++) {
                    map[i][j] = boards[t][i].charAt(j)-'0';
                    if(map[i][j] == 2) {
                        startR = i;
                        startC = j;
                    }
                }
            }

            // for(int i=0; i<M; i++) {// 한 문자열
            //     for(int j=0; j<M; j++) {
            //         System.out.print(map[i][j]+" ");
            //     }
            //     System.out.println();
            // }

            // bfs 로 확인

            boolean[][] check = new boolean[M][M];
            check[startR][startC] = true;
            dfs(t, startR, startC, map, check);

        }

        return answer;
    }

    // 0 벽, 1 길, 2 캐릭터
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static void dfs(int T, int row, int col, int[][] map, boolean[][] check) {
        int nr = row, nc = col;
        System.out.println(row+" "+col);
        for(int d=0; d<4; d++) {
            if(nr+dr[d]<0 || nc+dc[d]<0 || nr+dr[d]>=M || nc+dc[d]>=M
                    ||map[nr+dr[d]][nc+dc[d]] == 0 || check[nr+dr[d]][nc+dc[d]]) continue;
            while(true) {
                nr += dr[d];
                nc += dc[d];
                System.out.println("nr+\" \"+nc  "+nr+" "+nc);
                if(nr<0 || nc<0 || nr>=M || nc>=M || map[nr][nc] == 0 || check[nr][nc]) break;// 범위 밖, 벽이라면, 이미 심었다면
                check[nr][nc] = true;
            }

            dfs(T, nr-dr[d], nc-dc[d], map, check); // 해당 위치에서 4가지 방향 살펴보러

        }

        // 현재 위치에도 심기

        // 다 막혔다면
        for(int i=0; i<M; i++) {// 한 문자열
            for(int j=0; j<M; j++) {

                if(!check[i][j]) {
                    if(map[i][j] == 1 && map[i][j] == 2) {
                        return;
                    }

                }
                if(check[i][j]) System.out.print(0+" ");
                else System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }System.out.println();

        answer[T] = 1;
    }

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
