package 프로그래머스;

class 없는숫자더하기 {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] check = new boolean[10];
        for(int n : numbers) {
            check[n] = true;
        }

        for(int i = 0; i < 10; i++) {
            if(!check[i]) {
                answer += i;
            }
        }
        return answer;
    }
}