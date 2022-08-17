package 백준;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 예산
 * 지방의 수 N (3 ~ 10,000) : 완전탐색은 시간초과
 * 예산 범위 (0 ~ 100,000)
 * 총 예산 범위 (N ~ 1,000,000,000) : 총 예산을 예산을 빼면서 맞추는 것은 시간 초과
 * 
 * < 파라메트릭 서치 이용 >
 * 주어진 범위 내에서 원하는 값 or 조건에 일치하는 값을 찾아내는 알고리즘
 * 이진 탐색과 약간 개념 차이가 있을 뿐 구현은 유사
 * 꼭 정렬하지 않아도 됨
 */

public class bj2512 {

	static int N;
	static long cost[], M, max, res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cost = new long[N];
		for (int i = 0; i < N; i++) {
			cost[i] = sc.nextLong();
			max = Math.max(cost[i], max);
		}
		M = sc.nextLong();

		paraSearch();
		System.out.println(res);
	}

	private static void paraSearch() {
		long low = 0, high = max;
		long mid;

		while (low <= high) {
			mid = (low + high) / 2; // 예산 상한액 = 예산 최대값 !
			long sum = 0;

			for (int i = 0; i < N; i++) {
				if (mid < cost[i]) {
					sum += mid;
				} else {
					sum += cost[i];
				}
			}

			// 총예산 < 모든 지방 예산 합
			if (M < sum) {
				high = mid - 1;
			}
			// 총예산 > 모든 지방 예산 합
			else {
				// 에산 상한액을 높여 최댓값을 찾는다.
				low = mid + 1;
				res = Math.max(res, mid);
			}
		}

	}

}
