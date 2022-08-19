import java.io.*;

public class 촛불이벤트 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");

			long N = Long.parseLong(br.readLine());

			long answer = solution(N);
			sb.append(answer + "\n");
		}
		System.out.print(sb);
	}

	static long solution(long N) {
		long low = 0, high = (long) Math.pow(10, 10);

		while (low <= high) {
			long mid = (low + high) / 2;
			long T = (mid + 1) * mid / 2;

			if (T > N)
				high = mid - 1;
			else if (T < N)
				low = mid + 1;
			else
				return mid;
		}
		return -1;
	}

}
