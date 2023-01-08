package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20167_2 {

    static int N, K, foods[], answer;
    public static void main(String[] args) throws IOException {
        input();
        go(0, 0, 0);
        print();
    }

    private static void print() {
        System.out.println(answer);
    }

    /**
     * 완전탐색 - 모든 경우의 수로 구하기
     *
     * @param idx : foods[]의 인덱스
     * @param fSum : 현재까지 먹은 먹이의 만족도 합
     * @param eSum : 현재까지 얻은 탈피 에너지
     */
    private static void go(int idx, int fSum, int eSum) {
        // foods[] 마지막 인덱스까지 왔다면
        // 이전 탈피에너지(answer)보다 현재 탈피에너지(eSum)가 더 크면 갱신
        if(idx == N) {
            if(answer < eSum) answer = eSum;
            return;
        }

        // 1. 현재 먹이를 먹지 않고 그냥 지나가는 경우
            // 먹이 만족도는 0이 됨
        go(idx+1, 0, eSum);
        // 2. 현재 먹이를 먹어도 최소 만족도보다 작은 경우
            // 먹이 만족도 증가
            // 탈피 에너지는 그대로
        if(K > fSum + foods[idx]) go(idx+1, fSum+foods[idx], eSum);
        // 3. 현재 먹이를 먹으면 최소 만족도보다 큰 경우
            // 먹이 만족도는 0이 됨
            // K보다 큰 만큼 탈피에너지가 됨
        else go(idx+1, 0, eSum+((fSum+foods[idx]) - K));

        return;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        foods = new int[N];
        answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            foods[i] = Integer.parseInt(st.nextToken());
        }
    }

}
