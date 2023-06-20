package 프로그래머스;

import java.util.Stack;

/// Stack 문제 ///
public class 햄버거만들기 {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < ingredient.length; i++) {
            st.push(ingredient[i]);

            if(st.size() >= 4
                    && st.get(st.size()-1) == 1
                    && st.get(st.size()-2) == 3
                    && st.get(st.size()-3) == 2
                    && st.get(st.size()-4) == 1) {
                answer++;
                st.pop(); st.pop(); st.pop(); st.pop();
            }

        }
        return answer;
    }
}
