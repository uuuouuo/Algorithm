package 프로그래머스;

import java.util.*;

class 입국심사 { // 파라메터서치 (이분탐색 : O(logN))
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long answer = 0;
        int m = times.length;
        long low = 0, high = (long) n*times[m-1], mid, sum; // 걸리는 시간의 최소, 최대
        while(low <= high) {
            mid = (low+high) / 2;
            sum = 0; // 총 심사한 인원
            for(int i=0; i<m; i++) {
                sum += mid/times[i]; 
            }
            
            if(sum < n) {
                low = mid+1; // 검사해야할 사람보다 적으면 범위 위로
            } else {
                high = mid-1;
                answer = mid;
            }
        }        
        return answer;
    }
}