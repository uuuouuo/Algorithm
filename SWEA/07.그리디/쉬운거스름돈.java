import java.io.*;

public class 쉬운거스름돈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + "\n");

            int N = Integer.parseInt(br.readLine());
            int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

            for (int i = 0; i < 8; i++) {
                int cnt = N / money[i];
                N = N % money[i];
                sb.append(cnt + " ");
            }

            sb.append("\n");

        }
        System.out.println(sb);
    }

}
