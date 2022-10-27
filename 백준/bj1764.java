package 백준;

import java.io.*;
import java.util.*;

public class bj1764 { // 듣보잡

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if (!set.contains(name))
                set.add(name);
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (set.contains(name))
                answer.add(name);
        }
        Collections.sort(answer);

        // 수 + 사전순으로 출력하라!!!! 요구하는 정답 제발 적어놔
        System.out.println(answer.size());
        for (String name : answer)
            System.out.println(name);
    }
}
