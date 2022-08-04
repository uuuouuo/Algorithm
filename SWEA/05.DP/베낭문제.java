import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 베낭문제 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] weight = new int[N + 1];
            int[] cost = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                weight[i] = Integer.parseInt(st.nextToken());
                cost[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N + 1][K + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= K; j++) {
                    if (weight[i] > j)
                        dp[i][j] = dp[i - 1][j];
                    else
                        dp[i][j] = Math.max(dp[i - 1][j],
                                dp[i - 1][j - weight[i]] + cost[i]);
                }
            }

            sb.append(dp[N][K] + "\n");
        }
        System.out.println(sb);

    }

}
