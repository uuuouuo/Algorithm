package 백준;

import java.io.*;
import java.util.*;

/* 이 순서에 맞춰 구현하는 문제

로봇을 올리는 위치에 올리거나 로봇이 어떤 칸으로 이동하면 그 칸의 내구도는 즉시 1만큼 감소한다.

1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
    - 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다. */

public class bj20055 {

    static int N, K, step, start, end, belt[];
    static boolean robot[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 컨베이어 벨트 길이
        K = Integer.parseInt(st.nextToken()); // 최대로 가능한 내구도 0 개수
        belt = new int[2 * N]; // 각 컨베이어 벨트의 내구성 확인 배열
        robot = new boolean[2 * N]; // 로봇의 유무 체크 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        step = 0; // 단계 수
        start = 0; // 로봇이 올라가는 위치
        end = N; // 로봇이 내려가는 위치

        while(K > 0) {
            step++; // 단계 올리기

            /* 진행 순서 */

            moveBelt(); // 벨트 회전 + 위에 있는 로봇도 함께 회전 (내릴위치에서 로봇 내리기)
            moveRobot();// 로봇 옆 벨트로 이동 -> 내구도 0 or 로봇 있으면 이동 불가
            putRobot();// 올리는 위치에 올리기
        }
        System.out.println(step);
    }


    private static void moveBelt() {
        start--;
        end--;

        if(start < 0) start = 2 * N - 1;
        if(end < 0) end = 2 * N- 1;

        // 로봇도 이동해주기 => 내릴위치라면 없애기
        for (int i = 2 * N - 1; i >= 0; i--) {
            if(!robot[i]) continue; // 해당 위치에 로봇이 없으면 패쓰

            // 벨트위 로봇이 있으면
            robot[i] = false; // 해당 벨트의 로봇 없애주고

            if(i != end) { // 내릴위치가 아니라면 다음 벨트로 이동
                if(i == 2 * N - 1) robot[0] = true;
                else robot[i+1] = true;
            }

        }
    }

    private static void moveRobot() {
        int cur, next;

        // 내릴위치 제외하고 로봇 이동
        for (int i = 0; i < N; i++) {
            // 내릴위치 0일 때
            if(end - i < 0)  cur = 2 * N - 1 - i;
            else cur = end - i;

            if(cur == 2 * N - 1) next = 0;
            else next = cur + 1;

            // 현재 위치에 로봇이 없거나, 다음 위치에 로봇이 있거나, 다음 벨트 내구성이 0이라면
            if(!robot[cur] || robot[next] || belt[next] == 0) continue;

            robot[cur] = false; // 현재위치에 로봇 없어지고
            robot[next] = true; // 다음 위치에 두기
            belt[next]--; // 이동된 벨트 내구성 감소

            if(belt[next] == 0) K--;
        }
    }

    private static void putRobot() {
        if(robot[start] || belt[start] == 0) return;

        robot[start] = true;
        belt[start]--;

        if(belt[start] == 0) K--;
    }
}
