class Solution {
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
