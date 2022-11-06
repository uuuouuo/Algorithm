package 백준;

import java.io.*;
import java.util.*;

public class bj11053 { 

    // 이분탐색을 이용한 방법 O(NlogN)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] lis = new int[N]; // 최장증가수열이 담긴 집합
        lis[0] = arr[0]; // 제일 첫번째 증가수열 후보는 맨처음 arr 배열원소

        int i = 0; // lis 배열 인덱스
        int j = 1; // arr 배열 인덱스
        while(j < N) { // arr 인덱스 범위 안
            if(lis[i] < arr[j]) {
                lis[++i] = arr[j]; // 다음 lis 원소후보
            } else { // 만약 다음 원소가 더 작다면 이분탐색을 통해 자리 찾기
                int idx = biSearch(0, i, arr[j], lis);
                lis[idx] = arr[j];
            }
            j++;
        }

        int answer = 0;
        for (int k = 0; k < N; k++) {
            System.out.println(lis[k]);
            if(lis[k] != 0) answer++;
        }
        System.out.println(answer);
    }

    static int biSearch(int low, int high, int target, int[] lis) { // 지금까지 생성된 lis의 범위안에서
        int mid;
        while(low < high) {
            mid = (low+high) / 2;
            if(lis[mid] < target) low = mid+1; // 새로운수(target)이 더 크면 범위 위로
            else high = mid; // 새로운수(target)이 작거나 같으면 같은수를 포함한 범위 아래로
        }
        return high;
    }
}
