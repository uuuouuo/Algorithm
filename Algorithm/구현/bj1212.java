package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1212 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			int tmp = str.charAt(i) - '0';
			String bi = Integer.toBinaryString(tmp); // Integer에 2진수로 변환하는게 있었음;
			
			if(bi.length() == 2 && i != 0) bi = "0" + bi;
			else if(bi.length() == 1 && i != 0) bi = "00" + bi;
			
			sb.append(bi);
		}
		
		System.out.println(sb); // String 이면 toString 안해도 돼
		
//
//		for (int i = 0; i < str.length(); i++) {
//			StringBuilder sb = new StringBuilder();
//			int tmp = str.charAt(i) - '0';
//
//			if(tmp == 0) {
//				System.out.print("000");
//				continue;
//			}
//			
//			while(tmp != 0) {		
//				// 0승 자리
//				if(tmp % 2 != 0) {
//					sb.append("1");
//					tmp -= 1;
//				}else {
//					sb.append("0");
//				}
//				
//				// 2승 자리
//				if(tmp == 0) {
//					System.out.print(sb.toString());
//					continue;
//				}
//				if(tmp >= 4) {
//					tmp -= 4;
//					// 1승 자리
//					if(tmp != 0) {
//						sb.append("11");
//					}else {
//						sb.append("01");
//					}
//				} else {
//					if(tmp != 0) {
//						if(i == 0) sb.append("1");
//						else sb.append("10");
//					}else {
//						if(i != 0) sb.append("00");
//					}
//				}
//				tmp = 0;
//				sb.reverse();
//				System.out.print(sb.toString());
//			}
//			
//			
//		}
//
	}
	
	

}
