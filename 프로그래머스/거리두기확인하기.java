import java.util.*;

class Solution {

    static Queue<Point> q;

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            q = new LinkedList<>();
            if (check(toArray(places[i])))
                answer[i] = 1;
        }
        return answer;
    }

    // 거리가 안된다고 다 안되는게 아님!
    static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 }; // 파티션이 있는지 없는지 확인먼저
    static int[][] dr2 = { { -1, -2, -1 }, { -1, 0, 1 }, { 1, 2, 1 }, { -1, 0, 1 } }; // 이후 해당 위치 주변에 사람있는지 체크
    static int[][] dc2 = { { -1, 0, 1 }, { 1, 2, 1 }, { -1, 0, 1 }, { -1, -2, -1 } };

    static boolean check(char[][] arr) {
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r, c = cur.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (!isOk(nr, nc))
                    continue;
                if (arr[nr][nc] == 'P')
                    return false;
                if (arr[nr][nc] == 'O') {
                    for (int j = 0; j < 3; j++) {
                        nr = r + dr2[i][j];
                        nc = c + dc2[i][j];
                        if (!isOk(nr, nc))
                            continue;
                        if (arr[nr][nc] == 'P')
                            return false;
                    }
                }
                // System.out.print(arr[nr][nc]+" ");
            }
            // System.out.println();
        }
        return true;
    }

    static boolean isOk(int r, int c) {
        if (r < 0 || c < 0 || r >= 5 || c >= 5)
            return false;
        return true;
    }

    static char[][] toArray(String[] arr) {
        char[][] result = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result[i][j] = arr[i].charAt(j);
                if (result[i][j] == 'P')
                    q.add(new Point(i, j));
                // System.out.print(result[i][j]+" ");
            }
            // System.out.println();
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