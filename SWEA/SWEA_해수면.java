import java.util.*;

// x년 후 높이 x 물에 잠김
// 가장 많은 구역일 때의 구역 구하기
// for문 +1년마다 x이하 수 boolean[][] true 체크 -> +1년 마다 boolean[][]갱신
// for문으로 하나씩 확인하면서 true일 때 bfs
// boolean[][]으로 상하좌우 확인해서 false일때 집어넣기
// 해당 칸은 true로
// bfs끝나면 개수++
// max 값 확인
public class SWEA_해수면 {

    static Scanner sc;
    static int n, map[][], max, answer;
    static boolean check[][];

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            answer = -1;
            init();
            solution();
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void init() {
        n = sc.nextInt();
        max = 0;
        map = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                map[r][c] = sc.nextInt();
                if (map[r][c] > max)
                    max = map[r][c];
            }
        }
    }

    private static void solution() {
        for (int y = 0; y < max; y++) { // 1년후부터 최대높이 전까지
            check = new boolean[n][n];
            checkLand(y);

            int tmp = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (check[r][c])
                        continue;
                    bfs(r, c);
                    tmp++;
                }
            }
            answer = Math.max(answer, tmp);
        }
    }

    private static void checkLand(int h) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] > h)
                    continue; // h초과면 통과
                check[r][c] = true; // h이하면 true 체크
            }
        }
    }

    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

    private static void bfs(int row, int col) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row, col));
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r, c = cur.c;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (!isOk(nr, nc) || check[nr][nc])
                    continue;
                q.add(new Point(nr, nc));
                check[nr][nc] = true;
            }
        }

    }

    private static boolean isOk(int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= n)
            return false;
        return true;
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
