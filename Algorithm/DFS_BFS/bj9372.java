package DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/** 상근이의 여행 : 그냥 최소 간선수를 구하면 문제였음 (N -1) */
public class bj9372 {

	static int N, M, ans;
	static List<Integer> list[];
	static boolean visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {

			N = sc.nextInt();
			M = sc.nextInt();
			list = new ArrayList[N + 1]; // 배열로 선언 !
			visited = new boolean[N + 1];

			for (int i = 1; i <= N; i++) { // 인접 리스트 행렬 생성 ㄴ|｀O′|ㄱ !!!
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				list[from].add(to);
				list[to].add(from);
			}

			bfs(1, 0);
		}

	}

	static Queue<Integer> q;

	private static void bfs(int start, int cnt) { // 리스트를 이용한 bfs.
		q = new LinkedList<Integer>();
		q.add(start); // 시작점 큐에 담기.
		visited[start] = true; // 시작점 방문 체크.

		while (!q.isEmpty()) {
			int cur = q.poll(); // 큐에 담긴 숫자 꺼내기.
			for (int i = 0; i < list[cur].size(); i++) { // 현재 숫자의 접점만 검사 ㄴ|｀O′|ㄱ !!!
				int next = list[cur].get(i); // 현재 숫자의 접점 ㄴ|｀O′|ㄱ !!!

				if (visited[next])
					continue; // 만약 이미 방문했으면 패스.
				visited[next] = true; // 아니면 방문체크하고
				cnt++;
				q.add(next); // 카운팅, 다음 숫자 큐에 담기.
			}
		}

		System.out.println(cnt);

	}

}
