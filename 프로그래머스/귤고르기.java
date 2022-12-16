package 프로그래머스;

import java.util.*;

class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        // 완탐 절대 안돼
        // 조금만 생각하면 간단히 풀 수 있는 문제...쒯
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>(); // 정렬할 때 오래 걸리지 않으면서, 수정 시에도 빠름
        // List<Integer> list = new ArrayList<>(); => 개수 수정할 때 오래 걸림
        // Integer[] arr = new Integer[10000000]; => arr[n]++ 가 안돼
        // int[] arr = new int[10000000]; => 정렬할 때 오래 걸림
        for (int n : tangerine) {
            if (!map.containsKey(n))
                map.put(n, 1);
            else
                map.put(n, map.get(n) + 1);
            // arr[n]++;
        }
        // Integer[] arrCopy = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        // Arrays.sort(arrCopy, Collections.reverseOrder());

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());

        // for(int n:arrCopy) {
        // if(n == 0) break;

        // if(k <= 0) break;
        // k = k-n;
        // answer++;
        // }

        for (int n : list) {
            if (k <= 0)
                break;
            k -= n;
            answer++;
        }
        return answer;
    }
}