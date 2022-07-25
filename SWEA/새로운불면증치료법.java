import java.util.*;
import java.io.*;

public class 새로운불면증치료법 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String strN = br.readLine();
            int intN = Integer.parseInt(strN);

            int k = 1;
            int cnt = 0; // 모든 수 체크했는지
            boolean[] check = new boolean[10];
            while (true) {
                int size = strN.length();
                for (int i = 0; i < size; i++) {
                    int idx = Integer.parseInt(strN.substring(i, i + 1));
                    if (!check[idx]) {
                        check[idx] = true;
                        cnt++;
                    }
                }

                if (cnt == 10)
                    break;

                k++;
                strN = Integer.toString(k * intN);
            }
            System.out.println("#" + t + " " + strN);
        }

    }

}
