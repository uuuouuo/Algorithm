package 프로그래머스;

class Solution {
    // 이걸보고 어떻게 DP라는 걸 알죠?..
    // n = 1 -> 1, (1)
    // n = 2 -> 2, (1, 1) (2) 
    // n = 3 -> 3, (1, 1, 1) (1, 2) (2, 1)
    // n = 4 -> 5, (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (2, 1, 1) (2, 2)
    // n = 5 -> 8, (1, 1, 1, 1, 1) (1, 1, 1, 2) (1, 1, 2, 1) (1, 2, 1, 1,) (2, 1, 1, 1) (1, 2, 2) (2, 1, 2) (2, 2, 1)
    // 피보나치수
    public long solution(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i < n + 1; i++) {
            if(i == 1) dp[i] = 1;
            else if(i == 2) dp[i] = 2;
            else dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
            // System.out.println(i + " " + (dp[i] % 1234567));
        }
        return dp[n];
    }
}