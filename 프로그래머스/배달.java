package 프로그래머스;

class 배달 {
    public int solution(int N, int[][] road, int K) { // N: 마을 개수, K: 최소 시간
        int answer = 0;
        int[][] times = new int[N + 1][N + 1];

        // 무한대로 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    continue;
                times[i][j] = 500001;
            }
        }

        // a, b: 두 마을 c: 시간
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];

            if (times[a][b] < c)
                continue;
            times[a][b] = times[b][a] = c;
        }

        // 플로이드 워셜 알고리즘
        // 노드를 1개부터 N개까지 거쳐가는 경우
        for (int k = 1; k <= N; k++) {
            // k노드를 거쳐 노드 i에서 j로 가는 경우.
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j)
                        continue;
                    // k번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
                    // 또는 연결이 안되어있던 경우(INF) 연결 비용 갱신
                    if (times[i][j] > times[i][k] + times[k][j])
                        times[i][j] = times[i][k] + times[k][j];
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (times[1][i] <= K)
                answer++;
        }
        return answer;
    }

}