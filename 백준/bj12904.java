package 백준;

import java.io.*;

// 그리디 문제
// 역으로 생각하여 T에서 S로 만들어가는 문제!
public class bj12904 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringBuffer 사용하면 쉽게 뒤집을 수 있음
        String S = br.readLine();
        String T = br.readLine();

        go(S, T);
    }

    private static void go(String S, String T) {

        while(S.length() < T.length()) {
            StringBuffer sb = new StringBuffer();
            // 마지막 글자가 A라면 삭제
            if(T.endsWith("A")) {
                T = T.substring(0, T.length() - 1);
            }
            else if(T.endsWith("B")) {
                T = T.substring(0, T.length() - 1);
                T = sb.append(T).reverse().toString();
            }
        }

        if(T.equals(S)) System.out.println(1);
        else System.out.println(0);

    }

}
