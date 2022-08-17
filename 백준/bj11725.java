package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj11725 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Integer> list[] = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(to);
			list[to].add(from);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited[] = new boolean[N + 1];
		int result[] = new int[N + 1];

		q.add(1);
		visited[1] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 0; i < list[cur].size(); i++) {
				int num = list[cur].get(i);

				if (!visited[num]) {
					q.add(num);
					visited[num] = true;
					result[num] = cur;
				}
			}
		}

		for (int i = 2; i < N + 1; i++) {
			System.out.println(result[i]);
		}
	}

}
