package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 숫자 카드
 * 카드 개수 N (1 ≤ N ≤ 500,000)
 * 숫자 카드 수 범위 : -10000000 ~ 100000000
 * 비교 할 숫자 카드 개수 M (1 ≤ M ≤ 500,000)
 */

public class bj10815 {

	static int N, M;
	static long card1[], card2[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		card1 = new long[N];
		for (int i = 0; i < N; i++) {
			card1[i] = sc.nextLong();
		}

		// 배열이 아닌 숫자를 바로 넣어서
		// 재귀 돌리면 시간 초과.
		// 이유가 뭘까;
		M = sc.nextInt();
		card2 = new long[M];
		for (int i = 0; i < M; i++) {
			card2[i] = sc.nextLong();
		}

		Arrays.sort(card1);

		for (int i = 0; i < M; i++) {
			binarySearch(card2[i]);
		}

	}

	private static void binarySearch(long key) {
		int low = 0, high = N - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;

			if (card1[mid] < key) {
				low = mid + 1;
			} else if (card1[mid] > key) {
				high = mid - 1;
			} else {
				System.out.print(1 + " ");
				return;
			}
		}

		System.out.print(0 + " ");

	}

}
