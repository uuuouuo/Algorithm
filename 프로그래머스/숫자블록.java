class Solution {
    public int[] solution(long begin, long end) {
        // 에라토네스의 체 응용
        int n = (int) (end - begin + 1);
        int[] answer = new int[n];
        int idx = 0;
        for (long i = begin; i <= end; i++) {
            if (i == 1)
                answer[idx++] = 0; // n*2위치라서 2이상부터 설치가능
            else
                answer[idx++] = setBlock(i);
        }

        return answer;
    }

    static int setBlock(long num) {
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (num / i > 10000000)
                    continue; // 범위 초과하면 패스
                return (int) (num / i); // 나눠지는 가장 작은 약수 설치
            }
        }
        return 1; // 소수라면 1 설치
    }
}