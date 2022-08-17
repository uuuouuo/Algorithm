package 백준;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** 토마토 */
public class bj7576 {

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int N, M, box[][], ans;
	static Queue<Point> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		box = new int[N][M];
		q = new LinkedList<Point>();
		ans = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				box[r][c] = sc.nextInt();
				if (box[r][c] == 1)
					q.add(new Point(r, c, 0));

			}
		}

		bfs();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (box[r][c] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}

		System.out.println(ans);

	}

	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };

	public static void bfs() {

		while (!q.isEmpty()) {
			Point cur = q.poll();
			int r = cur.r, c = cur.c, cnt = cur.cnt;
			ans = Math.max(cnt, ans);

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d], nc = c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || box[nr][nc] != 0)
					continue;

				q.add(new Point(nr, nc, cnt + 1));
				box[nr][nc] = 1;

			}
		}
	}
}
