package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj14916 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int coinCnt = 0;
		while(N > 0) {

			if(N%5 == 0) {
				N -= 5;
				coinCnt++;
			}
			else {
				N -= 2;
				coinCnt++;
			}
		}
		
		if(N < 0) System.out.println(-1);
		System.out.println(coinCnt);

	}

}
