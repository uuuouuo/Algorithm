import java.util.*;

class Solution {
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