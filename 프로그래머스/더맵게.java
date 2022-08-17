package 프로그래머스;

import java.util.*;
class Solution {
    // 스코빌 지수가 가장 낮은 두 개의 음식 섞기
    // 우선순이 큐 -> 오름차순으로 정렬해줘서 작은 수 먼저 꺼낼 수 있음
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville)
            pq.add(s);
        
        while(pq.peek() < K) {
            if(pq.size() == 1) return -1;
            int tmp1 = pq.poll();
            int tmp2 = pq.poll();
            
            int ntmp = tmp1 + tmp2*2;
            pq.add(ntmp);
            answer++;
        }
        return answer;
    }
}