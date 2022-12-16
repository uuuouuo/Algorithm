package 프로그래머스;

class 피보나치수 {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (2 > i)
                arr[i] = i % 1234567;
            else
                arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }
        answer = arr[n];
        return answer;
    }
}