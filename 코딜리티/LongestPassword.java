package 코딜리티;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class LongestPassword {
    public int solution(String S) {
        int answer = -1;
        String[] arr = S.split(" ");
        for (int i = 0; i < arr.length; i++) {
            int l = arr[i].length();
            String cur = arr[i].replaceAll("[a-zA-Z]", "");
            if ((l - cur.length()) % 2 != 0 || cur.length() == 0)
                continue; // 문자열 짝수 아니면, 문자열만 있다면

            l = cur.length();
            cur = cur.replaceAll("[0-9]", "");
            if (cur.length() != 0 || (l - cur.length()) % 2 != 1)
                continue; // 숫자 외 문자있다면, 숫자 홀수 아니라면
            else if (answer < arr[i].length())
                answer = arr[i].length();
        }
        return answer;

    }
}
