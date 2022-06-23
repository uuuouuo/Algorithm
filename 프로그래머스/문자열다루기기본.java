import java.util.*;

class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        // s 길이 4 or 6
        // 숫자만
        if (s.length() == 4
                || s.length() == 6)
            answer = s.matches("^[0-9]*$");

        return answer;
    }
}