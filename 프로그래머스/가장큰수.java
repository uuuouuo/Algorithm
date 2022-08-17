package 프로그래머스;

import java.util.*;

class Solution {
    static int N;
    static String[] input;

    public String solution(int[] numbers) {
        String answer = "";
        N = numbers.length;
        input = new String[N];
        toString(numbers);

        Arrays.sort(input, (o1, o2) -> {
            return (o2 + o1).compareTo(o1 + o2); // 더 큰수 반환: 내림차순
        });

        // for(String i : input)
        // System.out.println(i);

        for (String i : input)
            answer += i;
        if (answer.startsWith("0"))
            return "0";
        return answer;
    }

    static void toString(int[] numbers) {
        for (int i = 0; i < N; i++)
            input[i] = String.valueOf(numbers[i]);
    }
}