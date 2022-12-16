package 프로그래머스;

// 0 1 2 3 4 5 6 7 8 9 10
class 방문길이 {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] check = new boolean[11][11][4];
        int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
        int n = dirs.length();
        int r = 5, c = 5, d = 0;
        for (int i = 0; i < n; i++) {
            char cur = dirs.charAt(i);
            System.out.println(cur);
            if (cur == 'U')
                d = 0;
            else if (cur == 'R')
                d = 1;
            else if (cur == 'D')
                d = 2;
            else if (cur == 'L')
                d = 3;

            int nr = r + dr[d], nc = c + dc[d];
            // System.out.println(nr+" "+nc);
            if (!isOk(nr, nc))
                continue;
            if (!check[nr][nc][d]) {
                // System.out.println(nr+" "+nc);
                answer++;
                check[nr][nc][d] = true;
                d = (d % 2 == 0) ? 2 - d : 4 - d;
                check[r][c][d] = true;
            }
            r = nr;
            c = nc;
        }
        return answer;
    }

    static boolean isOk(int r, int c) {
        if (r < 0 || c < 0 || r >= 11 || c >= 11)
            return false;
        return true;
    }

}