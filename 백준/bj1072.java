package 백준;

import java.io.*;
import java.util.*;

public class bj1072 { // 게임

    static long X, Y, Z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        Z = (Y * 100) / X ;

        // 99, 100 퍼는 더이상 올릴 수 없음
        if(Z > 98) System.out.println(-1);
        else go();
    }

    private static void go() {
        long low = 0, high = X;
        long mid = 0, result;

        while(low < high) {
            mid = (low + high) / 2;

            // 놓친 부분 => 전체 게임 수(Y)도 늘어남 !
            result = ((Y + mid) * 100 / (X + mid));

            if(result <= Z) low = mid + 1;
            else high = mid;
        }

        System.out.println(high);
    }

}
