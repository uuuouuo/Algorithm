import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for (int i = 0; i < discount.length - 9; i++) {
            int[] tmp = Arrays.copyOf(number, number.length);
            for (int j = i; j < i + 10; j++) {
                for (int k = 0; k < want.length; k++) {
                    if (want[k].equals(discount[j])) {
                        if (tmp[k] != 0)
                            tmp[k]--;
                    }
                }
                if (Arrays.stream(tmp).sum() == 0)
                    answer++;
            }
        }
        return answer;
    }
}