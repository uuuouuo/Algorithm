package 프로그래머스;

import java.util.*;

class 롤케이크자르기 {
    public int solution(int[] topping) {        
        int answer = 0; // 토핑 종류가 같게 되는 모든 경우의 수
        Map<Integer, Integer> bro = new HashMap<>();
    
        for(int i=0; i<topping.length; i++) {
            int cur = topping[i];
            if(!bro.containsKey(cur))
                bro.put(cur, 1);
            else bro.put(cur, bro.get(cur)+1);
        }
        
        // 슬라이딩 윈도우 !!!
        int idx = 0;
        Map<Integer, Integer> me = new HashMap<>();
        while(idx <= topping.length-1) {
            int cur = topping[idx];
            int curN = bro.get(cur)-1;

            if(curN == 0) bro.remove(cur); // 동생 토핑 -1
            else bro.put(cur, curN);
            
            if(!me.containsKey(cur)) me.put(cur, 1);
            else me.put(cur, me.get(cur)+1);
            
            if(me.size() == bro.size()) answer++;
            
            idx++;
        }
        return answer;
    }
}