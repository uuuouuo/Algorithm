package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2606 {

	static int N, M;
	static List<Integer> list[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(to);
			list[to].add(from);
		}

		// for (int i = 1; i < N + 1; i++) {
		// System.out.print(i + " ");
		// for (int j = 0; j < list[i].size(); j++) {
		// System.out.print(list[i].get(j) + " ");
		// }
		// System.out.println();
		// }

		bfs();
	}

	static boolean[] visited;

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visited[1] = true;

		int cnt = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			cnt++;
			System.out.println("<" + cur + ">");
			for (int i = 0; i < list[cur].size(); i++) {
				int idx = list[cur].get(i);

				if (!visited[idx]) {
					q.add(idx);
					visited[idx] = true;
					System.out.println(idx);
				}
			}
		}

		System.out.println(cnt - 1);

	}

}
