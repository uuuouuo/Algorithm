package 백준;

import java.io.*;
import java.util.List;
import java.util.*;

public class bj20164 { // 홀수 홀릭 호석

    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        list = new ArrayList<>();

        solution(N, 0);
        Collections.sort(list); //
        System.out.println(list.get(0)+" "+list.get(list.size()-1));
    }

    // 특정 수(N)가 있으면, 한 자리씩 끊어 홀수의 개수를 세어 더하고
    // 특정 수(N)를 임의의 위치에서 끊어 그 수들을 더해서 한 자리수가 될 때까지 반복하는 함수
    private static void solution(String N, int sum) { // N: 현재 수, sum: 홀수 개수
        int size = N.length(); // size: 현재 수(N)의 길이
        int newN = 0; // newN: 새롭게 생성된 N
        // 1. 한 자리 수일 경우
        if(size == 1) {
            if(Integer.parseInt(N) % 2 != 0) sum++;
            list.add(sum);
            return;
        }
        // 2. 두 자리 수일 경우
        else if(size == 2) {
            newN = Integer.parseInt(N.substring(0,1))
                + Integer.parseInt(N.substring(1));
            // 두 자리 수를 하나씩 끊어 더한 수, 기존 홀수 개수(sum)+현재 수(N)의 홀수 개수(cnt) 재귀
            solution(String.valueOf(newN), sum + countOdd(N));
        }
        // 3. 세 자리 수 이상일 경우
        else {
            // 3개의 수로 분할할 때
            // 맨앞 수의 범위: 맨뒤 최소 두개의 숫자를 남겨야 함 -> ex) 123|4|5
            // => 0 ~ 맨뒤 두자리 앞(N.length()-2)
            for(int i=0; i<size-2; i++) {
                // 두 번째 수의 범위: 맨앞 숫자 1자리, 맨뒤 숫자 1자리를 남겨야 함 -> ex) 1|234|5
                // => i 뒷자리(i+1) ~ 맨뒤 앞(N.length()-1)
                for(int j=i+1; j<size-1; j++) {
                    newN = Integer.parseInt(N.substring(0, i+1))
                            + Integer.parseInt(N.substring(i+1, j+1))
                            + Integer.parseInt(N.substring(j+1));

                    solution(String.valueOf(newN), sum + countOdd(N));
                }
            }
        }
    }

    // 특정 수를 한 자리씩 끊어 홀수의 개수를 return 하는 함수수
    private static int countOdd(String N) {
        int result = 0;
        for(int i=0; i<N.length(); i++) {
            if(N.charAt(i) % 2 != 0) result++;
        }
        return result;
    }

}

/**
    시간 복잡도: O(N^2)
        -> N: 10^9-1까지로 9자리 수가 max
    어려웠던 부분
        1. 세자리 수로 끊을 때
            -> substring 범위에서 헷갈림
            -> j의 범위에서 틀림
        2. 두 자리 수 끊을 때 -> 다시 두자리가 될 수도 있다는 것 생각 못 함
 */