package 프로그래머스;

class 괄호변환 {
    public String solution(String p) {
        String answer = "";

        // 1. 올바른 괄호 문자열 체크
        if (isOk(p))
            return p;
        // 2. 균형잡힌 괄호 문자열 u, v 나누기
        answer = split(p);

        return answer;
    }

    // 올바른 괄호 문자열 체크 함수
    static boolean isOk(String p) {
        // 항상 맨앞은 ( 로 시작되야 함
        if (p.charAt(0) == ')')
            return false;

        int open = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(')
                open++;
            else
                open--;

            // 음수가 되면 짝이 안맞는 다는 것
            if (open < 0)
                return false;
        }

        return true;
    }

    // u, v 나누는 함수
    static String split(String p) {
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        if (p.length() == 0)
            return "";

        int open = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(')
                open++;
            else
                open--;

            // 0이 되었을 때 균형잡힌 괄호 문자열임
            if (open == 0) {
                u.append(p.substring(0, i + 1));
                v.append(p.substring(i + 1));

                // u 올바른 괄호 문자열인지 체크
                if (isOk(u.toString())) {
                    // v 재귀호출 후 이어붙임
                    u.append(split(v.toString()));
                } else {
                    StringBuilder str = new StringBuilder();
                    str.append("(");
                    str.append(split(v.toString()));
                    str.append(")");
                    str.append(reverse(u.toString()));

                    return str.toString();
                }
                break;
            }
        }
        return u.toString();
    }

    static String reverse(String str) {

        StringBuilder s = new StringBuilder();
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '(')
                s.append(")");
            else
                s.append("(");
        }
        return s.toString();
    }
}