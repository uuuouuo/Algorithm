import java.io.*;
import java.util.*;

public class 문자열교집합 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 배열1
            int M = Integer.parseInt(st.nextToken()); // 배열2

            int answer = 0;
            // 검색 속도가 훨씬 빠름
            HashSet<String> set = new HashSet<>();
            // List<String> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String cur = st.nextToken();
                set.add(cur);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                String cur = st.nextToken();

                if (set.contains(cur))
                    answer++;
                else
                    set.add(cur);
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }

}
