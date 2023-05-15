package 프로그래머스;

public class 덧칠하기 {

    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int cur = 0;

        for(int idx : section) {
            if(cur > n) break; // 범위 초과 시
            if(idx < cur) continue; // 이미 지나갔으면

            cur = idx + m; 
            answer++;
        }

        return answer;
    }

}
