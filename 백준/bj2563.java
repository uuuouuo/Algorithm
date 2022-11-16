package 백준;

import java.io.*;
import java.util.*;

public class bj2563 { // 색종이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        answer = 0;
        int[][] map = new int[100][100];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            solution(map, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(answer);
    }

    static int answer;

    static void solution(int[][] map, int c, int r) {
        for (int i = r; i < r + 10; i++) {
            for (int j = c; j < c + 10; j++) {
                if (map[i][j] == 1)
                    continue;
                map[i][j] = 1;
                answer++;
            }
        }
    }

}
