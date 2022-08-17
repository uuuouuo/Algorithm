package 프로그래머스;

import java.util.*;
class Solution {
    static int N, M;
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        return go(maps);
    }
    
    static class Info {
        int r, c, cnt;
        public Info(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int go(int[][] maps) {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, 0, 1));
        maps[0][0] = 0;
        
        while(!q.isEmpty()) {
            Info cur = q.poll();
            int r = cur.r, c = cur.c, cnt = cur.cnt;

            if(r == N-1 && c == M-1) return cnt;
            
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(!isOk(nr, nc) || maps[nr][nc] == 0)
                    continue;
                q.add(new Info(nr, nc, cnt + 1));
                maps[nr][nc] = 0;
                
            }
        }
        
        return -1;
    }
    
    static boolean isOk(int r, int c) {
        if(r < 0 || c < 0 || r >= N || c >= M)
            return false;
        return true;
    }
}