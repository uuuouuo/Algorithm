package 백준;

import java.io.*;

// 이분탐색
// https://st-lab.tistory.com/281
public class bj1300 { // k번째수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long k = Integer.parseInt(br.readLine());

        // k번째 수 구하기 = 임의의 수(mid)보다 같거나 작은 수가 k개
        // n < 10^5, k < n^2
        long low = 1, high = k;
        while (low < high) {
            long mid = (low + high) / 2;
            long sum = 0;
            for (int i = 1; i <= n; i++) {
                // 구구단 생각
                // n이 초과하지 않는 선에서
                sum += Math.min(mid / i, n);
            }

            // upper-bound: 타겟값을 초과하는 첫번째 값
            // lower-bound: 타겟값과 같거나 큰 첫번째값 ✔
            if (sum >= k)
                high = mid;
            else
                low = mid + 1;
        }

        System.out.println(low);
    }
}
