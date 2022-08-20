import java.util.*;
import java.io.*;

public class 삼차원농부 {

    static int n, m, cows[], horses[], minDis, cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int answer = Math.abs(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));

            cows = new int[n];
            horses = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                cows[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++)
                horses[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(cows);
            Arrays.sort(horses);

            minDis = Math.abs(cows[0] - horses[0]);
            cnt = 0;
            solution();
            answer += minDis;

            sb.append(answer + " " + cnt + "\n");
        }
        System.out.print(sb);
    }

    static void solution() {
        int cIdx = 0, hIdx = 0;
        int dis;

        while (cIdx < n && hIdx < m) {
            dis = Math.abs(cows[cIdx] - horses[hIdx]);

            if (dis < minDis) {
                minDis = dis;
                cnt = 1;
            } else if (dis == minDis)
                cnt++;

            if (cows[cIdx] < horses[hIdx])
                cIdx++;
            else
                hIdx++;
        }
    }
}

