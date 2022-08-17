package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 휴게소 세우기
 
 * 풀이
  1. 범위 : 1 ~ (L - 1)
  2. 문제에서 구해야 하는 것 : 휴게소 없는 구간 길이의 최댓값 중 최소
  	  -> 휴게소 최소 구간을 이용
 */
public class bj1477 {

	static int N, M, L, arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()); // 라인 변경
		
		arr = new int[N + 2];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 휴게소 위치
		}
		arr[0] = 0; // 고속도로 시작
		arr[N + 1] = L; // 고속도로 끝		
		Arrays.sort(arr);

		BinarySearch();
	}
	
	private static void BinarySearch() {
		int start = 1, end = L;
		int min = 0;
		
		while(start <= end) { // ?
			min = (start + end) / 2; // 최소 휴게소 구간

			// 휴게소 설치가 가능할 때
			if(canInstall(min) > M) { // ?
				// 그 중 최소값 구해야함
				start = min + 1;
			}
			else {
				end = min - 1;
			}

		}
		System.out.println(start); // 왜 ?
		
	}
	
	private static int canInstall(int distance) {
		int cnt = 0;

		for (int i = 1; i < N + 2; i++) {
			int tmp = arr[i] - arr[i - 1] - 1; // 설치가능한 거리
			/**
			 *  한구간에 여러 휴게소가 설치될 수 있음 !
			 */
			cnt += tmp / distance;
		}
		
		return cnt;
		
	}

}
