package 프로그래머스;

import java.util.*;

class 숫자문자열과영단어 {

    static class Info {
        String str;
        int n;

        public Info(String str, int n) {
            this.str = str;
            this.n = n;
        }
    }

    public int solution(String s) {

        List<Info> numList = new ArrayList<>();
        String[] strNums = { "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine" };

        for (int i = 0; i < strNums.length; i++) {
            numList.add(new Info(strNums[i], i));
        }

        for (int i = 0; i < numList.size(); i++) {
            Info cur = numList.get(i);
            s = s.replace(cur.str, String.valueOf(cur.n));
            // System.out.println(s);
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}
