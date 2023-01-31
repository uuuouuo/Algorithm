package 백준;

import java.io.*;
import java.util.*;

// Queue 이용 (= 컨베이어 벨트) -> 번호, 내구도, 로봇 유무 체크
// 로봇이 이동되는건 신경 X

public class bj20055 {

    static int N, K, step, start, end;
    static Queue<Node> belt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 컨베이어 벨트 길이
        K = Integer.parseInt(st.nextToken()); // 최대로 가능한 내구도 0 개수
        belt = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt.add(new Node(i+1, Integer.parseInt(st.nextToken()), false));
        }

        step = 0; // 단계 수
        start = 1; // 로봇이 올라가는 위치
        end = N; // 로봇이 내려가는 위치
        while(K > 0) {
            step++; // 단계 올리기

            change(); // 올릴위치, 내릴위치 변경 (start, end)
            move();
            System.out.println();
        }
        System.out.println(step);
    }

    private static void change() {
        start--;
        end--;

        if(start < 1) start = 2 * N;
        if(end < 1) end = 2 * N;
    }

    // 로봇을 올리는 위치에 올리거나 로봇이 어떤 칸으로 이동하면 내구도 -1
    private static void move() {
        // start 에 로봇 올리기 & 내구성 -1, end 에 로봇 내려, 로봇이 존재한다면 내구성 -1
        for (int i = 0; i < 2 * N; i++) {
            Node cur = belt.poll();
            System.out.print(cur.number+" "+cur.power+" "+cur.isExit);

            if(cur.power == 0) {
                System.out.println(" -> 패쓰");
                belt.add(cur);
                continue;
            }

            if(cur.number == start) {
                System.out.println(" -> 올려");
                cur.isExit = true;
                cur.power--;
            }
            else if(end != 2*N && cur.number == end+1) {
                if(cur.isExit) {
                    System.out.println(" -> 내려");
                    cur.isExit = false;
                } else System.out.println();
            }
            else if(end == 2*N && cur.number == 1) {
                if(cur.isExit) {
                    System.out.println(" -> 내려");
                    cur.isExit = false;
                } else System.out.println();
            }
            else if(cur.isExit) {
                System.out.println(" -> 이동");
                cur.power--;
            }
            else {
                System.out.println();
            }


            if(cur.power == 0) K--;

            belt.add(cur);

        }
    }


    static class Node {
        int number;
        int power;
        boolean isExit;

        public Node(int number, int power, boolean isExit) {
            this.number = number;
            this.power = power;
            this.isExit = isExit;
        }
    }

}
