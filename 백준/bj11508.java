package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class bj11508 {

	/**
	 * 최소 비용 구하기 문제
	 * 내림차순 정렬
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Integer price[] = new Integer[N];
		for (int i = 0; i < price.length; i++) {
			price[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(price, Collections.reverseOrder());

		// for (int i = 0; i < price.length; i++) {
		// System.out.println(price[i]);
		// }

		long sum = 0;
		int cnt = 0;
		for (int i = 0; i < price.length; i++) {

			cnt++;

			if (cnt % 3 == 0) {
				price[i] = 0;
			}
			sum += price[i];
		}

		System.out.println(sum);

	}

}
