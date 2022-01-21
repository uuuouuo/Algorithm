package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1260 {

	static int N, M, V;
	static List<Integer> list[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(list[i]); 
		}
				
		visited = new boolean[N + 1];
		dfs(V);
		System.out.println();
		bfs(V);

		
	}
	
	private static void dfs(int start) {
		System.out.print(start + " ");
		visited[start] = true;
		
		for(int next : list[start]){
			if(visited[next]) continue;
			dfs(next);
		}
		
	}
	
	private static void bfs(int start) {
		Arrays.fill(visited, false);		
		Queue<Integer> q = new LinkedList<Integer>();	
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			
			for(int next : list[cur]) {
				if(visited[next]) continue;
				visited[next] = true;
				q.add(next);				
			}
		}
		
	}

}
