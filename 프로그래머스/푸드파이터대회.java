package 프로그래머스;

/// String Builder 이용하면 쉬운 문제 ///
public class 푸드파이터대회 {

    public String solution(int[] food) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 1; i < food.length; i++) {
            cnt = food[i] / 2;
            for(int j = 0; j < cnt; j++) {
                sb.append(i);
            }
        }
        answer += sb.toString() + "0";
        answer += sb.reverse();
        // System.out.println(sb.toString());
        // System.out.println(sb.reverse());

        return answer;
    }

}
