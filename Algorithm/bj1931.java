import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/** 회의실 배정 */
public class bj1931 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] times = new int[N][2];		
		for (int i = 0; i < N; i++) {
			times[i][0] = sc.nextInt();
			times[i][1] = sc.nextInt();
		}
		
		// 종료 시간이 빠를수록 더 많은 활동이 가능.
		// 종료 시간 오름차순.
		Arrays.sort(times, new Comparator<int[]> () {

			@Override
			public int compare(int[] t1, int[] t2) { // times[][] 를 1차원으로
				// 종료시간이 같다면 시작시간 빠른 순으로.
				if(t1[1] == t2[1]) {
					return t1[0] - t2[0];
				}
				// 그 외에는 종료시간이 빠른순.
				return t1[1] - t2[1];
			}		
		});

		int cnt = 0, cur = 0;
		for (int i = 0; i < N; i++) {
			// 종료시간보다 크거나 같은 시작시간 찾기.
			if(cur <= times[i][0]) {
				cur = times[i][1]; 
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
