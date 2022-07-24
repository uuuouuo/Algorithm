import java.io.*;
import java.util.*;

public class 최장공통부분수열 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            int N = str1.length();
            int M = str2.length();
            int[][] dp = new int[N + 1][M + 1];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    // 같으면 대각선 값을 참고
                    if (str1.charAt(i - 1) == str2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    // 다르면 이전 문자 중 최대값 선택
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            sb.append(dp[N][M] + "\n");
        }
        System.out.println(sb);

    }

}
