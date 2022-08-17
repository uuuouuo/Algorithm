package 백준;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** 단자번호붙이기 */
public class bj2667 {

	static class point {
		int r, c;

		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int N, map[][], arr[], cnt, idx;
	static boolean visited[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}

		int num = 0;
		visited = new boolean[N][N];
		arr = new int[N * N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				cnt = 0;
				if (map[r][c] == 1 && !visited[r][c]) {
					dfs(r, c);
					num++;
				}
			}
		}

		System.out.println(num);
		Arrays.sort(arr, 0, idx);
		for (int i = 0; i < idx; i++) {
			System.out.println(arr[i]);
		}

	}

	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, -1, 0, 1 };

	private static void dfs(int r, int c) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(r, c));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			point cur = q.poll();
			int curR = cur.r, curC = cur.c;
			cnt++;

			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d], nc = curC + dc[d];

				if (!isOk(nr, nc) || map[nr][nc] == 0 || visited[nr][nc])
					continue;

				q.add(new point(nr, nc));
				visited[nr][nc] = true;
			}
		}

		arr[idx++] = cnt;

	}

	private static boolean isOk(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= N)
			return false;

		return true;
	}

}
