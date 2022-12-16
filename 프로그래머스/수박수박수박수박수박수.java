package 프로그래머스;

class 수박수박수박수박수박수 {
    public String solution(int n) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                answer += "수";
            else
                answer += "박";

        }

        return answer;
    }
}