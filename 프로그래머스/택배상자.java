package 프로그래머스;

import java.util.*;

class 택배상자 {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        
        int n = 1;
        for(int box:order) {
            if(n > box) {
                if(st.pop() != box) break;
                else answer++;
            } else {
                while(box != n) {
                    st.push(n++);
                }
                n++;
                answer++;
            }
        }
        return answer;
    }
}