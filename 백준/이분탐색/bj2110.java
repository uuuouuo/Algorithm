package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 참고 링크 : https://st-lab.tistory.com/277
 * 공유기 설치
 * 이분 탐색 접근 방법
 * 1. 탐색 범위 정하기 : 거리
 * 2. 구하려는 대상(최대, 최소)의 범위 변경하며 확인 : 집간 거리
 * 3. 조건에 맞는 지 확인
 * 
 * 최대로 가질 수 있는 최소거리 -> Upper Bound
 */
public class bj2110 {

	static int N;
	static long C, house[], res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Long.parseLong(st.nextToken());

		house = new long[N];
		for (int i = 0; i < N; i++) {
			house[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(house);

		BinarySearch();

	}

	private static void BinarySearch() {
		// 범위 : 전체 거리
		long low = 0, high = house[N - 1];

		// Upper Bound
		while (low <= high) {
			long mid = (low + high) / 2; // 공유기를 설치할 집간 최소 거리

			// 설치 공유기 개수가 부족할 경우 -> 최소 거리 범위 감소
			if (cntRouter(mid) < C) {
				high = mid - 1;
			}
			// 공유기 개수가 충족하면, 그 중 최소거리 구하기
			else {
				res = mid;
				low = mid + 1;
			}
		}
		System.out.println(res);

	}

	// 설치가능한 공유기 개수 찾는 메소드
	private static int cntRouter(long distance) {
		int cnt = 1; // 맨 앞집은 무조건 설치
		int cur = 0; // 가장 최근에 공유기가 설치된 위치 집 index

		for (int i = 1; i < N; i++) {
			// 집간 거리 >= 공유기 설치할 최소 거리
			// 설치 가능할 때
			if ((house[i] - house[cur]) >= distance) {
				cnt++;
				cur = i;
			}
		}
		return cnt;
	}

}
