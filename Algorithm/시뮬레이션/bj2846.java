package 시뮬레이션;

import java.util.Scanner;

/** 오르막길 */
public class bj2846 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int sum = 0, res = 0;
		for (int i = 1; i < N; i++) {
			if (arr[i - 1] < arr[i]) {
				sum += arr[i] - arr[i - 1]; // +=
			} else {
				sum = 0;
			}
			res = Math.max(res, sum);
		}

		System.out.println(res);

	}

}
