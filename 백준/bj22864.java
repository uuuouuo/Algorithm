package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj22864 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken()); // 피로도 +
		int B = Integer.parseInt(st.nextToken()); // 일 처리량
		int C = Integer.parseInt(st.nextToken()); // 피로도 -
		int M = Integer.parseInt(st.nextToken()); // 번아웃 제한
		
		int ans = 0;
		int H = 24, P = 0;
		while(H > 0) {
			// 누적 피로도 + 추가 피로도 <= 번아웃 체한
			if(P + A <= M) {
				ans += B; // 일 처리량 +
				P += A; // 누적 피로도
			}
			else {
				P = P - C < 0 ? 0 : P - C;
			}
			H--;
		}
		
		System.out.println(ans);

	}

}
