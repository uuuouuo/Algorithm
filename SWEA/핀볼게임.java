package SWEA;

import java.util.*;

public class 핀볼게임 {
	static Scanner sc;
	static int N, map[][];

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N + 2][N + 2];

			// 벽처리
			setWall();

			hall = new Point[11];
			setMap();

			int answer = 0;
			for (int r = 1; r < N + 1; r++) {
				for (int c = 1; c < N + 1; c++) {
					if (map[r][c] == 0) {
						for (int d = 0; d < 4; d++)
							answer = Math.max(answer, go(r, c, d));
					}
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}

	private static int go(int r, int c, int d) {
		int nr = r, nc = c, score = 0;
		while (true) {
			nr += dir[d][0];
			nc += dir[d][1];
			int n = map[nr][nc];

			// 시작점이거나 블랙홀일 때
			if (nr == r && nc == c || n == -1)
				return score;
			// 웜홀일 때
			// 웜홀은 점수 추가 안돼
			if (n >= 6 && n <= 10) {
				Point p = changePoint(nr, nc);
				nr = p.r;
				nc = p.c;
			} else if (n >= 1 && n <= 5) { // 블럭일 때
				d = changeDir(n, d);
				score++;
			}
		}
	}

	private static Point changePoint(int nr, int nc) {
		int n = map[nr][nc];
		Point result = null;
		for (int i = 0; i < 11; i++) {
			Point p1 = hall[n];
			Point p2 = hall[10 - n];

			if (p1.r == nr && p1.c == nc) {
				result = hall[10 - n];
				break;
			} else if (p2.r == nr && p2.c == nc) {
				result = hall[n];
				break;
			}
		}
		return result;
	}

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

	private static int changeDir(int n, int d) {
		int result = -1;
		if (n == 1) {
			if (d == 0)
				result = 1;
			if (d == 1)
				result = 3;
			if (d == 2)
				result = 0;
			if (d == 3)
				result = 2;
		} else if (n == 2) {
			if (d == 0)
				result = 3;
			if (d == 1)
				result = 0;
			if (d == 2)
				result = 1;
			if (d == 3)
				result = 2;
		} else if (n == 3) {
			if (d == 0)
				result = 2;
			if (d == 1)
				result = 0;
			if (d == 2)
				result = 3;
			if (d == 3)
				result = 1;
		} else if (n == 4) {
			if (d == 0)
				result = 1;
			if (d == 1)
				result = 2;
			if (d == 2)
				result = 3;
			if (d == 3)
				result = 0;
		} else if (n == 5) {
			if (d == 0)
				result = 1;
			if (d == 1)
				result = 0;
			if (d == 2)
				result = 3;
			if (d == 3)
				result = 2;
		}
		return result;
	}

	static Point[] hall;

	private static void setMap() {
		for (int r = 1; r < N + 1; r++) {
			for (int c = 1; c < N + 1; c++) {
				int n = sc.nextInt();
				if (n >= 6 && n <= 10) { // 웜홀처리
					Point p = hall[n];
					if (p == null)
						hall[n] = new Point(r, c);
					else
						hall[10 - n] = new Point(r, c);
				}
				map[r][c] = n;
			}
		}
	}

	private static void setWall() {
		for (int r = 0; r < N + 2; r++)
			for (int c = 0; c < N + 2; c++)
				if (r == 0 || c == 0 || r == N + 1 || c == N + 1)
					map[r][c] = 5;
	}

}
