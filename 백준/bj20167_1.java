package 백준;

import java.io.*;
import java.util.*;

/**
 * 다이나믹 프로그래밍 방법 (재귀도 가능)
 */
public class bj20167_1 { // 꿈틀꿈틀 호석 애벌레 - 기능성

    static int N, K, A[], E[];
    public static void main(String[] args) throws IOException {
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

        go();

    }

    private static void go() {

        int end = 1, max = 0, sum = 0;

        for (int start = 1; start <= N; start++) { // start: 먹는 구간 시작 위치

            max = Math.max(E[start-1], max); // max : 이전까지의 얻을 수 있는 최대 탈피 에너지

            // 먹는 구간의 끝(end)이 A 배열의 끝 인덱스(N)를 넘지 않으면서,
            // 현재까지의 만족도(sum)가 최소만족도(K)를 넘지 않을 때

            while(end <= N && sum < K) {// end : 먹는 구간 끝 위치
                sum += A[end++]; // sum : 현재까지의 만족도 합
            }

            // 이 시점에서 sum 은 start ~ end-1까지의 만족도 합

            // end-1 위치에서 최대 탈피 에너지( E[end-1] )는
            // 이전까지의 최대 탈피 에너지(max) + 현재 위치에서 얻은 탈피 에너지(sum - K)가 더 크면 갱신
            if(sum >= K) {
                E[end-1] = Math.max(max + (sum - K), E[end - 1]);
            }
            // 끝까지 와도 최소 만족도가 안될 경우
            else break;

            sum -= A[start]; // start 먹이는 이제 안먹으니까 sum 에서 빼기
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if(ans < E[i]) ans = E[i];
        }

        System.out.println(ans);
    }
}
