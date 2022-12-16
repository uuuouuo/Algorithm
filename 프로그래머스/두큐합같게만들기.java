package 프로그래머스;

import java.util.*;

class 두큐합같게만들기 {

    static Queue<Integer> q1, q2;

    public int solution(int[] queue1, int[] queue2) {

        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        // System.out.println(sum1);

        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        push(q1, queue1);
        push(q2, queue2);

        int size = queue1.length * 4; // 원상태 될 때까지
        int cnt = 0;
        while (true) {
            if (size < cnt)
                return -1;

            if (sum1 == sum2)
                return cnt;
            else if (sum1 > sum2) {
                int move = q1.poll();
                q2.add(move);
                sum1 -= move;
                sum2 += move;
            } else if (sum1 < sum2) {
                int move = q2.poll();
                q1.add(move);
                sum2 -= move;
                sum1 += move;
            }
            cnt++;
        }
    }

    static void push(Queue<Integer> q, int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            q.add(arr[i]);
        }
    }

}
