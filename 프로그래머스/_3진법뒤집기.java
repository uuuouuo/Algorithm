package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

class _3진법뒤집기 {
    public int solution(int n) {

        // 45 / 3 - 0
        // 15 / 3 - 0
        // 5 / 3 - 2
        // 1 
        // 3보다 작을 때 까지 나머지 구하기

        List<Integer> remainder = new ArrayList<>();
        while(n >= 3) { // 3보다 작아지면 그만
            remainder.add(n % 3); // 나머지 저장
            n = n / 3;
        }
        remainder.add(n);

        int answer = 0;
        for(int i = 0; i < remainder.size(); i++) {
            answer += remainder.get(i) * Math.pow(3, (remainder.size() - i - 1)) ;
        }

        return answer;
    }
}

