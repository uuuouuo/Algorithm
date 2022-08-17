package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1325 {

	static int N, M, result[], max;
	static List<Integer> list[];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			list[B].add(A);
		}

		result = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			visited = new boolean[N + 1];
			// bfs(i);
			dfs(i, i);
		}

		max = 0;
		for (int i = 1; i < N + 1; i++) {
			max = Math.max(max, result[i]);
		}

		for (int i = 1; i < N + 1; i++) {
			if (max == result[i])
				System.out.print(i + " ");
		}

	}

	private static void dfs(int start, int cur) {
		visited[cur] = true;

		for (int next : list[cur]) {
			// int next = list[cur].get(i);

			if (visited[next])
				continue;
			result[start]++;
			dfs(start, next);
		}

	}

	// private static void bfs(int start) {
	//
	// Queue<Integer> q = new LinkedList<Integer>();
	//
	// q.add(start);
	// visited[start] = true;
	//
	// while (!q.isEmpty()) {
	// int cur = q.poll();
	//
	// for (int i = 0; i < list[cur].size(); i++) {
	// int next = list[cur].get(i);
	//
	// if (!visited[next]) {
	// visited[next] = true;
	// result[start]++;
	// q.add(next);
	// }
	//
	// }
	//
	// }
	// max = Math.max(max, result[start]);
	// }

}
