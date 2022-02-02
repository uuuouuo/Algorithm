package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2217 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] weights = new int[N];
		for (int i = 0; i < N; i++) {
			weights[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(weights);
		
		int max = 0;
		for (int i = N - 1; i >= 0; i--) {
			max = Math.max(max, weights[i] * (N - i));
		}
		System.out.println(max);
	}

}
