package 프로그래머스;

import java.util.*;
import java.util.Map.Entry;

class Solution {
    // LRU: 가장 오래된 페이지 교체
    // Hit: 순서 교체
    // Miss: 캐시 갱신

    static int answer, N;

    public int solution(int cacheSize, String[] cities) {
        answer = 0;
        N = cacheSize;

        if (cacheSize == 0)
            return 5 * cities.length;

        cities = changeName(cities); // 도시 이름 모두 소문자 교체
        go(cities);

        return answer;
    }

    static String[] changeName(String[] cities) {
        for (int i = 0; i < cities.length; i++)
            cities[i] = cities[i].toLowerCase();
        return cities;
    }

    static HashMap<String, Integer> cache;

    static void go(String[] cities) {
        cache = new HashMap<>();

        for (int i = 0; i < cities.length; i++) {
            String curCity = cities[i];

            if (cache.containsKey(curCity)) // 해당 city 있으면 hit
                hit(curCity, i);
            else
                miss(curCity, i); // 해당 city 없으면 miss

        }
    }

    static void hit(String city, int i) {
        removeCache(city, i);
        answer++;
    }

    static void miss(String city, int i) {
        if (cache.size() < N)
            cache.put(city, i);
        else {
            cache.remove(getMinIdxCity());
            cache.put(city, i);
        }
        answer += 5;
    }

    static void removeCache(String city, int i) {
        cache.remove(city);
        cache.put(city, i);
    }

    static String getMinIdxCity() {
        int minIdx = 100000;
        String city = "";
        for (Entry<String, Integer> e : cache.entrySet()) {
            if (minIdx > e.getValue()) {
                minIdx = e.getValue();
                city = e.getKey();
            }
        }
        return city;
    }

}