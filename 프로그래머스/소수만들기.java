package 프로그래머스;

import java.util.*;
class Solution {
    
    static int res[], answer;
    public int solution(int[] nums) {
        answer = 0;  
        res = new int[3];
        go(nums, 0, 0);

        return answer;
    }
    
    static void go(int[] nums, int idx, int start) { // 조합
        if(idx == 3) {
            if(check())
                answer++;
            return;
        }
        
        for(int i = start; i < nums.length; i++) {
            res[idx] = nums[i];
            go(nums, idx + 1, i + 1);
        }
    }
    
    static boolean check() {
        int sum = 0;
        for(int r : res)
            sum += r;

        if(sum < 2) return false;
        if(sum == 2) return true;
        
        for(int i = 2; i <= Math.sqrt(sum); i++) 
            if(sum % i == 0) return false;
        
        return true;
    }
}