package 코딜리티;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;

class OddOccurrencesInArray {
    static int answer;

    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            if (!map.containsKey(a))
                map.put(a, 1);
            else
                map.put(a, 2);
        }

        answer = 0;
        map.forEach((k, v) -> {
            if (v == 1)
                answer = k;
        });
        return answer;
    }
}
