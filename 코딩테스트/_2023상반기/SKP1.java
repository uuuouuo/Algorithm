package 코딩테스트._2023상반기;

import java.util.*;

public class SKP1 {
    // 조직언 보스에게 수익금 보냄 --> 조직원당 한명의 보스
    // 보스 여러명에게 받을 수 있음 -> 또 모인 수익금 자기 보스한테 보내
    // 보낼 보스 없으면 내가 최종 보스

    // 이 조직원이 최종보스라면 해당 조직의 조직원 수(최종 보스 포함!!!)를 구해

    static Set<Integer> boss;
    static List<Integer>[] list;
    static int N;
    public int[] solution(int[] p, int[] b) {
        // p : 100000, i 번째 사람의 보스 ---> -1 인 놈이 최종보스
        // b : 100000, 조사한 애가 최종 보스가 아니면 0으로
        int[] answer = new int[b.length];
        N = p.length;
        boss = new HashSet<>(); // 최종 보스 판단을 위해
        list = new ArrayList[N];


        for(int i=0; i<N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++) {
            if(p[i] == -1) boss.add(i); // 최종보스 체크
            else list[p[i]].add(i);
        }

        // for(int i=0; i<p.length; i++) {
        //     System.out.print(i+" -> ");
        //     for(int j : list[i]) {
        //         System.out.print(j+" ");
        //     }
        //     System.out.println();
        // }

        // bfs로 조직원 수 카운트
        for(int i=0; i<b.length; i++) {
            if(!boss.contains(b[i])) answer[i] = 0;
            else answer[i] = bfs(b[i]);
            // System.out.println(bfs(b[i]));
        }

        return answer;
    }

    static int bfs(int start) {
        int result = 0;

        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[N];
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            result++;

            for(int next : list[cur]) { // 현재 조직원의 부하들
                if(check[next]) continue; // 이미 확인한 놈이면 패스
                q.add(next);
                check[next] = true;
            }
        }

        return result;
    }
}
