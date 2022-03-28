import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(int N, int[] stages) {
        // N: 전체 스테이지
        // stages: 유저별 진행중인 스테이지

        int[] clearArr = new int[N + 1]; // 스테이지별 클리어한 유저 수
        for (int i = 0; i < stages.length; i++) {
            int stage = stages[i];
            for (int j = 0; j < stage; j++) {
                clearArr[j]++;
            }
        }

        // 1 |2 |3 |4 |5
        // 0, 1
        // 0
        // 0, 1
        // 0, 1, 2, 3, 4, 5
        // 0, 1
        // 0, 1, 2, 3
        // 0, 1, 2
        // 0, 1, 2
        // clearArr[i - 1] - clearArr[i] / clearArr[ i - 1 ]

        // for(int i = 0; i < clearArr.length; i++) {
        // System.out.println(clearArr[i]);
        // }

        HashMap<Integer, Double> map = new HashMap<>();
        // int[] failArr = new int[N + 1];
        for (int i = 1; i < clearArr.length; i++) {
            double fail = (double) (clearArr[i - 1] - clearArr[i]) / clearArr[i - 1];
            // System.out.println(fail);
            map.put(i, fail);
        }

        // for(int i = 1; i < map.size() + 1; i++) {
        // System.out.println(map.get(i));
        // }

        // List<Integer> list = new ArrayList<>(map.keySet());
        // // 오름 차순
        // Collections.sort(list, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        // // 내림 차순
        // Collections.sort(list, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));

        // for(Integer key : list) {
        // System.out.println("key : " + key + " / " + "value : " + map.get(key));
        // }

        List<Map.Entry<Integer, Double>> list = new LinkedList<>(map.entrySet());

        // // 오름차순 정렬
        // list.sort(Map.Entry.comparingByValue());

        // value기준 내림차순, 인덱스 기준 오름차순 정렬
        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {

            @Override
            public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {

                if (o2.getValue() - o1.getValue() > 0) {
                    return 1;
                }

                if (o2.getValue() - o1.getValue() < 0) {
                    return -1;
                }

                return o1.getKey() - o2.getKey();
            }
        });

        int[] answer = new int[N];

        int i = 0;
        for (Map.Entry<Integer, Double> l : list) {
            // System.out.println("key : " + l.getKey() + ", value : " + l.getValue());
            answer[i] = l.getKey();
            i++;
        }

        return answer;
    }
}