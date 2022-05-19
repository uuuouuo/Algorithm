package 이분탐색;

import java.util.Scanner;

/**
 * 랜선 자르기
 * 범위 1 ~ 최대길이
 * N의 개수이상 중 최대길이 구해야 함
 * -> N 이상일 때 결과값 저장
 */

public class bj1654 {

	static int K, N;
	static long line[], max, res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();

		line = new long[K];
		max = 0;
		for (int i = 0; i < K; i++) {
			line[i] = sc.nextInt();
			max = Math.max(max, line[i]);
		}

		binarySearch();
		System.out.println(res);

	}

	private static void binarySearch() {
		// 범위 1 ~ 최대길이
		// (0부터 시작하면 /by zero 에러 발생)
		long low = 1;
		long high = max;
		long h;

		while (low <= high) {
			h = (low + high) / 2;
			long sum = 0;
			for (int i = 0; i < K; i++) {
				sum += line[i] / h;
			}

			if (N > sum) {
				high = h - 1;
			} else if (N <= sum) {
				low = h + 1;
				res = h; // N개 이상일 때 결과값 저장.
			}
		}

	}

}
