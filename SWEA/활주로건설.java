package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 활주로건설 {

    static BufferedReader br;
    static int T, N, X; // T: 테스트케이스 개수, N: 활주로 배열 길이, X: 경사로 가로 길이
    static int[][] arr; // 활주로 배열
    static boolean[] isSet;
    static int answer;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            input();
            go();
        }
    }

    private static void go() {
        for (int i = 0; i < N; i++) {
            if(rCheck(i)) answer++;
            if(cCheck(i)) answer++;

        }

        System.out.println(answer);
    }

    private static boolean cCheck(int col) {
        isSet = new boolean[N];

        int row = 0;
        int pre = arr[row][col]; // 이전 높이
        int len = 0; // 같은 숫자 연속 개수 (= 설치 가능한 길이)

        while(row < N) {
            int cur = arr[row][col];

            // 이전과 높이가 같을 때
            if(pre == cur) len++;
                // 이전과 높이가 다를 때
            else {
                // 높이가 1이상 차이날 때
                if(Math.abs(cur - pre) > 1) return false;
                // 이전보다 높을 때 : len 으로 설치되는지 확인가능
                if(pre < cur) {
                    // 이미 설치되있거나
                    // 설치 가능한 길이보다 경사로 길이가 더 길면 false
                    if(isSet[row-1] || len < X) return false;
                        // 설치 가능하면
                    else {
                        for (int i = 1; i <= X; i++)
                            isSet[row-i] = true;
                    }
                    len = 1;
                    pre = cur;
                }
                // 이전보다 낮을 때 : 그 다음 len 을 통해 설치되는지 확인가능
                else {
                    pre = cur;

                    // 이후의 len 이 설치 가능한지 확인
                    for (int i = 0; i < X-1; i++) {
                        // 배열 끝이 넘어가면 false
                        if(row+1 >= N) return false;
                        row++;
                        // 높이 같지 않으면 설치 불가 false
                        if(arr[row][col] != pre) return false;
                    }

                    // 설치하기
                    for (int i = 1; i <= X; i++)
                        isSet[row-i] = true;
                    len = 0;
                }
            }
            row++;
        }
        return true;
    }

    private static boolean rCheck(int row) {
        isSet = new boolean[N];

        int col = 0;
        int pre = arr[row][col]; // 이전 높이
        int len = 0; // 같은 숫자 연속 개수 (= 설치 가능한 길이)

        while(col < N) {
            int cur = arr[row][col];

            // 이전과 높이가 같을 때
            if(pre == cur) len++;
            // 이전과 높이가 다를 때
            else {
                // 높이가 1이상 차이날 때
                if(Math.abs(cur - pre) > 1) return false;
                // 이전보다 높을 때 : len 으로 설치되는지 확인가능
                if(pre < cur) {
                    // 이미 설치되있거나
                    // 설치 가능한 길이보다 경사로 길이가 더 길면 false
                    if(isSet[col-1] || len < X) return false;
                    // 설치 가능하면
                    else {
                        for (int i = 1; i <= X; i++)
                            isSet[col-i] = true;
                    }
                    len = 1;
                    pre = cur;
                }
                // 이전보다 낮을 때 : 그 다음 len 을 통해 설치되는지 확인가능
                else {
                    pre = cur;

                    // 이후의 len 이 설치 가능한지 확인
                    for (int i = 0; i < X-1; i++) {
                        // 배열 끝이 넘어가면 false
                        if(col+1 >= N) return false;
                        col++;
                        // 높이 같지 않으면 설치 불가 false
                        if(arr[row][col] != pre) return false;
                    }

                    // 설치하기
                    for (int i = 1; i <= X; i++)
                        isSet[col-i] = true;
                    len = 1;
                }
            }
            col++;
        }
        return true;
    }

    private static void input() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;

    }
}
