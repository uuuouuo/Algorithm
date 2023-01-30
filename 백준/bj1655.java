package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// PQ 활용 : 시간복잡도: O(NlogN) -> N: 십만

/* 규칙
1. 최대힙 크기 >= 최소힙 크기
2. 최대힙 최대원소 <= 최소힙 최대원소
3. 이 규칙대로라면 최대힙 top값 => 중간값
* */

public class bj1655 { // 가운데를 말해요

    static int N, arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            int cur = Integer.parseInt(br.readLine());

            // 최대힙 사이즈는 최소힙 사이즈보다 작으면 안돼
            if(maxHeap.size() == minHeap.size()) maxHeap.add(cur);
            else minHeap.add(cur);

            // 모두 원소가 있을 때만 비교가능
            // 최대힙 최대원소는 최소힙 최대원소보다 크면 안돼 => swap
            if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int temp = maxHeap.poll();
                maxHeap.add(minHeap.poll());
                minHeap.add(temp);
            }

            sb.append(maxHeap.peek()+"\n");

        }

        System.out.println(sb.toString());
    }

}
