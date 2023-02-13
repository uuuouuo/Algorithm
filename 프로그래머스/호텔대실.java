package 프로그래머스;

// 누적합 문제
// 설명 : https://ksb-dev.tistory.com/269

public class 호텔대실 {

    static int MAX_TIME, CLEAN_TIME, times[];
    public int solution(String[][] book_time) {
        int answer = 1;
        MAX_TIME = (24 * 60) + 59;
        CLEAN_TIME = 10;
        times = new int[MAX_TIME];

        init(book_time);

        for(int i=1; i<MAX_TIME; i++) {
            times[i] += times[i-1];
            answer = Math.max(answer, times[i]);
        }

        return answer;
    }

    static void init(String[][] book_time) {
        for(String[] bt : book_time) {
            times[calcTime(bt[0])] += 1;
            times[calcTime(bt[1]) + CLEAN_TIME] -= 1;
        }
    }

    static int calcTime(String time) {
        int result = 0;

        String[] T = time.split(":");
        result += Integer.parseInt(T[0]) * 60;
        result += Integer.parseInt(T[1]);

        return result;
    }

}
