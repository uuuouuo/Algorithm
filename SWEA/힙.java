import java.io.*;
import java.util.*;

public class 힙 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());

                if (cmd == 1)
                    pq.add(Integer.parseInt(st.nextToken()));
                if (cmd == 2) {
                    if (pq.isEmpty())
                        sb.append(-1 + " ");
                    else
                        sb.append(pq.poll() + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
