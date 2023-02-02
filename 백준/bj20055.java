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

    static int N, K, step, belt[], size;
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

        size = 2 * N; // 벨트 길이
        step = 0; // 단계 수

        while(K > 0) {
            step++; // 단계 올리기

            moveBelt(); // step1. 벨트 이동
            moveRobot(); // step2. 로봇 이동
            putRobot(); // step3. 로봇 올리기
        }
        System.out.println(step);
    }

    private static void putRobot() {
        // 올리는 위치에 로봇이 있거나 내구성이 0이면 return
        if(robot[0] || belt[0] == 0) return;

        // 로봇 올리고, 벨트 내구성 감소
        robot[0] = true;
        belt[0]--;

        if(belt[0] == 0) K--;
    }

    /**
     * 벨트는 그대로, 로봇만 이동
     */
    private static void moveRobot() {
        robot[(size/2)-1] = false; // 내리는 위치이므로 false

        for (int i = (size/2)-2; i >= 0; i--) {
            // 현재 위치에 로봇이 없거나
            // 다음 위치에 로봇이 있거나
            // 다음 위치 벨트의 내구성이 0이면 패스
            if(!robot[i] || robot[i+1] || belt[i+1] == 0) continue;

            // 한칸 옆으로 이동하고 다음 벨트 내구성 감소
            robot[i] = false;
            robot[i+1] = true;
            belt[i+1]--;

            if(belt[i+1] == 0) K--;
        }
        robot[0] = false;
    }

    /**
     * 벨트와 벨트 위 로봇 이동 함수
     */
    private static void moveBelt() {
        // 벨트 한칸씩 이동
        int tmp = belt[size-1];
        for (int i = size-2; i >= 0; i--) {
            belt[i+1] = belt[i];
        }
        belt[0] = tmp;

        // 벨트 위 로봇이동
        for (int i = (size/2)-2; i >= 0; i--) {
            if(robot[i]) robot[i+1] = true;
            else robot[i+1] = false;
        }
        robot[0] = false;
    }



}
