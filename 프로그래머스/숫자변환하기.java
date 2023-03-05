package 프로그래머스;

public class 숫자변환하기 {
    public int solution(int x, int y, int n) {
        int answer = -1;

        int[] dp = new int[y + 1];
        int MAX = Integer.MAX_VALUE;

        for(int i = x+1; i < y+1; i++) {
            int a = MAX, b = MAX, c = MAX, min;

            if(isDivided(i, 3) && isAdoved(i/3, x)) a = dp[i/3];
            if(isDivided(i, 2) && isAdoved(i/2, x)) b = dp[i/2];
            if(isAdoved(i-n, x)) c = dp[i-n];

            min = Math.min(Math.min(a, b), c); // 최소 경우수 구하기

            // 나눌 수 있다면 최소경우 수 저장
            dp[i] = (min < MAX) ? min+1 : MAX;
            // System.out.println(dp[i]);
        }

        if(dp[y] < MAX) answer = dp[y];
        return answer;
    }

    static boolean isDivided(int target, int n) {
        return (target%n == 0) && (target/n > 0);
    }

    static boolean isAdoved(int n, int x) {
        return n >= x;
    }
}
