import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.split(" ");
        int n = sArr.length;

        int[] nArr = new int[n];
        change(sArr, nArr, n);
        // for(int i = 0; i < n; i++)
        // System.out.println(nArr[i]);
        Arrays.sort(nArr);
        answer = String.valueOf(nArr[0]) + " " + String.valueOf(nArr[n - 1]);
        return answer;
    }

    static void change(String[] sArr, int[] nArr, int n) {
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(sArr[i]);
        }
    }
}