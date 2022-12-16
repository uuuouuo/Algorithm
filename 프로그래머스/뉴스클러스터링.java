package 프로그래머스;

import java.util.*;

class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        // System.out.println(str1);
        List<String> list1 = split(str1);
        List<String> list2 = split(str2);

        // for(int i = 0; i < list1.size(); i++)
        // System.out.println(list1.get(i));

        // 중복검사를 위해 정렬
        Collections.sort(list1);
        Collections.sort(list2);

        int in = 0; // 교집합 원소 개수
        int un = 0; // 합집합 원소 개수

        // 교집합 원소 개수
        int n = list1.size();
        for (int i = 0; i < n; i++) {
            if (list2.remove(list1.get(i)))
                in++;
            un++;
        }

        // 나머지 합집합 원소 개수 추가
        int m = list2.size();
        for (int i = 0; i < m; i++)
            un++;
        if (un == 0)
            return 65536;
        else
            return (int) ((double) in / (double) un * 65536);

    }

    static List<String> split(String str) {
        List<String> list = new ArrayList<>();
        int n = str.length();
        for (int i = 0; i < n - 1; i++) {
            char a = str.charAt(i);
            char b = str.charAt(i + 1);

            if (Character.isLetter(a) && Character.isLetter(b))
                list.add(a + "" + b);
        }
        return list;
    }
}