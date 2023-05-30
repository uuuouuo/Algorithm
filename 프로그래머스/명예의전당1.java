package 프로그래머스;

import java.util.*;

class 명예의전당1 {

    static Queue<Integer> q;
    public int[] solution(int k, int[] score) {
        q = new PriorityQueue<>();

        // q.add(3);
        // q.add(2);
        // System.out.println(q.peek());
        int[] answer = new int[score.length];

        for(int i = 0; i < score.length; i++) {
            q.add(score[i]);

            if(q.size() == k + 1) q.poll();
            answer[i] = q.peek();
        }
        return answer;
    }
}
