package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @title 구간 나누기
 
 * 1. 범위: 최댓값 - 최소값의 범위
 * 2. 검사 값: 최소한의 최댓값 -> 이 값보다 더 큰값 나오면 안돼!
 
 */
public class bj13397 {

	static int N, M, arr[], max, res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		binarySearch();
			
	}
	
	private static void binarySearch() {
		int low = 0, high = max -1;
		
		while(low <= high) {
			int mid = (low + high) / 2;

			if(isPossible(mid)) {
				high = mid - 1;
				res = mid;
			} else {
				low = mid + 1;
			}
		}
		
		System.out.println(res);
	}

	private static boolean isPossible(int value) {
		int max = arr[0], min = arr[0];
		int cnt = 1;
		
		for(int i = 1; i < N; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
			
			// 해당구간의 차이가 최댓값의 최솟값(value)보다 크면 구간나누기
			if(max - min > value) {
				max = arr[i];
				min = arr[i];
				cnt++;
				
				if(cnt > M) return false;
			}
		}
		
		// 구간 수는 중요하지 않음! 
		// -> 비교하고있는 최댓값의 최솟값보다 큰 값이 없다는 것만 확인
		// if(cnt != M) return false;
		
		return true;
	}

}
