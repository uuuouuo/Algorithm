package 프로그래머스;

import java.util.PriorityQueue;

public class 디펜스게임 {

// 1. enemy 길이 큼
// 2. 지금까지 뺀 값 중 가장 큰값을 빼기

    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int e : enemy) {
            n -= e;
            q.add(e);

            if(n < 0) {
                if(!q.isEmpty() && k > 0) {
                    n += q.poll();
                    k--;
                }
                else break;
            }
            answer++;
        }
        return answer;
    }

}
