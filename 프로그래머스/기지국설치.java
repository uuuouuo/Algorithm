import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int start = 1;
        for(int i=0; i<stations.length; i++) {
            // stations[i]-w: 기지국 범위 앞
            if(start < stations[i]-w) answer += setStations(w*2+1, start, stations[i]-w-1);
            start = stations[i]+w+1; // 시작점은 기지국 범위 뒷부분이 됨
        }
        
        if(start <= n) answer += setStations(w*2+1, start, n);
        return answer;
    }
    
    static int setStations(int n, int start, int end) {
        int result = 0;

        result = (end-start+1)/n; // 구간을 기지국 범위만큼 나눔
        if((end-start+1)%n > 0) result++; // 나머지 있으면 하나 더 설치
        
        return result;
    }
}