package 백준;

import java.io.*;
//import java.util.*;

public class bj20164 { // 홀수 홀릭 호석
    // 한 자리 수일 경우 종료
    // 두 자리 수일 경우 2개로 나누기
    // 세 자리 수 이상일 경우 3개로 나눌 수 있는 모든 경우의 수
        // 최대 = 10^9-1 ==> 최대 9자리
    // ==> 새로운 수 생길 때마다 홀수 개수 확인
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        System.out.println(countN(N));

    }

    private static int countN(String n) {
        int result = 0;
        for(int i=0; i<n.length(); i++) {
            if(n.charAt(i)%2 != 0) result++;
        }
        return result;
    }

}
