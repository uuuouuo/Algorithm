package SWEA;

import java.util.*;
import java.io.*;

public class 무선충전 {

    static StringTokenizer st;
    static int T, M, N;
    static int A[], B[], map[][], BC[], idx;
    static int rA = 0, cA = 0, rB = 9, cB = 9;
    static Map<Integer, List<Integer>> O;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); // 총 이동 시간
            N = Integer.parseInt(st.nextToken()); // BC 개수

            A = new int[M+1];
            B = new int[M+1];
            map = new int[10][10];
            BC = new int[N+1];
            O = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] =Integer.parseInt(st.nextToken());
            }

            idx = 0;
            int r, c, range, charge;
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                c = Integer.parseInt(st.nextToken())-1;
                r = Integer.parseInt(st.nextToken())-1;
                range = Integer.parseInt(st.nextToken());
                charge = Integer.parseInt(st.nextToken());

                BC[i] = charge;
                set(r, c, range, i);
            }

//            for (int i = 0; i < 10; i++) {
//                for (int j = 0; j < 10; j++) {
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
            for (int i = 1; i <= M; i++) {
               go(i);
            }
        }
    }

    static int[] dr = {0, -1, 0, 1, 0}, dc = {0, 0, 1, 0, -1};
    private static void go(int m) {
        rA += dr[A[m]];
        cA += dc[A[m]];
        rB += dr[B[m]];
        cB += dc[B[m]];

        int a = map[rA][cA], b = map[rB][cB];

        if(a > 0 && b > 0 && a == b) { // 0이 아닌, 같은 곳에 있을 때

        } else if(a < 0 && b < 0) { // 둘 다 중복 위치에 있을 때

        } else if(a < 0) { // a만 중복 위치에 있을 때

        } else if(b < 0) { // b만 중복 위치에 있을 때

        }  else if(a == 0) {

        } else { // 서로 다르거나, 둘이 0일 때

        }
    }

    private static void set(int row, int col, int range, int num) {
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                int dis = Math.abs(row-r) + Math.abs(col-c);

                if(dis <= range) {
                    if(map[r][c] > 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map[r][c]);
                        list.add(num);

                        O.put(--idx,list);
                        map[r][c] = idx;
                    }
                    else if(map[r][c] < 0) {
                        List<Integer> list = O.get(map[r][c]);
                        list.add(num);

                        O.put(map[r][c], list);
                    }
                    else map[r][c] = num;
                }
            }
        }
    }

}
