package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7569 {
	static class Point {
		int r, c, h, day;

		public Point(int h, int c, int r, int day) {
			super();
			this.h = h;
			this.c = c;
			this.r = r;
			this.day = day;
		}
		
	}

	static int M, N, H;
	static int[][][] box;
	static Queue<Point> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int c = 0; c < N; c++) {
				st = new StringTokenizer(br.readLine());
				for (int r = 0; r < M; r++) {
					box[h][c][r] = Integer.parseInt(st.nextToken());
					if(box[h][c][r] == 1) q.add(new Point(h, c, r, 0));
				}
			}
		}
		
//		for (int h = 0; h < H; h++) {
//			for (int c = 0; c < N; c++) {
//				for (int r = 0; r < M; r++) {
//					System.out.print(box[h][c][r] + " ");
//				}
//				System.out.println();
//			}
//		}
		
		int result = 0;
		int dh[] = {0, 0, 0, 0, 1, -1};
		int dr[] = {-1, 0, 1, 0, 0, 0};
		int dc[] = {0, 1, 0, -1, 0, 0};
		
		while(!q.isEmpty()) {
			Point cur = q.poll();	System.out.println(cur.h + " " + cur.r + " " + cur.c);
			int day = cur.day;
			result = Math.max(result, day);			
			
			for (int i = 0; i < 6; i++) {
				int nh = cur.h + dh[i];
				int nc = cur.c + dc[i];
				int nr = cur.r + dr[i];
				
				if(isOk(nh, nc, nr) && box[nh][nc][nr] == 0) {
					box[nh][nc][nr] = 1;
					q.add(new Point(nh, nc, nr, day + 1));					
				}
				
			}
		}
		
		for (int h = 0; h < H; h++) {
			for (int c = 0; c < N; c++) {
				for (int r = 0; r < M; r++) {
					if(box[h][c][r] == 0) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
		
		System.out.println(result);

	}
	
	private static boolean isOk(int nh, int nc, int nr) {
		if(nr < M && nc < N && nh < H && nr >= 0 && nc >= 0 && nh >= 0)
			return true;
		
		return false;
	}

}
