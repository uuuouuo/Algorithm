import java.util.*;
class Solution {
    static int days[], N;
    static List<Integer> answer;
    public List<Integer> solution(int[] progresses, int[] speeds) {
        N = progresses.length;        
        days = new int[N];
        answer = new ArrayList<>();
        
        // 1. 각각의 기능 작업일 구하기
        getDays(progresses, speeds);
        // 2. 배포 순서대로 배포날짜 파악
        getAns();
        
        return answer;
    }
    
    static void getAns() {
        int idx = 0;
        while(idx < N) {
            int cnt = 1;
            answer.add(1);
            
            if(idx == N - 1) break;   
            
            for(int i = idx + 1; i < N; i++) {
                if(days[idx] < days[i]) break;
                
                int val = answer.get(answer.size() - 1);
                answer.set(answer.size() - 1, val += 1); 
                cnt++;  
            }
            idx += cnt;            
        }
    }
    
    static void getDays(int[] P, int[] S) {
        
        for(int i = 0; i < N; i++) {
            int p = P[i];
            int cnt = 0;
            while(p < 100) {
                p += S[i];
                cnt++;
            }
            days[i] = cnt;
        }
    }
}