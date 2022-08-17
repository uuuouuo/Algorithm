package 프로그래머스;

import java.util.*;

class 피로도 {
    static class Info {
        int min, usage;

        public Info(int min, int usage) {
            this.min = min;
            this.usage = usage;
        }
    }

    static List<Info> list;
    static int answer, N;

    public int solution(int k, int[][] dungeons) {
        // 1. k보다 같거나 작은 던전 찾기
        list = new ArrayList<>();
        selectDG(k, dungeons);

        // 2. 순열 돌리기
        answer = 0;
        N = list.size();
        result = new Info[N];
        visited = new boolean[N];
        go(k, dungeons, 0);
        return answer;
    }

    static Info[] result;
    static boolean[] visited;

    static void go(int k, int[][] dungeons, int idx) {
        if (idx == N) {
            int cnt = getAns(k);
            if (cnt > answer)
                answer = cnt;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                result[idx] = list.get(i);

                visited[i] = true;
                go(k, dungeons, idx + 1);
                visited[i] = false;
            }
        }
    }

    static int getAns(int k) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (result[i].min > k)
                continue;
            k -= result[i].usage;
            if (k < 0)
                break;
            cnt++;
        }
        return cnt;
    }

    static void selectDG(int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++)
            if (dungeons[i][0] <= k)
                list.add(new Info(dungeons[i][0], dungeons[i][1]));
    }
}