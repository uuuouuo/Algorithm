package 프로그래머스;
class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        for (int i = 0; i < count; i++)
            answer += price * (i + 1);

        if (answer - money <= 0)
            return 0;
        return Math.abs(answer - money);
    }
}
