import java.io.*;
import java.util.*;

public class 사탕가방 {

    // 이걸 어떻게 이분탐색으로 생각할까..
    // 가방의 개수로 범위 지정
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long M = Long.parseLong(st.nextToken());

            long[] arr = new long[N];
            long max = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
                if (max < arr[i])
                    max = arr[i];
            }

            solution(N, M, max, arr);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void solution(int N, long M, long max, long[] arr) {
        long low = 1, high = max, mid = 0; // 가방의 개수로 찾기

        while (low <= high) {
            mid = (low + high) / 2;
            long sum = 0;

            // 들어갈 사탕의 수
            for (int i = 0; i < N; i++)
                sum += arr[i] / mid;

            // 사탕수가 M보다 작음 -> 가방 수가 많다는 것 -> 범위 낮추기
            if (sum < M)
                high = mid - 1;
            // 사탕수가 M과 같거나 큼 -> 가방 수가 적다는 것 -> 범위 올리기
            else
                low = mid + 1;
        }

        sb.append(high);
    }

}
