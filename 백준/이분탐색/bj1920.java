package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 수 찾기
 * '수가 존재하는지'만 알아내면 되기 때문에
 * '중복 원소에 대한 고려는 하지 않고' 구현
 * 
 * 이분 탐색
 * 꼭 배열을 정렬해 주어야 함 !
 * 1. 중간 인텍스 찾기
 * 2. 중간 인덱스와 key 값 비교
 * 3. 중간 값보다 작다면 좌측, 크다면 우측 탐색, 같다면 반환 후 종료
 * 시간 복잡도: O(logN)
 * 
 */

public class bj1920 {

	static int N, M, A[], res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		Arrays.sort(A);

		// for (int i = 0; i < N; i++) {
		// System.out.print(A[i] + " ");
		// } System.out.println();

		M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int res = 0;
			int key = sc.nextInt();

			// 이분 탐색
			// binarySearch1(0, N - 1, key);
			binarySearch2(key);
		}
	}

	// 재귀적 탐색
	private static void binarySearch1(int low, int high, int key) {
		int mid = (low + high) / 2;

		if (low <= high) {
			if (A[mid] == key) {
				System.out.println(1);
				return;
			}

			else if (A[mid] > key) {
				binarySearch1(low, mid - 1, key);
			}

			else {
				binarySearch1(mid + 1, high, key);
			}
		}

		else
			System.out.println(0); // 재귀는 너무 어려워;
		return; // 재귀로 인해 마지막은 다시 처음으로 돌아옴.

	}

	// 반복적 탐색
	private static void binarySearch2(int key) {

		int low = 0, high = N - 1;
		int mid;

		// low가 high보다 커지기 전까지 반복
		while (low <= high) {
			mid = (low + high) / 2;

			if (A[mid] > key) {
				high = mid - 1;
			}

			else if (A[mid] < key) {
				low = mid + 1;
			}

			else {
				System.out.println(1);
				return;
			}
		}

		System.out.println(0);
		return;

	}
}