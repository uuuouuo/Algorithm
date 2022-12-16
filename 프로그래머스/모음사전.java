package 프로그래머스;

class 모음사전 {
    static int ans;
    static boolean isOk;
    static String[] str = { "A", "E", "I", "O", "U" };
    static StringBuilder sb;

    public int solution(String word) {
        ans = 0;
        isOk = false;
        StringBuilder sb = new StringBuilder();
        go(sb, word, 0);
        return ans;
    }

    // 중복순열
    static void go(StringBuilder sb, String word, int idx) {
        if (sb.toString().equals(word)) {
            isOk = true;
            return;
        }
        if (sb.length() == 5)
            return;

        for (int i = 0; i < 5; i++) {
            sb.append(str[i]);
            go(sb, word, idx + 1);
            ans++;
            if (isOk)
                return;
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}