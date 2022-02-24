package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj14467 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list[] = new ArrayList[11];
		// 소 10마리
		for (int i = 1; i <= 10; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 목격한 소와 위치
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);		
		}
		
		int cnt = 0;
		for (int i = 1; i <= 10; i++) {
			
			if(list[i].size() == 0 || list[i].size() == 1) continue; 
			
			for (int j = 1; j < list[i].size(); j++) {
				if(list[i].get(j - 1) == list[i].get(j)) continue;
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}
