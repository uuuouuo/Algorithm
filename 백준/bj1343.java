package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1343 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		String[] arr = str.split("");

		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i].equals("X") ) {
				cnt++;
				
				if(cnt == 4) {
					sb.append("AAAA");
					cnt = 0;
				}
				else if(cnt == 2) {
					if(i + 1 != arr.length && arr[i + 1].equals("X")) continue;
					else {
						sb.append("BB");
						cnt = 0;
					}
				}
			}
			
			else if(arr[i].equals(".")) {

				if (cnt == 2 || cnt == 4 || cnt == 0) sb.append(".");
				else {
					System.out.println(-1);
					System.exit(0);					
				}
				
				
			}
			
		}
		if(sb.length() == 0) System.out.println(-1);
		else System.out.println(sb.toString());

	}

}
