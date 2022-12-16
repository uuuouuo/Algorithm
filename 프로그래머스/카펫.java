package 프로그래머스;

class 카펫 {
    // 12 -> 1, 2, 3, 4, 6, 12
    public int[] solution(int brown, int yellow) {
        int[] ans = new int[2];
        int n = brown + yellow;
        for (int i = 1; i < n / 2; i++) {
            if (n % i == 0 && check(brown, yellow, n / i, i)) {
                ans[0] = i;
                ans[1] = n / i;
            }
        }
        return ans;
    }

    static boolean check(int brown, int yellow, int r, int c) {
        int b = r * 2 + (c - 2) * 2;
        int y = r * c - b;

        if (b == brown && y == yellow)
            return true;
        return false;
    }
}