package 백준;

import java.io.*;
import java.util.*;

public class bj3085 { // 상근이가 먹을 수 있는 사탕의 최대 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String candy = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = candy.charAt(j);
            }
        }
        check(map, n);
        // 오른쪽, 아래 다른지 확인 >> 다른면 체인지
        // 맨 마지막 행은 확인 x
        // 연속하는 행 or 열 확인 >>>>>>> 줄에서 다른색이 나오면 다시 개수 확인해야하는데 끝내버려서 삽질
        // n이 최대라면 끝
        answer = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                solution(map, n, i, j);
            }
        }

        System.out.println(answer);
    }

    static void solution(char[][] map, int n, int r, int c) {
        int[] dr = { 0, 1 }, dc = { 1, 0 };
        for (int d = 0; d < 2; d++) {
            int nr = r + dr[d], nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= n || nc >= n)
                continue;
            if (map[r][c] != map[nr][nc])
                change(map, n, r, c, nr, nc);
            if (answer == n)
                break;
        }
    }

    static void change(char[][] map, int n, int r, int c, int nr, int nc) {
        char[][] tmp = new char[n][n];
        for (int i = 0; i < n; i++)
            tmp[i] = Arrays.copyOf(map[i], n);

        tmp[r][c] = map[nr][nc];
        tmp[nr][nc] = map[r][c];

        check(tmp, n);
    }

    static int answer;

    static void check(char[][] tmp, int n) {
        for (int i = 0; i < n; i++) {
            // 00 01 02 03
            // 10 11 12 13
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (tmp[i][j] != tmp[i][j + 1]) {
                    if (answer < cnt)
                        answer = cnt;
                    cnt = 1;
                } else
                    cnt++;
            }
            if (answer < cnt)
                answer = cnt;
            if (answer == n)
                return;
        }

        for (int i = 0; i < n; i++) {
            // 00 01
            // 10 11
            // 20 21
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (tmp[j][i] != tmp[j + 1][i]) {
                    if (answer < cnt)
                        answer = cnt;
                    cnt = 1;
                } else
                    cnt++;
            }
            if (answer < cnt)
                answer = cnt;
            if (answer == n)
                return;
        }
    }

}
