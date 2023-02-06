package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj14425 {

    static int N, M;
    static Set<String> set;

    public static void main(String[]args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        String str;
        int answer = 0;

        for (int i = 0; i < M; i++) {
            str = br.readLine();

            if(set.contains(str)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
