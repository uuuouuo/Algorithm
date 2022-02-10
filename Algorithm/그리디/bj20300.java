package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj20300 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long arr[] = new long[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		long max = 0;
		int tmp = 1;
		
		if(N%2 == 1) {
			max = arr[N - 1]; 
			tmp = 2;
		}

		for (int i = 0; i < N / 2; i++) {
			max = Math.max(max, arr[i] + arr[N - i - tmp]);
		}
		
		System.out.println(max);
		
	}

}
