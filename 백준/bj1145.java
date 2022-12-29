package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1145 { // 적어도 대부분의 배수
    // 3개의 조합에서 최소공배수 구하기
    // 최소공배수 = 두 자연수의 곱 / 최대공약수

    static int A[], R[], answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = new int[5];
        R = new int[3];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        go(0, 0);
        System.out.println(answer);
    }

    private static void go(int idx, int start) {
        if(idx == 3) {
            int result = lcm(R[0], R[1]);
            result = lcm(result, R[2]);
            if(answer > result) answer = result;
            return;
        }

        for (int i = start; i < 5; i++) {
            R[idx] = A[i];
            go(idx+1, i+1);
        }
    }

    private static int gcd(int a, int b) {
        int big, small;
        if(a < b) {
            big = b;
            small = a;
        } else {
            big = a;
            small = b;
        }

        int tmp;
        while(small != 0) {
            tmp = big%small;
            big = small;
            small = tmp;
        }
        return big;
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

}
