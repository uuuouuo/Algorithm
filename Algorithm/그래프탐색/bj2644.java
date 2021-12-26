

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 촌수계산 */
public class bj2644 {

	static int N, M, start, end, adj[][], ans;
	static List<Integer> list[]; // List 행렬 생성 !
	static boolean visited[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		start = sc.nextInt();
		end = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N + 1];
		ans = 0;
		
		// 방법 1. 인접행렬 - 맨날 한거니까 일단 패스.
		adj = new int[N][N];
				
		// 방법 2. 인접리스트 -> bfs로 한거랑 시간이 같은데..? 메모리도 개쪼금 줄고..
		list = new ArrayList[N + 1];
		
		for(int i=1; i<= N; i++) { // 인접 리스트 행렬 생성 ㄴ|｀O′|ㄱ !!!
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			list[from].add(to);
			list[to].add(from); 
			/**  
             * 인접 리스트의 인덱스에 접점 넣기.
			 * [0] : 안씀.
			 * [1] - 2, 3
			 * [2] - 1, 7, 8, 9
			 * [3] - 1 
             */
		}
		
		dfs(start, end, 1);
		
		if(ans == 0) {
			System.out.println(-1);
		}	

	}

	// 인접 리스트 이용.
	private static void dfs(int from, int to, int cnt) {
		
		visited[from] = true;
							
		for (int i = 0; i < list[from].size(); i++) { // 인접한 부분만 돌기때문에 훨씬 빨라짐 ㄴ|｀O′|ㄱ !!!
			
			if(visited[list[from].get(i)]) {
				continue;
			}
			if (list[from].get(i) == to) {
				ans = cnt;
				System.out.println(ans);
				return; // cnt로 return하면 재귀로 인해 3, 2, 1 찍혀서 나중엔 초기값으로 돌아옴.
			}
			dfs(list[from].get(i), to, cnt + 1);
		}
	}

}
