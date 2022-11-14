package 백준;

import java.io.*;
import java.util.*;

public class bj14728 { // 벼락치기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 단원개수
        int T = Integer.parseInt(st.nextToken()); // 공부시간

        int[] dp = new int[T + 1];
        dp[0] = 0;

        int time, score;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time = Integer.parseInt(st.nextToken());
            score = Integer.parseInt(st.nextToken());
            for (int j = T; j >= time; j--) { // 최대라서 이렇게 하나?
                dp[j] = Math.max(dp[j], dp[j - time] + score);
            }
        }

        int answer = 0;
        for (int i = 0; i <= T; i++) {
            if (answer < dp[i])
                answer = dp[i];
        }
        System.out.println(answer);
    }
}
