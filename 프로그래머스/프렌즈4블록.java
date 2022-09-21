import java.util.*;
class Solution {
    static char[][] b;
    static int answer;
    public int solution(int m, int n, String[] board) {
        b = new char[m][n];
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                b[r][c] = board[r].charAt(c);
            }
        }    
        
        // for(int r = 0; r < m; r++) {
        //     for(int c = 0; c < n; c++) {
        //         System.out.print(b[r][c]);
        //     }
        //         System.out.println();
        // }
        
        answer = 0;
        play(m, n);
        
        return answer;
    }
    
    static void play(int m, int n) {
        int[] dr = {0, 1, 1, 0}, dc = {1, 1, 0, 0};
        
        while(true) {
            boolean[][] check = new boolean[m][n];
            boolean ok = false;
            
            l1: for(int c = 0; c < n-1; c++) {
                l2: for(int r = m-2; r >= 0; r--) {
                    // System.out.print(b[r][c]);
                    // System.out.println(r+" "+c);
                    char cur = b[r][c];
                    if(cur == '/') continue l1;
                    
                    for(int d = 0; d < 3; d++) {
                        int nr = r+dr[d], nc = c+dc[d];
                        if(nr >= m || nc >= n || b[nr][nc] == '/' 
                           || b[nr][nc] != cur) continue l2; // 위로 넘어가기
                        // System.out.print(b[nr][nc]);
                    }
                    
                    if(!ok) ok = true;
                    for(int d = 0; d < 4; d++) {
                        int nr = r+dr[d], nc = c+dc[d];
                        // System.out.print(b[nr][nc]);
                        // System.out.print(nr+""+nc+" ");
                        if(check[nr][nc]) continue;
                        check[nr][nc] = true;
                        answer++;
                    }
                    // System.out.println();
                }
                // System.out.println();
            }
            if(!ok) break;
            down(m, n, check);
            // System.out.println();
            // for(int r = 0; r < m; r++) {
            //     for(int c = 0; c < n; c++) {
            //         System.out.print(b[r][c]);
            //     }
            //     System.out.println();
            // }
            // break;
        }    
    }
    
    static void down(int m, int n, boolean[][] check) {
        Queue<Character> q = new LinkedList<>();
        for(int c = 0; c < n; c++) {
            for(int r = m-1; r >= 0; r--) {
                if(!check[r][c]) q.add(b[r][c]);
            }
            
            for(int r = m-1; r >= 0; r--) {
                if(q.isEmpty()) b[r][c] = '/';
                else b[r][c] = q.poll();
            }
        }
    }
}