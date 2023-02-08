package 프로그래머스;

public class 크기가작은부분문자열 {

    public int solution(String t, String p) {
        int answer = 0;
        long P = Long.parseLong(p);

        for(int i = 0; i < t.length()-p.length()+1; i++) {
            long val = Long.parseLong(t.substring(i, i + p.length()));
            // System.out.println(val);

            if(val <= P) answer++;
        }

        return answer;
    }

}
