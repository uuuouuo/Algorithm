import java.util.*;

class Solution {
    static int answer;

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        answer = 0;
        int n = A.length;
        int idx = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (A[i] >= B[idx])
                continue;
            answer++;
            idx--;
        }
        // go(A, B, n, 0, new int[n], new boolean[n]);
        return answer;
    }

    // static void go(int[] a, int[] b, int n, int idx, int[] res, boolean[]
    // visited) {
    // if(n == idx) {
    // // for(int i = 0; i < n; i++)
    // // System.out.print(res[i]);
    // // System.out.println();
    // int wins = getWin(n, a, res);
    // if(answer < wins) answer = wins;
    // return;
    // }

    // for(int i = 0; i < n; i++) {
    // if(!visited[i]) {
    // visited[i] = true;
    // res[idx] = b[i];
    // go(a, b, n, idx+1, res, visited);
    // visited[i] = false;
    // }
    // }
    // }

    // static int getWin(int n, int[] a, int[] b) {
    // int wins = n;
    // for(int i = 0; i < n; i++) {
    // if(a[i] >= b[i]) wins--;
    // if(wins < answer) return -1;
    // }
    // return wins;
    // }
}