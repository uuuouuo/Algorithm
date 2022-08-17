package 프로그래머스;

import java.util.*;

class JadenCase문자열만들기 {
    public String solution(String s) {

        String answer = "";

        String[] words = s.split(" ");

        for (String w : words) {
            if (w.equals("")) {
                answer += " ";
            } else {
                answer += String.valueOf(w.charAt(0)).toUpperCase()
                        + w.substring(1).toLowerCase() + " ";
            }

        }

        answer = answer.trim();
        if (s.substring(s.length() - 1).equals(" "))
            answer += " ";

        return answer;
    }
}