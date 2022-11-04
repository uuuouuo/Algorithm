package 백준;

import java.io.*;
import java.util.*;

public class bj1106 { // 호텔

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()); // 추가되어야 하는 사람 수
        int n = Integer.parseInt(st.nextToken()); // 도시 개수

        int INF = 987654321;
        int[] dp = new int[c + 101]; // 최소 c명을 얻어야 하는 거니까 더 많아도 돼
        Arrays.fill(dp, INF);
        dp[0] = 0;

        int cost, client;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cost = Integer.parseInt(st.nextToken());
            client = Integer.parseInt(st.nextToken());

            for (int j = client; j < c + 101; j++) {
                dp[j] = Math.min(dp[j], dp[j - client] + cost);
            }
        }

        int answer = INF;
        for (int i = c; i < c + 101; i++) {
            if (answer > dp[i])
                answer = dp[i];
        }
        System.out.println(answer);
    }
}
