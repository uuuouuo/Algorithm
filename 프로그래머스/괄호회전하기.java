package 프로그래머스;

import java.util.*;
class 괄호회전하기 {
    public int solution(String s) {
        int answer = 0;
        // 회전 방법: substring
        for(int i = 0; i < s.length(); i++) {
            if(i != 0) {
                String head = s.substring(1);
                String tail = s.substring(0,1);
                s = head + tail;
            }

            // 검사 방법: stack
            if(check(s)) answer++;
        }
        return answer;
    }
    
    static boolean check(String str) {
        Stack st = new Stack<>();
        String[] s = str.split("");
        for(int i = 0; i < s.length; i++) {
            String cur = s[i];
            if(st.empty()) {
                st.push(cur);
                continue;
            }
            if(cur.equals(")")) {
                if(!"(".equals(st.peek())) return false;
                else st.pop();
            }
            else if(cur.equals("]")) {
                if(!"[".equals(st.peek())) return false;
                else st.pop();
            }
            else if(cur.equals("}")) {
                if(!"{".equals(st.peek())) return false;
                else st.pop();
            }       
            else st.push(cur);
        }
        if(!st.empty()) return false;
        return true;
    }
}