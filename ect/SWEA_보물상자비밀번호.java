import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static int N, K;
    static String input[];
    static HashSet<String> set;
    static List<Long> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            N = sc.nextInt();
            K = sc.nextInt();

            input = sc.next().split("");
            set = new HashSet<>();

            // 4회전시켜야함 -> swap 사용
            for (int i = 0; i < N / 4; i++) {
                if (i == 0)
                    getNum();
                else
                    swap();
            }

            // 내림차순 위해: 16진수 to 10진수 -> .parsInt(넣은수, 16) 사용
            result = new ArrayList<>();
            toDecimal();
            // 배열 내림차순 후 k번째 찾기
            Collections.sort(result, Collections.reverseOrder());
            System.out.println("#" + (t + 1) + " " + result.get(K - 1));
        }

    }

    static void getNum() {
        String tmp = "";
        for (int i = 0; i < N; i++) {
            tmp += input[i];
            if ((i + 1) % (N / 4) == 0) {
                set.add(tmp);
                tmp = "";
            }
        }
    }

    static void swap() {
        String tmp = input[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            if (i == 0)
                input[i] = tmp;
            else
                input[i] = input[i - 1];
        }
        getNum();
    }

    static void toDecimal() {
        for (String s : set) {
            long val = Long.parseLong(s, 16);
            result.add(val);
        }
    }

}
