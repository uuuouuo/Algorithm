package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj20115 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		double arr[] = new double[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		for (int j = 0; j < N - 1; j++) {
			double tmp = 0;
			tmp = arr[N - 1] + arr[j]/2;
			arr[N - 1] = tmp;
			if(j == N - 2)
				System.out.println(tmp);				
		}
		
	}

}
