package 프로그래머스;

class 양궁대회 {
    static int[] result;

    public int[] solution(int n, int[] info) {

        result = new int[11];
        ryan = new int[11];
        max = 0;
        go(n, info, 0, 0);

        if (max == 0)
            return new int[] { -1 };
        return result;
    }

    static int[] ryan;

    static void go(int n, int[] info, int start, int cnt) {
        if (cnt == n) {
            // 비교해서 점수 구하기
            getScore(info, ryan);
            return;
        }

        // 중복 조합
        for (int i = start; i < 11; i++) {
            ryan[i]++;
            go(n, info, i, cnt + 1); // 중복가능하므로 index 그대로
            ryan[i]--;
        }
    }

    static int max;

    static void getScore(int[] info, int[] ryan) {
        int a = 0, r = 0;

        // info[i] ryan[i] 화살 개수 비교
        for (int i = 0; i < 11; i++) {
            int score = 10 - i;

            if (info[i] == 0 && ryan[i] == 0)
                continue;
            if (info[i] < ryan[i])
                r += score;
            else
                a += score;
        }

        if (a < r)
            getMax(r - a, ryan);
    }

    static void getMax(int gap, int[] ryan) {
        if (max < gap) {
            max = gap;
            result = ryan.clone();
        }

        if (max == gap)
            check(ryan);
    }

    static void check(int[] ryan) {
        for (int i = 10; i >= 1; i--) {
            if (ryan[i] == 0 && result[i] == 0
                    || ryan[i] == result[i])
                continue;
            if (ryan[i] > result[i]) {
                result = ryan.clone();
                break;
            } else
                break;
        }
    }

}