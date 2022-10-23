package 백준;

import java.io.*;
import java.util.*;
import java.util.List;

public class bj15686 {
    // 구현할 때 출력해야하는 것 잘보고, 로직 글로 먼저 작성하고 짜기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        List<Point> houses = new ArrayList<>();
        List<Point> chickens = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    houses.add(new Point(i, j));
                if (map[i][j] == 2)
                    chickens.add(new Point(i, j));
            }
        }

        int c = chickens.size();
        int h = houses.size();
        int[][] dis = new int[c][h];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < h; j++) {
                dis[i][j] = Math.abs(chickens.get(i).r - houses.get(j).r)
                        + Math.abs(chickens.get(i).c - houses.get(j).c);
            }
        }

        answer = 987654321;
        solution(dis, c, m, 0, 0, new int[m]);
        System.out.println(answer);
    }

    static int answer;

    static void solution(int[][] dis, int n, int m, int idx, int start, int[] result) {

        if (idx == m) {
            int sum = 0;
            for (int i = 0; i < dis[0].length; i++) {
                int min = 987654321;
                for (int j = 0; j < m; j++) {
                    if (dis[result[j]][i] < min)
                        min = dis[result[j]][i];
                }
                sum += min;
            }

            if (answer > sum)
                answer = sum;
            return;
        }

        for (int i = start; i < n; i++) {
            result[idx] = i;
            solution(dis, n, m, idx + 1, i + 1, result);
        }
    }

    static class Point {
        int r, c, cnt;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }
}
