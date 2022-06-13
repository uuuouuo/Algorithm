package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2753 {
	
// 윤년: 4의 배수 && 100의 배수 아니면서 || 400의 배수 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		
		if(year % 4 == 0) {
			
			if(year % 100 != 0) System.out.println(1);
			else if(year % 400 == 0) System.out.println(1);
			else System.out.println(0);
		} else System.out.println(0);
	}
}
