import java.util.*;

class 최솟값만들기 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int n = A.length;
        for (int i = 0; i < n; i++) {
            answer += A[i] * B[n - i - 1];
        }

        return answer;
    }
}