import java.io.*;
import java.util.*;

public class 영어공부 {

    // 접근 방법 : 투포인터 (슬라이딩 윈도우)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int[] num = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] check = new boolean[num[N - 1] + 1];
            for (int i = 0; i < N; i++) {
                check[num[i]] = true;
            }

            answer = P + 1;
            solution(check, P);
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }

    static int answer;

    static void solution(boolean[] check, int P) {
        int start = 0, end = 0, gap = 0;
        int lastDay = check.length;

        // 포인터 시작과 끝은 항상 start <= end를 만족해야 함
        // end 포인터는 마지막 날짜를 넘어가면 안됨
        while (start <= end && end < lastDay) {
            // 이미 공부한 날이면 넘어가기
            if (check[end]) {
                gap++;
                end++;
                // 최대 날짜 체크
                if (answer < gap)
                    answer = gap;
            } else {
                // 기회 모두 사용했다면
                if (P == 0) {
                    // 최대 날짜 체크
                    if (answer < gap)
                        answer = gap;
                    // 시작 부분 공부한 날인지 체크
                    // 공부한 날이 아니면 기회 추가
                    if (!check[start])
                        P++;

                    // 기간 하나줄고 전진
                    start++;
                    gap--;
                }
                // 아직 기회 남았다면
                else {
                    P--;
                    gap++;
                    end++;
                }
            }
        }

    }

}
