package 프로그래머스;

import java.util.*;
import java.util.Map.Entry;

class 후보키 {
    static int N, M, answer;
    static String[][] input;
    static List<String> list;
    static boolean[] visited;
    static HashMap<String, Integer> result;

    public int solution(String[][] relation) {
        answer = 0;
        N = relation[0].length;
        M = relation.length;
        input = relation;
        visited = new boolean[N];
        list = new ArrayList<>();
        result = new HashMap<>();
        // 1. 후보키 부분집합
        getList(0, N);
        // 부분집합 개수 오름차순 정렬 ex) 0, 1, 2, 01, 02, 012
        // 최소성 확인을 위해서
        Collections.sort(list, (l1, l2) -> l1.length() - l2.length());

        // 2. 후보키 가능한 속성 확인
        // 2-1. 유일성 확인
        // 2-2. 최소성 확인
        for (String l : list) {
            if (isUnique(l) && isMinimal(l))
                answer++;
        }

        return answer;
    }

    static void getList(int idx, int N) {
        if (idx == N) {
            String tmp = "";
            for (int i = 0; i < N; i++) {
                if (visited[i])
                    tmp += i + " ";
            }
            if (!tmp.equals(""))
                list.add(tmp);
            return;
        }

        visited[idx] = true;
        getList(idx + 1, N);
        visited[idx] = false;
        getList(idx + 1, N);
    }

    static boolean isUnique(String attribute) {
        int idx = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            String tmp = "";
            String[] attr = attribute.split(" ");
            for (String a : attr)
                tmp += input[i][Integer.parseInt(a)];

            if (map.containsKey(tmp))
                return false;
            map.put(tmp, idx++);
        }
        return true;
    }

    static int index = 0;

    static boolean isMinimal(String attribute) {
        List<String> attr = Arrays.asList(attribute.split(" "));
        for (Entry<String, Integer> e : result.entrySet()) {
            String key = e.getKey();
            List<String> k = Arrays.asList(key.split(" "));

            if (attr.containsAll(k))
                return false;
        }
        result.put(attribute, index++);
        return true;
    }
}