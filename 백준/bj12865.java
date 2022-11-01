package 백준;

import java.io.*;
import java.util.*;

public class bj12865 { // 평범한배낭

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] W = new int[n + 1];
        int[] V = new int[n + 1];
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][k + 1]; // n개의 물건, 수용 가능한 최대 무게 k
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= k; w++) {
                // 만약 해당 물건의 무게가 최대 무게보다 클 때
                if (W[i] > w)
                    dp[i][w] = dp[i - 1][w]; // 전 값과 동일
                else
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - W[i]] + V[i]);
            }
        }

        System.out.println(dp[n][k]);
    }

}
