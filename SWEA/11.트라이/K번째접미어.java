import java.io.*;
import java.util.*;

public class K번째접미어 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int size = str.length();
            String[] arr = new String[size];
            for (int i = 0; i < size; i++) {
                arr[i] = str.substring(i);
                // System.out.println(arr[i]);
            }

            Arrays.sort(arr);
            sb.append(arr[n - 1] + "\n");
        }
        System.out.println(sb);
    }
}
