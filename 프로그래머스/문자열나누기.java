package 프로그래머스;

public class 문자열나누기 {

    public int solution(String s) {
        int answer = 0;

        char pre = ' ';
        int n = 1, m = 0, cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if(pre == ' ') {
                pre = s.charAt(i);
                n  = 1;
                cnt = 1;
                continue;
            }

            char cur = s.charAt(i);

            if(cur == pre) {
                n++;
            } else {
                m++;
            }

            cnt++;

            if(n == m) {
                answer++;
                pre = ' ';
                n = 0;
                m = 0;
                cnt = 0;
            }
        }

        if(cnt > 0) answer++;

        return answer;
    }

}
