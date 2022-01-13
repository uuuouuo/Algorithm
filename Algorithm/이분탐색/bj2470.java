package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 참고 링크 : https://hongjuzzang.github.io/cs/two_pointers/
 
 * 두 용액 *
  산성 (1 ~ 10^9)
  알칼리 (-1 ~ -10^9)
  용액의 개수 N (2 ~ 10^5)
  -> int 쌉가능
 
 * 풀이
  - 투 포인터: 투 포인터 알고리즘은 두 배열에서 검색 시 쉽고 효율적인 방법
  	1) 배열의 첫번째 원소와 배열의 마지막 원소에서 시작하는 경우(반대 진행방향)
  		- 투 포인터에서 하나의 포인터는 첫번째 원소를 나타내고 다른 하나는 마지막 원소를 나타낸다
		- 두 포인터는 서로를 향한 방향으로 이동하는데 두 포인터가 만나거나 어떤 조건을 만족할 때 까지 이동한다

	2) 둘 다 첫번째 원소에서 시작하는 경우(같은 진행방향)
  
 */

public class bj2470 {

	static int N;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()); // 사용 전에 적어
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		BinarySearch();
	}
	
	private static void BinarySearch() {
		int left = 0, right = N - 1;
		int gap = Integer.MAX_VALUE;
		int ans1 = 0, ans2 = 0;
		
		while(left < right) { // index (같으면 안돼 ㄱ-)
			int cur = Math.abs(arr[left] + arr[right]); // 두 용액의 합 절댓값
			
			// 저장된 gap 값보다 현재 값이 더 작을때
			if(gap > cur) {
				gap = cur; // 더 작은 값으로 변경
				ans1 = arr[left];
				ans2 = arr[right];
			}
			
			// 양수(+, 산성용액)가 더 큰 경우
			if(arr[left] + arr[right] > 0) {
				right--; // 양수(+) 더 줄이기
			}
			else {
				left++;
			}
		}
		System.out.println(ans1 + " " + ans2);
		
	}

}
