package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9084 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 동전 가지 수
            Integer[] coins = new Integer[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                coins[i] = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M+1];
            dp[0] = 1; // 0을 만들 수 있는 방법은 1가지

            for (int i = 0; i < N; i++) { // i : 금액
                for (int j = coins[i]; j <= M; j++) { // j : i원
                    dp[j] += dp[j - coins[i]];
                }
            }

            System.out.println(dp[M]);


        }
    }

}
