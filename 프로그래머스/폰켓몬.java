package 프로그래머스;

import java.util.*;

class 폰켓몬 {
    public int solution(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int max = nums.length / 2;

        if (max < set.size())
            return max;
        else
            return set.size();

    }
}
