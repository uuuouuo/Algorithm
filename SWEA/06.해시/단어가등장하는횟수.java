import java.io.*;

public class 단어가등장하는횟수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            String content = br.readLine();
            String word = br.readLine();
            int n = content.length();
            int m = word.length();

            int[] pi = new int[m];
            int answer = 0;
            int idx = 0; // 일치한 글자 수

            for (int i = 1; i < m; i++) {
                // 맞는 위치가 나올 때까지 idx - 1칸의 공통 부분 위치로 이동
                while (idx > 0 && word.charAt(i) != word.charAt(idx))
                    idx = pi[idx - 1];

                // 맞을 경우 i 길이 문자열의 공통 길이는 idx위치 +1
                if (word.charAt(i) == word.charAt(idx)) {
                    idx += 1;
                    pi[i] = idx;
                }
            }

            idx = 0;
            for (int i = 0; i < n; i++) {
                // 맞는 위치가 나올 때까지 j - 1칸의 공통 부분 위치로 이동
                while (idx > 0 && content.charAt(i) != word.charAt(idx)) {
                    idx = pi[idx - 1];
                }
                // 맞는 경우
                if (content.charAt(i) == word.charAt(idx)) {
                    if (idx == m - 1) {
                        answer++;
                        idx = pi[idx];
                    }
                    // 맞았지만 패턴이 끝나지 않았다면 idx를 하나 증가
                    else
                        idx++;
                }
            }

            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }

}
