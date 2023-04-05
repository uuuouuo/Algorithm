package 프로그래머스;

public class 카드뭉치 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";

        int idx1 = 0, idx2 = 0, idx = 0;

        while(true) {

            if(idx == goal.length) {
                answer = "Yes";
                break;
            }

            if(idx1 != cards1.length
                    && cards1[idx1].equals(goal[idx])) {
                idx1++;
            } else if(idx2 != cards2.length
                    && cards2[idx2].equals(goal[idx])) {
                idx2++;
            } else {
                break;
            }
            idx++;
        }

        return answer;
    }

}
