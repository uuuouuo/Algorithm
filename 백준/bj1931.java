package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj1931 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int timeTable[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			timeTable[i][0] = Integer.parseInt(st.nextToken());
			timeTable[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(timeTable, (t1, t2) -> t1[0] - t2[0]);
		Arrays.sort(timeTable, (t1, t2) -> t1[1] - t2[1]);
		
//		for (int i = 0; i < timeTable.length; i++) {
//			for (int j = 0; j < 2; j++) {
//				System.out.print(timeTable[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int cnt = 1;
		int tmp = timeTable[0][1];
		for (int i = 1; i < N; i++) {
			if(tmp <= timeTable[i][0]) {
//				System.out.println(i);
				tmp = timeTable[i][1];
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
	}

}
