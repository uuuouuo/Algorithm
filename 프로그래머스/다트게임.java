package 프로그래머스;

import java.util.*;

class Solution {
    public int solution(String dartResult) {

        List<String> list = new ArrayList<>();
        String[] str = dartResult.split("");

        for(int i = 0; i < str.length; i++) {            
            String cur = str[i];
            if(cur.equals("S")) {
                double n = getNum(str, i);
                list.add(String.valueOf(Math.pow(n, 1)).replace(".0", ""));
            }
            if(cur.equals("D")) {
                double n = getNum(str, i);
                list.add(String.valueOf(Math.pow(n, 2)).replace(".0", ""));
            }
            if(cur.equals("T")) {
                double n = getNum(str, i);
                list.add(String.valueOf(Math.pow(n, 3)).replace(".0", ""));
            }
            if(cur.equals("*")) list.add("*");
            if(cur.equals("#")) list.add("#");
            // System.out.println(cur);
        }

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            String cur = list.get(i);
            if(cur.equals("*")) {
                if(i == 1) {
                    list.remove(i);
                    list.set(i - 1, list.get(i - 1) + "*");
                }
                else {
                    list.remove(i);
                    list.set(i - 1, list.get(i - 1) + "*");
                    list.set(i - 2, list.get(i - 2) + "*");
                    if(i - 3 < 0 || !isOk(list, i - 2)) continue;
                    list.set(i - 3, list.get(i - 3) + list.get(i - 2));
                    list.remove(i - 2);
                }
            }
            if(cur.equals("#")) {
                list.remove(i);
                list.set(i - 1, list.get(i - 1) + "#");
            }
        }

        int answer = 0;
        for(int i = 0; i < list.size(); i++) {
            String cur = list.get(i);
            if(cur.isEmpty()) continue;
            // System.out.println(list.get(i));

            int tmp = 0;            
            String[] s = cur.split("#|\\*");
            String[] idx = cur.split("");
            tmp = Integer.parseInt(s[0]);
            for(int j = 0; j < idx.length; j++) {
                if(idx[j].contains("*")) tmp *= 2;
                if(idx[j].contains("#")) tmp *= (-1);
                // System.out.println(tmp);
            }
            answer += tmp;
        }
        return answer;
    }

    static double getNum(String[] str, int i) {
        if(i == 1) return Double.parseDouble(str[0]);
        if(str[i - 1].equals("0") && str[i - 2].equals("1")) return 10.0;
        else return Double.parseDouble(str[i - 1]);
    }

    static boolean isOk(List<String> list, int i) {
        String[] str = list.get(i).split("");
        for(int j = 0; j < str.length; j++) {
            if(!str[j].equals("*")) return false;
            if(!str[j].equals("#")) return false;
        }

        return true;

    }

}