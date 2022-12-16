package 프로그래머스;

class 혼자놀기의달인 {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] check;

        for (int i = 0; i < cards.length; i++) {
            check = new boolean[cards.length];
            int box1 = go(cards, check, i); // 1번 상자 그룹 개수
            boolean[] clone;
            for (int j = 0; j < cards.length; j++) {
                clone = check.clone();
                if (!check[j]) {
                    int res = box1 * go(cards, clone, j); // box1 개수 * box2 개수
                    if (res > answer)
                        answer = res;
                }
            }
        }
        return answer;
    }

    static int go(int[] cards, boolean[] check, int n) { // 상자 열어보기
        int cnt = 0; // 열어본 상자 개수
        while (!check[n]) {
            check[n] = true;
            n = cards[n] - 1;
            cnt++;
        }
        return cnt;
    }
}