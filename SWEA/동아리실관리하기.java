import java.io.*;

public class 동아리실관리하기 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String input = br.readLine();
            int N = input.length();

            dp = new int[N][16];
            for (int i = 0; i < N; i++) { // 동아리 활동일 수 N
                int next = 1 << input.charAt(i) - 'A';

                if (i == 0)
                    secondDay(next, input);
                else
                    otherDays(next, i, input);
            }
            System.out.println("#" + t + " " + solution(N - 1));
        }
    }

    private static int solution(int N) {
        int answer = 0;
        for (int i = 1; i < 16; i++) {
            if (dp[N][i] != 0) {
                answer += dp[N][i];
                answer %= 1000000007;
            }
        }
        return answer;
    }

    private static void otherDays(int next, int cur, String input) {
        for (int i = 1; i < 16; i++) { // 어제 참여한 사람들의 부분 집합
            int pre = cur - 1;
            if (dp[pre][i] == 0)
                continue; // 이전 경우에 해당하지않았다면 패스
            for (int j = 1; j < 16; j++) { // 당일 참여한 사람들의 부분 집합 찾기
                // 전날 경우의 수 비트(i) && 다음 책임자(next) 포함하고 있는지 확인
                if ((i & j) != 0 && (next & j) != 0) {
                    dp[cur][j] += dp[pre][i];
                    dp[cur][j] %= 1000000007;
                }
            }
        }
    }

    private static void secondDay(int next, String input) {
        // 첫날에는 A가 열쇠를 갖고 있음 + 그다음 책임자
        for (int i = 1; i < 16; i++) {
            // 다음 책임자(next) && 첫날 책임자 A가 포함하고 있는지 확인
            if ((i & next) != 0 && (i & 1) != 0)
                dp[0][i] = 1;
        }
    }

}