package 백준;

import java.io.*;
import java.util.*;

public class bj1316 { // 그룹단어체커

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = "";
        Set<Character> set;
        int answer = 0;
        l: for (int i = 0; i < n; i++) {
            str = br.readLine();
            set = new HashSet<>();
            char pre = ' ';
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (!set.contains(c))
                    set.add(c);
                else if (pre != c)
                    continue l;

                pre = c;
            }
            answer++;
        }
        System.out.println(answer);

    }
}
