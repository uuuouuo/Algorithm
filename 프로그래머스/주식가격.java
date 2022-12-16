package 프로그래머스;

import java.util.*;

class 주식가격 {
    public int[] solution(int[] prices) {
        
        int n = prices.length;
        Queue<Integer> q = new LinkedList<>();
        int[] answer = new int[n];
        
        for(int p : prices) {
            q.add(p);
        }
        
        int idx = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            int cnt = 0;
            
            for(int i = idx; i < n; i++) {                
                answer[idx - 1]++;
                if(cur > prices[i]) break;
            }    
            idx++;
        }
        
        return answer;
    }
}