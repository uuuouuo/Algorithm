package 프로그래머스;

import java.util.*;
import java.util.Map.Entry;

class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            String p = participant[i];
            if (!map.containsKey(p))
                map.put(p, 1);
            else
                map.replace(p, map.get(p) + 1);
        }

        String answer = "";
        for (int i = 0; i < completion.length; i++) {
            map.replace(completion[i], map.get(completion[i]) - 1);
        }

        for (Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() != 0)
                answer = e.getKey();
        }

        return answer;
    }
}