package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유니온 파인드 문제
public class bj1717 { // 집합의 표현

    // 초기 n+1개 집합 (원소 하나씩) : 1 < n < 1000000
    // 두원소 같은 집합 확인 연산
    // m개 줄 부터
        // 0 a b -> a와 b가 포함된 집합 합친다는 의미
        // 1 a b -> a와 b가 같은 집합에 포함되어 있는지 확인

    static int N, M, P[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = new int[N+1];

        // 해당 원소의 부모 (=자기자신) 초기화
        for (int i = 0; i <= N; i++) {
            P[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        int cmd, a, b;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            cmd = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(cmd == 0) union(a, b);
            else  sb.append((check(a, b) ? "YES" : "NO") + "\n");
        }

        System.out.println(sb.toString());
    }

    private static boolean check(int a, int b) {
        a = find(a);
        b = find(b);

        if(find(a) == find(b)) return true;
        else return false;
    }


    // 집합 합치는 함수
    private static void union(int a, int b) {

        if(a == b) return;

        if(a < b) P[b] = a;
        else P[a] = b;
    }

    // 부모가 같은지 확인 함수
    private static int find(int c) {
        // 부모가 나 자신일 때
        if(P[c] == c) return c;

        // 최상위 부모 찾기
        return P[c] = find(P[c]);
    }



}
