package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1059 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine()); // 집합 S 크기

		int S[] = new int[L];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < L; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(S); // 오름 차순 정렬

		int n = Integer.parseInt(br.readLine()); // 얘를 포함한 좋은 구간 만들기
		// A <= n <= B -> A,B 구해야해 일단
		// n보다 작으면 -> A: 작은수 ~ B: n -> 작은수 개수
		// 작은수 개수 * 큰수 개수
		// n보다 크면 -> A: n ~ B: 큰수 -> 큰수 개수

		for (int i = 0; i < L; i++) {
			if(S[i] == n) {
				System.out.println(0);
				break;
			}

			if(n < S[0]) {
				// 1 ~	n
				int low = n - 1;
				// n ~ S[0]
				int high = S[0] - n - 1;
				// n이 중간에 껴있는 경우
				int middle = low * high;

				System.out.println(low + high + middle);
				System.exit(0);
			}

			if(S[i] < n && n < S[i + 1]) {
				// S[i] ~	n
				int low = n - S[i] - 1;
				// n ~ S[i + 1]
				int high = S[i + 1] - n - 1;
				// n이 중간에 껴있는 경우
				int middle = low * high;

				System.out.println(low + high + middle);
				System.exit(0);
			}

		}

	}

}
