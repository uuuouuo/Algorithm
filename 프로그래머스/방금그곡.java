package 프로그래머스;

import java.util.*;

class 방금그곡 {
    static class Info {
        int time;
        String title, melody;

        public Info(int time, String title, String melody) {
            this.time = time;
            this.title = title;
            this.melody = melody;
        }
    }

    static List<Info> list;

    public String solution(String m, String[] musicinfos) {

        m = changeMelody(m);

        list = new ArrayList<>();
        init(musicinfos);

        List<Info> candidate = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Info info = list.get(i);
            if (info.melody.contains(m))
                candidate.add(info);
        }

        if (candidate.size() == 1)
            return candidate.get(0).title;
        else if (candidate.size() == 0)
            return "(None)";
        else
            return getAns(candidate, m);
    }

    static void init(String[] musicinfos) {
        for (String music : musicinfos) {
            String[] str = music.split(",");
            int time = getTime(str[0], str[1]); // 재생 시간 계산
            String melody = changeMelody(str[3]); // 악보 변경
            list.add(new Info(time, str[2], getMelody(time, melody))); // 재생 시간에 맞춰 악보 바꾸기
        }
    }

    static String changeMelody(String melody) {
        melody = melody.replace("C#", "H");
        melody = melody.replace("D#", "I");
        melody = melody.replace("E#", "J");
        melody = melody.replace("F#", "K");
        melody = melody.replace("G#", "L");
        melody = melody.replace("A#", "N");

        return melody;
    }

    static int getTime(String start, String end) {
        String[] s = start.split(":");
        String[] e = end.split(":");
        int min = Integer.parseInt(e[1]) - Integer.parseInt(s[1]);
        int hour = Integer.parseInt(e[0]) - Integer.parseInt(s[0]);

        if (min < 0) {
            min = 60 + min;
            hour = hour - 1;
        }
        return hour * 60 + min;
    }

    static String getMelody(int n, String melody) {
        int gap = n;
        String result = "";
        int size = melody.length();

        if (n > size) {
            gap = n - size;
            result = melody;
            while (size <= gap) { // 재생 시간 > 악보 길이
                result += melody;
                gap -= size;
            }
        }
        result += melody.substring(0, gap);
        System.out.println(result);
        return result;
    }

    static String getAns(List<Info> candidate, String m) {
        String res = "";
        int max = 0;
        for (int i = 0; i < candidate.size(); i++) {
            Info info = candidate.get(i);
            if (info.time > max) {
                res = info.title;
                max = info.time;
            }
        }
        return res;
    }

}