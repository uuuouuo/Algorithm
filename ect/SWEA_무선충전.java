import java.util.*;

public class swea_무선충전2 {

    // 충전 범위로 판단 -> 맵에 입력 x
    // 될 수 있는 모든 경우(중복 조합) 하나씩 비교해서 합했을 때 가장 큰값 더하기
    // -> 왜 따로 하려했을까
    // -> 그래봤자 경우의 수 6
    static class Info {
        int x, y, range, power;

        public Info(int x, int y, int range, int power) {
            this.x = x;
            this.y = y;
            this.range = range;
            this.power = power;
        }
    }

    static int M, A, dirA[], dirB[], answer; // 이동 시간, BC 개수
    static Info[] BC;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            M = sc.nextInt();
            A = sc.nextInt();

            dirA = new int[M + 1];
            for (int i = 1; i <= M; i++)
                dirA[i] = sc.nextInt();

            dirB = new int[M + 1];
            for (int i = 1; i <= M; i++)
                dirB[i] = sc.nextInt();

            BC = new Info[A];
            for (int i = 0; i < A; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int range = sc.nextInt();
                int power = sc.nextInt();
                BC[i] = new Info(x, y, range, power);
            }

            answer = 0;
            go();
            System.out.println("#" + t + " " + answer);
        }

    }

    static int[] dx = { 0, 0, 1, 0, -1 }, dy = { 0, -1, 0, 1, 0 };

    private static void go() {
        int[] a = { 1, 1 };
        int[] b = { 10, 10 };

        for (int d = 0; d <= M; d++) { // 0초부터
            // 이동 위치
            a[0] += dx[dirA[d]];
            a[1] += dy[dirA[d]];
            b[0] += dx[dirB[d]];
            b[1] += dy[dirB[d]];

            int max = 0; // 해당위치에서 가장 큰 값 저장
            // 해당 위치일 때 사용 충전소 모든경우
            for (int i = 0; i < BC.length; i++) { // a
                for (int j = 0; j < BC.length; j++) { // b
                    int sum = 0;
                    int[] charge = new int[2]; // a, b 충전값 저장
                    // 해당위치와 BC 거리
                    int tmpA = Math.abs(a[0] - BC[i].x) + Math.abs(a[1] - BC[i].y);
                    int tmpB = Math.abs(b[0] - BC[j].x) + Math.abs(b[1] - BC[j].y);

                    if (tmpA > BC[i].range && tmpB > BC[j].range)
                        continue; // 둘 다 0이면 그냥 넘겨

                    if (tmpA <= BC[i].range)
                        charge[0] = BC[i].power;
                    if (tmpB <= BC[j].range)
                        charge[1] = BC[j].power;

                    if (i == j)
                        sum += Math.max(charge[0], charge[1]);
                    else
                        sum += charge[0] + charge[1];
                    max = Math.max(max, sum);
                }
            }
            answer += max;
        }

    }

}
