package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20167_2 {

    static int N, K, A[], E[];
    public static void main(String[] args) throws IOException {
        input();

    }

    private static void go(int idx, int sum) {
        if(N == idx) return; // 끝까지 오면 그만

        if(K > sum+A[idx]) go(idx+1, sum+(K-A[idx]))

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N+1];
        E = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

}
