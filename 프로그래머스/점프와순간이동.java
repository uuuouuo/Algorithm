package 프로그래머스;

public class 점프와순간이동 {
    public int solution(int n) {
        int ans = 0;

        int cnt = 0;
        while (n > 0) {
            if (n % 2 == 0)
                n /= 2;
            else {
                n -= 1;
                ans++;
            }
        }
        return ans;
    }
}