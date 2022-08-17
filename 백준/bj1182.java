package 백준;

import java.util.Scanner;

/** 부분수열의 합 */
public class bj1182 {

	static int N, S, arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		selected = new boolean[N];
		ans = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		subset(0);
		System.out.println(ans);

	}

	static boolean[] selected;
	static int ans;

	private static void subset(int idx) {

		// 기저조건.
		if (idx == N) {
			int cnt = 0;

			// 공집합 검사.
			for (int i = 0; i < N; i++) {
				if (selected[i])
					cnt++;
			}
			// 공집합이라면.
			if (cnt == 0)
				return;

			int sum = 0;
			for (int i = 0; i < N; i++)
				if (selected[i])
					sum += arr[i];

			if (sum == S)
				ans++;
			return;
		}

		// 모든 경우의 수 돌리기.
		selected[idx] = true;
		subset(idx + 1);
		selected[idx] = false;
		subset(idx + 1);
	}

}
