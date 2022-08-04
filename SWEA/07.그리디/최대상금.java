import java.io.*;
import java.util.*;

public class 최대상금 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 숫자판
            int cnt = Integer.parseInt(st.nextToken()); // 교환수

            int[] numbers = Integer.toString(N).chars()
                    .map(c -> c - '0').toArray();
            int size = numbers.length;
            if (size < cnt)
                cnt = numbers.length;

            max = 0;
            solution(0, cnt, size, numbers);
            sb.append(max + "\n");
        }
        System.out.println(sb);
        br.close();
    }

    static int max;
    static String str;

    static void solution(int idx, int cnt, int size, int[] numbers) {

        if (cnt == 0) {
            str = "";
            Arrays.stream(numbers)
                    .forEach(n -> str += Integer.toString(n));

            int tmp = Integer.parseInt(str);
            if (max < tmp)
                max = tmp;
            return;
        }
        // 하나씩 전부 변환
        for (int i = idx; i < size; i++) { // idx~
            for (int j = i + 1; j < size; j++) { // i+1~
                int tmp = numbers[i];
                swap(numbers, tmp, i, j); // 교환
                solution(i, cnt - 1, size, numbers); // 변환했던 부분부터 다시 비교
                swap(numbers, tmp, j, i); // 다시 제자리
            }
        }

    }

    static void swap(int[] numbers, int tmp, int i, int j) {
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

}
