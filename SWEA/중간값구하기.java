import java.io.*;
import java.util.*;

public class 중간값구하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            maxHeap.add(Integer.parseInt(st.nextToken()));

            long sum = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                minHeap.add(Integer.parseInt(st.nextToken()));
                maxHeap.add(Integer.parseInt(st.nextToken()));

                if (minHeap.peek() < maxHeap.peek()) {
                    int min = minHeap.poll(), max = maxHeap.poll();
                    minHeap.add(max);
                    maxHeap.add(min);
                }
                sum += maxHeap.peek();
            }

            sb.append(sum % 20171109 + "\n");
        }
        System.out.println(sb);

    }

}
