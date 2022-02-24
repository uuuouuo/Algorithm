package 구현;

import java.util.Scanner;

/** 로봇 청소기 */
public class bj14503 {

	static int N, M, startR, startC, dir, map[][], cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		startR = sc.nextInt();
		startC = sc.nextInt();
		dir = sc.nextInt();
		map = new int[N][M];
		cnt = 1;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		dfs(startR, startC, dir);
		System.out.println(cnt);
	}

	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static int[][] back = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

	private static void dfs(int r, int c, int d) {
		map[r][c] = -1; // 청소된 곳과 벽을 구분해 줘야 함 (벽만 뒤로 가지 못하기 때문)

		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4; // 현위치의 왼쪽 방향부터.
			int nr = r + dr[d], nc = c + dc[d];

			if (isPossible(nr, nc) && map[nr][nc] == 0) {
				cnt++; // 청소한 부분만 카운팅.
				dfs(nr, nc, d);
				return; // 여기서 리턴해줘야 복귀할 때 다른 곳 청소 안함. (?)
			}
		}

		int nr = r + back[d][0], nc = c + back[d][1];
		if (isPossible(nr, nc) && map[nr][nc] != 1)
			dfs(nr, nc, d);
	}

	private static boolean isPossible(int r, int c) {
		if (r >= 0 && c >= 0 && r < N && c < M)
			return true;

		return false;
	}

}
