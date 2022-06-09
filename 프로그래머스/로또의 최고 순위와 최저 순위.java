import java.util.*;

class Solution {
    static int ranking[], cnt, zero;

    public int[] solution(int[] lottos, int[] win_nums) {
        cnt = 0;
        zero = 0;
        int[] answer = new int[2];
        ranking = new int[7];

        setRanking();
        get(lottos, win_nums);

        if (zero == 0) // 지워진 곳 없으면
            return new int[] { ranking[cnt], ranking[cnt] };
        if (zero == 6) // 모두 지워졌으면
            return new int[] { 1, 6 };

        answer[1] = ranking[cnt]; // 최저 : 맞춘 개수
        answer[0] = ranking[cnt + zero]; // 최고 : 맞춘 개수 + 지워진 개수(0)

        return answer;
    }

    static void setRanking() {
        for (int i = 1; i < 7; i++)
            ranking[i] = 7 - i;
        ranking[0] = 6;
    }

    static void get(int[] lottos, int[] win_nums) {
        for (int l : lottos) {
            if (l == 0)
                zero++; // 0 개수 세기
            for (int n : win_nums)
                if (l == n)
                    cnt++; // 맞춘 숫자 개수 세기
        }
    }
}
