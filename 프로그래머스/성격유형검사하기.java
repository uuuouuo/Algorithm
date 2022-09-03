import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String[] type = { "R", "T", "C", "F", "J", "M", "A", "N" };
        int[] score = new int[8];
        HashMap<String, Integer> map = new HashMap<>();// 지표별 숫자 부여
        setting(map, type);

        // 점수
        // 4보다 크면 뒤 문자
        // 4보다 작으면 앞 문자
        // 점수 : 절댓값 (4 - 해당 점수)
        int n = survey.length;
        for (int i = 0; i < n; i++) {
            // System.out.println(survey[i].charAt(0));
            int cur = choices[i];
            if (cur < 4)
                score[map.get(survey[i].charAt(0) + "")] += 4 - cur;
            else if (cur > 4)
                score[map.get(survey[i].charAt(1) + "")] += cur - 4;
        }

        for (int i = 0; i < 8; i += 2) {
            // System.out.println(score[i]+" "+score[i+1]);
            if (score[i] < score[i + 1])
                answer += type[i + 1];
            else
                answer += type[i];
        }
        return answer;
    }

    static void setting(HashMap<String, Integer> map, String[] type) {
        for (int i = 0; i < 8; i++)
            map.put(type[i], i);
    }

}