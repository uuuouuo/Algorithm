package 백준;

import java.io.*;
import java.util.*;

public class bj20168 { // 골목 대장 호석
    // 한 골목에서 내야하는 최대 요금을 최소화하기

    static int N, M; // N: 교차로 개수, M: 골목 개수
    static int A, B, C; // A: 시작 교차로, B: 도착 교차로, C: 가진 돈
    static int adjArr[][]; // adjArr: 인접 행렬 (연결된 골목 비용 표시)
    static int answer;

    public static void main(String[] args) throws IOException {
        input();
        go(A, 0, C, new boolean[N+1]);
        print();
    }

    private static void print() {
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    /** dfs 를 통해 갈 수 있는 길의 최대 금액 중 최소 금액 찾기
     *
     * @param node 현재 교차로
     * @param max 지금까지 가장 큰 금액
     * @param cost 지불할 수 있는 남은 금액
     * @param check 방문 골목 체크 배열
     */
    // 실수 1. bfs 로 해서 다시 dfs 로 바꾸는데 시간 더 걸림
    private static void go(int node, int max, int cost, boolean[] check) {

        /* 도착 지점에 왔다면, 이 길의 가장 큰 금액(max)이 answer 보다 작으면 갱신 */
        if(node == B) {
            if(answer > max) answer = max;
            return;
        }
        /* 해당 교차로 방문 체크*/
        check[node] = true;

        for (int next = 1; next <= N; next++) {
            /*
            * 갔었던 교차로이거나
            * 연결되어 있지 않은 교차로이거나
            * 남은 금액(cost)이 현재 내야하는 금액(adjArr[node][next])보다 적다면
            * 모두 패스
             */
            if(check[next] || adjArr[node][next] == 0 // 실수 2. &&
                || cost - adjArr[node][next] < 0) continue; // 실수 3. 지정된 비용 체크 안함

            /* 갈 수 있는 교차로(next)의 수금액 빼고 이동 */
            go(next, Math.max(max, adjArr[node][next]), cost - adjArr[node][next], check); // 실수 4. max 값을 노드 번호로 함
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        adjArr = new int[N+1][N+1]; // 실수 5. 비용이 있는데, 인접 리스트로 했음
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjArr[from][to] = adjArr[to][from] = cost;
        }
    }

    static class Point {
        int node, max;
        boolean[] check;

        public Point(int node, int max, boolean[] check) {
            this.node = node;
            this.max = max;
            this.check = check;
        }
    }

}
