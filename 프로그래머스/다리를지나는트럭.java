package 프로그래머스;

import java.util.*;

class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int n = bridge_length;
        int w = weight;

        Queue<Integer> q = new LinkedList<>();
        int cur = 0; // 현재 다리 무게
        int time = 0;
        for (int t : truck_weights) {

            while (true) {
                if (q.isEmpty()) { // 다리가 비었을때
                    q.add(t);
                    cur += t;
                    time++;
                    break;
                } else if (q.size() == n) {
                    cur -= q.poll();
                } else if (cur + t <= w) {
                    q.add(t);
                    cur += t;
                    time++;
                    break;
                } else {
                    q.add(0);
                    time++;
                }
            }

        }
        return time + n;
    }
}