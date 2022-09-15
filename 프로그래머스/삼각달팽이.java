class Solution {
    public int[] solution(int n) {
        int total = n * (n + 1) / 2;
        int[] answer = new int[total];
        int[][] map = new int[n][n];

        int r = -1, c = 0, num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) { // 아래
                    r++;
                } else if (i % 3 == 1) { // 오른쪽
                    c++;
                } else if (i % 3 == 2) { // 대각선
                    r--;
                    c--;
                }
                map[r][c] = num++;
            }
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[idx++] = map[i][j];
            }
        }
        return answer;
    }
}