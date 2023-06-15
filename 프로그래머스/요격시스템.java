package 프로그래머스;

import java.util.Arrays;

public class 요격시스템 {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]); // 끝나는 지점 오름차순

        int cur = -1;
        for(int[] t : targets) {
            // 맨 첫번째일 때 요격
            if(cur == -1) {
                cur = t[1] - 1;
                answer++;
                continue;
            }

            if(t[0] <= cur && t[1] >= cur){
                continue;
            }

            cur = t[1] -1;
            answer++;
        }

        return answer;
    }

}
