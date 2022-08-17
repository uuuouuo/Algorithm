package 프로그래머스;

import java.util.*;

class Solution {
    static int[] one = { 1, 2, 3, 4, 5 };
    static int[] two = { 2, 1, 2, 3, 2, 4, 2, 5 };
    static int[] three = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

    public List<Integer> solution(int[] answers) {
        int[] result = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (one[i % one.length] == answers[i])
                result[0]++;
            if (two[i % two.length] == answers[i])
                result[1]++;
            if (three[i % three.length] == answers[i])
                result[2]++;
        }

        int max = 0;
        for (int r : result)
            max = Math.max(r, max);

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            if (max == result[i])
                answer.add(i + 1);

        return answer;
    }
}