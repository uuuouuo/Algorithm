package 백준;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** 안전 영역 */
public class bj2468 {

	static int N, map[][], max, safe, res;
	static boolean visited[][];

	static class point {
		int r, c;

		point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		max = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
				max = Math.max(max, map[r][c]);
			}
		}

		res = 1;
		for (int h = 1; h < max; h++) {
			visited = new boolean[N][N];
			safe = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (visited[r][c] || map[r][c] <= h)
						continue;
					bfs(r, c, h);
				}
			}
			// System.out.println(safe);
			res = Math.max(res, safe);
		}

		System.out.println(res);

	}

	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };

	private static void bfs(int r, int c, int h) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(r, c));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			point cur = q.poll();
			int curR = cur.r, curC = cur.c;
			// System.out.print("( " + curR + ", " + curC + " ) ");

			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d], nc = curC + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] <= h || visited[nr][nc])
					continue;

				q.add(new point(nr, nc));
				visited[nr][nc] = true;
			}
		}
		// System.out.println();

		safe++;

	}

}
