package 순열_조합_부분집합;

import java.util.Scanner;

/** 블랙잭 */
public class bj2798 {

	static int N, M, input[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		min = 987654321;
		result = new int[3];
		comb(0, 0);
		System.out.println(res);

	}

	static int result[], min, res;

	private static void comb(int start, int idx) {

		if (idx == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += result[i];
			}

			if (sum <= M) {
				int tmp = Math.abs(sum - M);
				if (tmp < min) {
					min = tmp;
					res = sum;
				}
			}
			return;
		}

		for (int i = start; i < N; i++) {
			result[idx] = input[i];
			comb(i + 1, idx + 1);
		}
	}
}
