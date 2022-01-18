package 그래프탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** 미로찾기 */
public class bj2178 {

	static int N, M, map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		min = 987654321;

		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}

		// for (int r = 0; r < N; r++) {
		// for (int c = 0; c < M; c++) {
		// System.out.print(map[r][c] + " ");
		// }
		// System.out.println();
		// }

		// dfs(0, 0, 1);
		// System.out.println(min);
		bfs();

	}

	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int min;

	private static void dfs(int r, int c, int cnt) { // 시간초과 ┗|｀O′|┛ ! ! !

		visited[r][c] = true;

		// dfs는 가지치기가 필요.
		if (cnt > min)
			return;

		// dfs는 여러경로가 나옴.
		if (r == N - 1 && c == M - 1) {
			min = Math.min(min, cnt);
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d], nc = c + dc[d];
			// 범위, 0 : 패스.
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0 || visited[nr][nc])
				continue;

			// System.out.println(nr +", " + nc + " = " + cnt);

			dfs(nr, nc, cnt + 1);
		}

		visited[r][c] = false; // dfs는 이게 필요한가봐.

	}

	static class point {
		int r, c, cnt; // 카운트 필요

		public point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	private static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.add(new point(0, 0, 1));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			point cur = q.poll();
			int r = cur.r, c = cur.c, cnt = cur.cnt;
			// System.out.println(r + ", " + c);
			// System.out.println(cnt);

			if (r == N - 1 && c == M - 1) {
				System.out.println(cnt);
				System.exit(0);
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d], nc = c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0 || visited[nr][nc])
					continue;
				q.add(new point(nr, nc, cnt + 1));
				visited[nr][nc] = true;
			}
		}

	}

}
