package 백준;

import java.io.*;
import java.util.*;

// 최단 거리 문제
// 모든 경우를 돌지만, (이미 갔었던 지점은 안가도록)-> 핵심
public class bj1697 {

    static int N, K, check[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈의 현재위치
        K = Integer.parseInt(st.nextToken()); // 동생의 현재위치
        check = new int[100001]; // 범위: 0 ~ 100000

        if(N == K) System.out.println(0);
        else go();

    }

    private static void go() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N); // 수빈이 지점에서 시작
        check[N] = 1; // 곱하는 경우도 있으므로 1부터 시작

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                // 세가지 경우 모두 확인
                if(i == 0) {
                    next = cur + 1;
                } else if(i == 1) {
                    next = cur - 1;
                } else {
                    next = cur * 2;
                }

                // 다음 지점이 동생 지점이라면, 1부터 시작했으므로 현재지점 출력
                if(next == K) {
                    System.out.println(check[cur]);
                    return;
                }

                // 배열 범위안에 있으면서, 방문하지 않았던 곳이라면
                if(next >= 0 && next < 100001 && check[next] == 0) {
                    check[next] = check[cur] + 1; // 다음 지점에 시간 저장
                    q.add(next);
                }
            }

        }

    }


}
