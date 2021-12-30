package 순열_조합_부분집합;

import java.util.Scanner;

/** 차이를 최대로 */
public class bj10819 {

	static int N, arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		result = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		perm(0);
		System.out.println(max);
	}

	static boolean visited[];
	static int result[], max;

	private static void perm(int idx) {

		if (idx == N) {
			int sum = 0;
			for (int i = 1; i < N; i++) {
				sum += Math.abs(result[i - 1] - result[i]);
			}
			max = Math.max(max, sum);
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			result[idx] = arr[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}

	}

}
