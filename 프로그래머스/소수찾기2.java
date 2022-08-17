package 프로그래머스;

class Solution {
    static int answer;

    public int solution(int n) {
        answer = 0;

        for (int i = 2; i <= n; i++)
            if (isPrime(i))
                answer++;
        return answer;
    }

    static boolean isPrime(int n) {
        if (n == 2)
            return true;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
}