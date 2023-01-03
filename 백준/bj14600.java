package 백준;

import java.io.*;
import java.util.*;

/** 분할정복 : L-트로미노 타일링 */

public class bj14600 { // 샤워실 바닥 깔기

    // K: 한 변의 길이 -> 이때 바닥의 크기 2^K (1<=K<=2)
    // R, C: 배수구 위치
    // map : 타일 배치하려는 샤워실
    // num : 타일 넘버링
    static int K, R, C, map[][], num = 0;

    public static void main(String[] args) throws IOException {
        input();
        go(0, 0, 2*K); // (0, 0)에서 시작
        print();
    }

    /**
     * 아무것도 없는 공간일 경우만 위치에 따라 하나의 타일을 설치
     * => 가운데 L자 타일이 설치됨

     * r, c : 샤워실의 시작 지점 (맨위 왼쪽)
     * size : 현재 타일을 배치하려는 샤워실(map) 크기
    */
    private static void go(int r, int c, int size) {
        num++;

        int half = size/2;

        // 왼쪽 위 구간 -> 오른쪽 아래 타일 설치
        if(isOk(r, c, half)) map[r+half-1][c+half-1] = num;
        // 오른쪽 위 구간 -> 왼쪽 아래 타일 설치
        if(isOk(r, c+half, half)) map[r+half-1][c+half] = num;
        // 왼쪽 아래 구간 -> 오른쪽 위 타일 설치
        if(isOk(r+half, c, half)) map[r+half][c+half-1] = num;
        // 오른쪽 아래 구간 -> 왼쪽 위 타일 설치
        if(isOk(r+half, c+half, half)) map[r+half][c+half] = num;

        if(size == 2) return; // 현재 사이즈가 2일 경우 다음 1이 되므로 분할 불가

        // 현재 사이즈에서 4등분
        go(r, c, half);
        go(r, c+half, half);
        go(r+half, c, half);
        go(r+half, c+half, half);

    }

    /**
     * r ~ r+size, c ~ c+size 범위 비었는지 확인
     *
     * r, c : 샤워실의 시작 지점 (맨위 왼쪽)
     * size : 현재 타일을 배치하려는 샤워실(map) 크기
     */
    private static boolean isOk(int r, int c, int size) {

        for (int i = r; i < r+size; i++) {
            for (int j = c; j < c+size; j++) {
                // 빈공간이 아니라면
                if(map[i][j] != 0) return false;
            }
        }

        return true;

    }

    private static void print() {
        for (int i = 2*K-1; i >=0; i--) {
            for (int j = 0; j < 2*K; j++) {
                System.out.print(map[j][i]+" "); // 방향 반대 => 이것때매 시간걸림
            }
            System.out.println();
        }
    }

    private static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        map = new int[2*K][2*K];

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;

        map[R][C] = -1;

    }
}
