package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 공원산책 {

    static String[][] map;
    static Map<String, Integer> dis;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static int pos[], N, M;

    public int[] solution(String[] park, String[] routes) {
        N = park.length;
        M = park[0].length();

        init(park);
        process(routes);

        return pos;
    }

    // 공원 String[][] 생성, 방향 map 생성
    static void init (String[] P) {
        map = new String[N][M];
        pos = new int[2];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                String s = String.valueOf(P[i].charAt(j));
                map[i][j] = s;

                if(s.equals("S")) {
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }

        dis = new HashMap<>();
        String[] d = {"N", "E", "S", "W"};
        for(int i = 0; i < 4; i++) {
            dis.put(d[i], i);
        }
    }

    // routes 돌면서 해당 위치 갈 수 있는지 확인
    static void process(String[] R) {
        l: for(int i = 0; i < R.length; i++) {
            String[] s = R[i].split(" ");
            String d = s[0];
            int n = Integer.parseInt(s[1]);

            int nr = pos[0];
            int nc = pos[1];
            for(int j = 0; j < n; j++) { // 해당 자리만 보면 안되고 가는 길에 장애물 있는지 확인해야함
                nr += dr[dis.get(d)];
                nc += dc[dis.get(d)];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc].equals("X")) continue l;

            }

            pos[0] = nr;
            pos[1] = nc;
        }

        }

}
