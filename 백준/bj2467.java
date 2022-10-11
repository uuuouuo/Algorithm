package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2467 { // 투 포인터 -> 일차원 배열, n개의 원소 더해서 m되는 경우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 용액의 수
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = N - 1; // 시작, 끝 인덱스
        long min = 2000000000;
        int a = 0, b = 0;
        while (s < e) {
            long sum = arr[s] + arr[e];
            if (Math.abs(sum) <= min) {
                min = Math.abs(sum);
                a = arr[s];
                b = arr[e];
            }
            if (sum >= 0)
                e--;
            else if (sum < 0)
                s++;
            // else break; e인덱스가 꼭 양수일 필요는 없음
        }
        System.out.println(a + " " + b);
    }
}
