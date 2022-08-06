import java.io.*;
import java.util.*;

public class 염라대왕의이름정렬 {

    public static void main(String[] args) throws Exception {
        // 이름 길이 짧은 순, 같으면 사전 순
        // 같은 이름은 하나만
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + "\n");

            int N = Integer.parseInt(br.readLine());
            TreeSet<String> arr = new TreeSet<String>((o1, o2) -> {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o1.length() - o2.length();
            });

            for (int i = 0; i < N; i++)
                arr.add(br.readLine());

            for (String s : arr)
                sb.append(s + "\n");

        }
        System.out.println(sb);
    }

}
