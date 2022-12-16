package 프로그래머스;

import java.util.*;

class 튜플 {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        s = s.replace("},{", " ");

        String[] arr = s.split(" ");
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] cnt = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            String[] tmp = arr[i].split(",");
            for (int j = 0; j < tmp.length; j++) {
                int cur = Integer.parseInt(tmp[j]);
                // System.out.println(cur);
                if (!map.containsKey(cur))
                    map.put(cur, idx++);
                cnt[map.get(cur)]++;
            }
        }

        int[] answer = new int[n];
        map.forEach((k, v) -> {
            answer[n - cnt[v]] = k;
        });

        return answer;
    }
}
