import java.io.*;
import java.util.*;

public class 이진수표현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			bitwise(n, m, t);
			// bitmasking(n, m, t);

		}

	}

	private static void bitwise(int n, int m, int t) {
		for (int i = n - 1; i >= 0; --i) {
			if ((m & (1 << i)) != (1 << i)) { // m과 2^i의 &연산 결과가 2^i와 다를때
				System.out.println("#" + t + " OFF");
				return;
			}
		}
		System.out.println("#" + t + " ON");
	}

	private static void bitmasking(int n, int m, int t) {
		int val = (1 << n) - 1; // 2^n(1<<n)에서 -1하면 모두 1인 n개비트
		if ((val & m) != val) { // &연산을 통해 나온 값 -> 둘다 같다면 그대로 나옴
			System.out.println("#" + t + " OFF");
			return;
		}
		System.out.println("#" + t + " ON");
	}

}
