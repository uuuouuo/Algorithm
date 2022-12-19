package 코딜리티;

class BinaryGap {
    public int solution(int N) {
        String s = Integer.toString(N, 2);
        int answer = 0;
        int pre = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (pre == -1) {
                    pre = i;
                    continue;
                }
                int gap = i - pre - 1;
                if (answer < gap)
                    answer = gap;
                pre = i;
            }
        }
        return answer;
    }
}
