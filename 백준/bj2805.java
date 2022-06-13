package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 나무자르기 필요한 나무 길이: key 나무의 최소, 최대길이가 범위 (low, high)
 * 
 * long으로 안해서 삽질 오지게 함
 */
public class bj2805 {

	static int N, M, tree[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		tree = new int[N];
		for (int i = 0; i < N; i++) {
			tree[i] = sc.nextInt();
		}
		Arrays.sort(tree);

		binarySearch(M);

	}

	private static void binarySearch(int key) {

		// 0 ~ 나무의 최대 길이를 범위로
		long low = 0, high = tree[N - 1];
		long h = 0, res = 0;

		while (low <= high) {
			h = (low + high) / 2;

			// System.out.println("범위 : " + low + " ~ " + high);
			// System.out.println("자르는 높이 : " + h);

			long sum = 0;
			for (int i = 0; i < N; i++) {
				if (tree[i] > h) { // 자르려는 높이보다 큰 나무만
					sum += tree[i] - h; // 잘린 나무 합
				}
			}

			// 잘린 나무 합과 필요한 나무 길이 비교
			if (sum >= key) { // 같다(=) 표시 해주는 이유 : 범위 벗어나야 함
				low = h + 1;
				res = h; // 필요한 나무 길이보다 이상이 되야해서
				// System.out.println(sum + " 너무 많아. 높여!");
			} else if (sum < key) {
				high = h - 1;
				// System.out.println(sum + " 너무 적어. 낮춰!");
			}

		}

		System.out.print(res);
		System.exit(0);

	}

}
