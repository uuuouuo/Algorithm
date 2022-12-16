package 코딩테스트._2022하반기;
import java.util.*;

public class 엔씨소프트2번 {
    // 검은 건반: |2| |4| |6| |9| |11|
    // 흰 건반: | 1| 3 | 5 | 7| 8| 10| 12|
    // 캐릭터는 현재 위치한 건반과 붙어있는 건반으로 이동 가능
    // 건반을 누를지 안 누를지 정할 수 있음
    // 최소 이동횟수를 구하시오

    // 캐릭터 시작위치는 항상 1
    // 건반 개수: 12
    public static void main(String[] args) {
        int[][] music = { { 10, 9, 4, 5, 12 }, { 6, 4, 2, 11 } }; // 1 <= music 길이 <= 1000

        for (int i = 0; i < 2; i++)
            solution(music[i]);

    }

    static int answer;

    static void solution(int[] music) {
        int[][] arr = { {}, { 2, 3 }, { 1, 3 }, { 1, 2, 4, 5 }, { 3, 5 }, { 3, 4, 6, 7 }, { 5, 7 }, { 5, 6, 8 },
                { 7, 9, 10 }, { 8, 10 }, { 8, 9, 11, 12 }, { 10, 12 }, { 10, 11 } };
        answer = 0;

        int start = 1;
        for (int i = 0; i < music.length; i++) {
            go(start, music[i], arr);
            start = music[i];
        }
        System.out.println(answer);
    }

    // dfs 시간복잡도: O(E+V) = O((12+32)*1000)
    static void go(int start, int end, int[][] arr) {
        Queue<Info> q = new LinkedList<>();
        boolean[] check = new boolean[13];

        q.add(new Info(start, 0));
        check[start] = true;

        while (!q.isEmpty()) {
            Info cur = q.poll();
            int n = cur.n, cnt = cur.cnt;

            if (n == end) {
                answer += cnt;
                break;
            }

            for (int next = 0; next < arr[n].length; next++) {
                if (check[arr[n][next]])
                    continue;

                check[arr[n][next]] = true;
                q.add(new Info(arr[n][next], cnt + 1));
            }
        }
    }

    static class Info {
        int n, cnt;

        public Info(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }

}
