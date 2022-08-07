import java.io.*;
import java.util.*;

public class 수열편집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            LinkedList<String> list = new LinkedList<>();
            init(st, list, N);

            edit(br, st, list, M);

            if (list.size() < L)
                sb.append(-1);
            else
                sb.append(list.get(L));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void init(StringTokenizer st, LinkedList<String> list, int N) {
        for (int i = 0; i < N; i++) {
            list.add(st.nextToken());
        }
    }

    static void edit(BufferedReader br, StringTokenizer st, LinkedList<String> list, int M) throws IOException {
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("I"))
                list.add(Integer.parseInt(st.nextToken()), st.nextToken());
            if (order.equals("D"))
                list.remove(Integer.parseInt(st.nextToken()));
            if (order.equals("C"))
                list.set(Integer.parseInt(st.nextToken()), st.nextToken());
        }

    }
}
