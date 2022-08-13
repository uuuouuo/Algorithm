import java.io.*;
import java.util.*;

public class 자기방으로돌아가기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] rooms = new int[201];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int from = (Integer.parseInt(st.nextToken()) + 1) / 2;
                int to = (Integer.parseInt(st.nextToken()) + 1) / 2;

                if (from < to) {
                    for (int j = from; j <= to; j++) {
                        rooms[j]++;
                    }
                } else if (from > to) {
                    for (int j = to; j <= from; j++) {
                        rooms[j]++;
                    }
                }
            }
            Arrays.sort(rooms);
            sb.append(rooms[200] + "\n");
        }
        System.out.println(sb);
    }

}
