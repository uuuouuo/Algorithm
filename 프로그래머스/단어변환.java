package 프로그래머스;

class 단어변환 {
    static int answer;

    public int solution(String begin, String target, String[] words) {

        answer = 51;
        go(begin, target, words, new boolean[words.length], 0);

        if (answer == 51)
            return 0;
        return answer;
    }

    static void go(String begin, String target, String[] words, boolean[] visited, int cnt) {
        if (cnt >= answer)
            return; // 가지치기
        if (begin.equals(target)) {
            answer = cnt;
            System.out.println(answer);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            // 이미 사용한 알파벳인지 체크 & 한개 알파벳만 다른지 확인
            if (!visited[i] & check(begin, words[i])) {
                visited[i] = true;

                // 조건에 맞으면 재귀
                go(words[i], target, words, visited, cnt + 1);

                // 조건에 맞는 단어가 없어서 백하면 해당 단어 체크 해제
                visited[i] = false;
            }

        }
    }

    static boolean check(String cur, String next) {
        int n = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != next.charAt(i))
                n++;
            if (n > 1)
                return false;
        }
        return true;
    }
}