import java.io.*;
import java.util.*;

public class K번째문자열 {
    // 부분 문자열 -> 접미사배열, lcp배열(중복제거)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            int k = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int size = str.length();

            // 접미어 저장
            // 접미어의 길이 = 해당 접미어의 부분집합 개수
            String[] suffix = new String[size];
            for (int i = 0; i < size; i++) {
                suffix[i] = str.substring(i);
            }
            Arrays.sort(suffix);

            // LCP 구하기
            // LCP = 중복 길이
            int[] LCP = new int[size];
            for (int i = 1; i < size; i++) {
                LCP[i] = getLCP(suffix[i - 1], suffix[i]);
            }

            // K번째 부분집합 찾기
            int cnt = 0;
            for (int i = 0; i < size; i++) {
                cnt += suffix[i].length() - LCP[i]; // 중복 제거위해 빼줌

                if (cnt > k) { // k번째를 넘기면
                    String answer = suffix[i].substring(0, suffix[i].length() - (cnt - k));
                    sb.append(answer + "\n");
                    break;
                }
            }
            if (cnt < k)
                sb.append("none" + "\n");
        }
        System.out.println(sb);
    }

    static int getLCP(String str1, String str2) {
        int l = Math.min(str1.length(), str2.length());
        int cnt = 0;

        for (int i = 0; i < l; i++) {
            if (str1.charAt(i) != str2.charAt(i))
                break;
            cnt++;
        }
        return cnt;
    }
}
