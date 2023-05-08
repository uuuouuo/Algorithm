package 프로그래머스;

public class 연속된부분수열의합 {

    // 1. 합이 k인 가장 짧은 부분수열
    // 2. 여러개일 때 인덱스가 작은 것
    // 비내림차순 = 오름차순

    // 투포인터
    static int[] answer;
    public int[] solution(int[] sequence, int k) {
        answer = new int[2];

        go(sequence, sequence.length, k);
        return answer;
    }

    static void go(int[] S, int N, int K) {
        int low = 0, high = 0, length = N, sum = S[0];

        while(low < N && high < N) {
            if(sum < K) {
                high++;
                if(high < N) sum += S[high];
            }
            else if(sum > K) {
                if(high < N) sum -= S[low];
                low++;
            }
            else {
                int n_length = high - low + 1;

                if(length == n_length && low == 0) {
                    answer[0] = low;
                    answer[1] = high;
                }
                if(length > n_length) {
                    answer[0] = low;
                    answer[1] = high;
                    length = high - low + 1;
                }
                if(high < N) sum -= S[low];
                low++;
            }
        }
    }
}
