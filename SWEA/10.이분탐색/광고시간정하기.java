import java.util.*;
import java.io.*;

public class 광고시간정하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");

			int l = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			int start = 0, end = 0;
			boolean[] time = new boolean[100000000];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());

				for (int j = start; j < end; j++)
					time[j] = true;
			}

			int lastTime = end;
			solution(l, n, lastTime, time);
			sb.append(answer + "\n");
		}
		System.out.print(sb);
	}

	static int answer;

	static void solution(int l, int n, int lastTime, boolean[] time) {
		int start = 0, end = l, timeSum = 0;

		for (int i = 0; i < l; i++)
			if (time[i])
				timeSum += 1;
		answer = timeSum;

		while (end < lastTime) {
			if (time[start++])
				timeSum -= 1;
			if (time[end++])
				timeSum += 1;

			if (answer < timeSum)
				answer = timeSum;
		}

		for (int i = 0; i < lastTime; i++)
			time[i] = false;
	}

}
