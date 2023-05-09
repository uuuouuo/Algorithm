package 프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 추억점수 {
    static Map<String, Integer> map;
    static List<Integer> answer;

    public List<Integer> solution(String[] name, int[] yearning, String[][] photo) {
        answer = new ArrayList<>();
        map = new HashMap<>();

        setting(name, yearning);
        process(photo);
        return answer;
    }

    static void setting(String[] N, int[] Y) {
        for(int i=0; i<N.length; i++) {
            map.put(N[i], Y[i]);
        }
    }

    static void process(String[][] P) {
        for(String[] photo : P) {
            int sum = 0;
            for(String name : photo) {
                if(!map.containsKey(name)) continue; // 그리움 점수가 없는 사람이 있을 수 있음 주의!
                sum += map.get(name);
            }
            answer.add(sum);
        }
    }
}
