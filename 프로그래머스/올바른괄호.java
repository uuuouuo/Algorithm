package 프로그래머스;

class 올바른괄호 {
    boolean solution(String s) {
        int n = s.length();
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                tmp++;
            else
                tmp--;

            if (tmp < 0)
                break;
        }

        if (tmp == 0)
            return true;
        else
            return false;
    }
}
