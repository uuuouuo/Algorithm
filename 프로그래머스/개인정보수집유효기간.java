package 프로그래머스;

import java.util.*;

public class 개인정보수집유효기간 { // 다른 코드로 작성하기!

    // 유효기간 지난 개인정보 파기
    // 모든 달은 28일까지

    static int curY, curM, curD, cnt;
    static List<Integer> answer;
    static Map<String, Integer> termMap;
    public List<Integer> solution(String today, String[] terms, String[] privacies) {

        answer = new ArrayList<>();
        termMap = new HashMap<>();
        cnt = 0;

        // 오늘 날짜 int 형으로 변형
        String[] t = today.split("\\.");

        curY = Integer.parseInt(t[0]);
        curM = Integer.parseInt(t[1]);
        curD = Integer.parseInt(t[2]);

        // 편하게 조회하기 위해 해시맵에 담기
        for(String term : terms) {
            String[] tm = term.split(" ");
            termMap.put(tm[0], Integer.parseInt(tm[1])); // 약관 종류, 계약 기간
        }

        for(String priv : privacies) {
            cnt++;
            String[] p = priv.split(" ");
            go(p[0], termMap.get(p[1]));
        }

        return answer;
    }


    /** 개인정보 유효기간 마지막 날짜 구하는 함수

     pDay: 계약한 날짜
     term: 계약 기간
     */
    static void go(String pDay, int term) {
        String[] p = pDay.split("\\.");

        int pY = Integer.parseInt(p[0]),
                pM = Integer.parseInt(p[1]),
                pD = Integer.parseInt(p[2]);

        // day => 1 감소
        // 1이면 28로
        if(pD-1 == 0) {
            pD = 28;

            if(pM-1 == 0) {
                pM = 12;
                pY--;
            } else pM--;
        }
        else pD--;

        // month => 유효기간 만큼 숫자 +
        // 12가 넘으면 더한값에 12빼기 & year +
        pM += term;
        while (pM > 12) {
            pM -= 12;
            pY++;
        }

        // 이미 계약 기간이 지난 날짜라면 answer에 담기
        if(!check(pY, pM, pD)) answer.add(cnt);

    }

    /** 현재 날짜보다 이전 날짜라면 false */
    static boolean check(int y, int m, int d) {
        if(y < curY) return false;
        if(y == curY && m < curM) return false;
        if(y == curY && m == curM && d < curD) return false;

        return true;
    }
}
