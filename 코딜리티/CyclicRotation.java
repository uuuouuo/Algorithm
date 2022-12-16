package 코딜리티;

class CyclicRotation {
    public int[] solution(int[] A, int K) {
        for (int i = 0; i < K; i++) {
            swap(A);
        }

        return A;
    }

    static void swap(int[] A) {
        int tmp = A[A.length - 1];
        for (int i = A.length - 1; i >= 0; i--) {
            if (i == 0)
                A[i] = tmp;
            else
                A[i] = A[i - 1];
        }

        // for(int i=0; i<A.length; i++)
        // System.out.print(A[i]);
        // System.out.println();
    }
}