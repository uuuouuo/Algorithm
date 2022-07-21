import java.io.*;
import java.util.regex.*;

public class SWEA_사칙연산유효성검사 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        l: for (int t = 1; t <= 10; t++) {
            sb.append("#" + t + " ");

            int N = Integer.parseInt(br.readLine());

            Pattern num = Pattern.compile("^[0-9]*$");
            for (int i = 0; i < N; i++) {
                String[] str = br.readLine().split(" ");
                int size = str.length;
                if ((size == 4 && num.matcher(str[1]).matches())
                        || (size == 2 && !num.matcher(str[1]).matches())) {
                    sb.append(0 + "\n");
                    for (int j = i + 1; j < N; j++)
                        br.readLine();
                    continue l;
                }
            }
            sb.append(1 + "\n");
        }
        System.out.println(sb);

    }

}
