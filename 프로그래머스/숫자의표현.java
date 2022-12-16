package 프로그래머스;

class 숫자의표현 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum > n)
                    break;
                if (sum == n)
                    answer++;
            }
        }
        return answer;
    }
}