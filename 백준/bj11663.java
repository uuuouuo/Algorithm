package 백준;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 선분 위의 점
 * 선분의 최대, 최소값을 이용해서
 * 정렬한 점 중 선분 범위 안에 있는 점의 개수 찾기
 */
public class bj11663 {

	static int N, M;
	static long point[], line[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		point = new long[N];
		line = new long[M][2];

		for (int i = 0; i < N; i++) {
			point[i] = sc.nextLong();
		}
		Arrays.sort(point);

		for (int i = 0; i < M; i++) {
			binarySearch(sc.nextLong(), sc.nextLong());
		}

	}

	private static void binarySearch(long x, long y) {
		int low = 0, high = N - 1;

		// 점들 중 선분 범위 중 최댓값 찾기.
		while (low <= high) {
			int mid = (low + high) / 2;
			// System.out.println(low + "~" + high + " : " + mid);

			if (point[mid] > y) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		// System.out.println("최대 idex: " + (high + 1));
		int max = high + 1;

		low = 0;
		high = N - 1;

		// 점들 중 선분 범위 중 최솟값 찾기.
		while (low <= high) {
			int mid = (low + high) / 2;
			// System.out.println(low + "~" + high + " : " + mid);

			if (point[mid] < x) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		// System.out.println("최소 idex: " + low);
		int min = low;

		System.out.println(max - min);

	}

}
