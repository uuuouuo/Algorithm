package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 참고 링크 : https://9327144.tistory.com/m/entry/BOJ-3079-%EC%9E%85%EA%B5%AD%EC%8B%AC%EC%82%ACJAVA
 * 참고 링크 : https://9327144.tistory.com/entry/%ED%8C%8C%EB%9D%BC%EB%A9%94%ED%8A%B8%EB%A6%AD-%EC%84%9C%EC%B9%98Parametric-Search

 * 입국 심사
  사람 수 M (1 ~ 1,000,000,000)
  심사 시간 (1 ~ 1,000,000,000)
  심사관 N (1 ~ 100,000)

 * 파라메트릭 서치 
  : 특정 값을 구하라는 문제(최대 값, 최소 값을 구하라)를 결정 문제로 바꿔서 생각하는 방법 
  시간 복잡도 : O(MlogN)
 
 * <풀이>
  전체 시간안에 끝낼 수 있는 지 판단 (전체 시간 : 최대 심사 시간 * M명)
  심사를 마치는 최대, 최소 사이의 중간 값을 바탕으로 가능한지 판단
 
 * 해당 시간 안에 심사가 가능한지 판단하는 방법
   1. 해당 시간인 TIME를 구한다.
   2. 각 심사대에서 mid 시간 안에 몇 명이 심사를 받을 수 있는지 구한다. // 이분 탐색
   3. 각 심사대에서 심사 받을 수 있는 인원을 모두 더하여 M보다 크거나 같은지 확인한다.
   4. M보다 작다면, TIME안에 불가능 하다는 것이고, M보다 크거나 같다면 TIME안에 가능하다는 것이다. // 파라메트릭 서치
 */

public class bj3079 {

	static int N;
	static long M, arr[], maxTime, res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken()); // long형 주의
		
		arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine()); // Enter 입력시 : br.readLine()
			maxTime = Math.max(maxTime, arr[i]);
		}
		
		paraSearch();
	}
	
	private static void paraSearch() {
		long low = 0, high = maxTime * M; // 최소 걸리는 시간 ~ 최대 걸리는 시간
		res = Long.MAX_VALUE; // long형 주의
		
		while(low <= high) {
			long mid = (low + high) / 2;
			long sum = 0;
			// 각각의 심사대에서 심사 시간 (mid) 안에 심사 가능한 사람 수 구하기. 
			for (int i = 0; i < N; i++) {
				sum += mid / arr[i];
			}
			
			// 해당 총시간안에 심사 모두 가능
			if(sum >= M) { 
				System.out.println(mid + ", " + sum);
				high = mid - 1;
				res = Math.min(res, mid);
			} else {
				low = mid + 1;
			}
		}
		System.out.println(res);
	}

}
