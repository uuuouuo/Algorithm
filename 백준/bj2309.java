package 백준;
import java.util.Arrays;
import java.util.Scanner;

/** 일곱난쟁이 */
public class bj2309 {

	static int N, R, input[], result[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = 9;
		R = 7;
		input = new int[N];
		result = new int[R];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		comb(0, 0);

	}

	static void comb(int start, int idx) { // 조합 (백트래킹)
		// 기저 조건.
		if (idx == R) {
			int sum = 0;
			for (int i = 0; i < R; i++) {
				sum += result[i];
			}

			if (sum == 100) {
				Arrays.sort(result);
				for (int i = 0; i < R; i++) {
					System.out.println(result[i]);
				}
			}
			return; // return 위치 ㅁㅊ ;
		}

		for (int i = start; i < N; i++) {
			result[idx] = input[i]; // result에 idx 인덱스 넣기.
			comb(i + 1, idx + 1); // 시작 index(i) 증가로 중복 방지.
		}

	}

}
