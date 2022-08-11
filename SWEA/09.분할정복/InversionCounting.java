import java.io.*;
import java.util.*;

public class InversionCounting {
	// 이중 for문으로 O(n^2) 가능
	// 하지만 더 좋은 방법 필요 -> 합병 정렬 O(n log n)

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");

			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			int[] tmp = new int[N];
			answer = 0;
			mergeSort(N, arr, tmp, 0, N - 1);
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}

	static long answer;

	static void mergeSort(int N, int[] arr, int[] tmp, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;

			mergeSort(N, arr, tmp, start, mid);
			mergeSort(N, arr, tmp, mid + 1, end);

			int l = start, r = mid + 1, idx = l;

			while (l <= mid || r <= end) {
				if (r > end || (l <= mid && arr[l] < arr[r])) {
					tmp[idx++] = arr[l++];
				} else {
					answer += mid - l + 1;
					tmp[idx++] = arr[r++];
				}
			}

			for (int i = start; i <= end; i++)
				arr[i] = tmp[i];
		}
	}

}
