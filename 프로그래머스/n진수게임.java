package 프로그래머스;

// 문제 대충 봄.. (n의 범위!)
class n진수게임 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int max = t * m; // t * m => 이만큼 길이까지 구하기
        int num = 0;
        while (max > sb.toString().length()) {
            // 10진수 -> n진수
            sb.append(Integer.toString(num++, n));
        }

        String answer = "";
        for (int i = p - 1; i < max; i += m) {
            answer += sb.toString().substring(i, i + 1);
        }
        return answer.toUpperCase();
    }

}