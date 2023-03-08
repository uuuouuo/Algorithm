package 프로그래머스;

import java.util.Stack;

// 답 봤음 => 다시 풀어보기 !
public class 뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<N; i++) {

            // 이전 수가 나보다 크거나 같으면
            if(st.isEmpty() || numbers[i] < numbers[i-1]) {
                st.push(i);
            }
            else {
                // 비어있지 않으면서,
                // 현재 수보다 작을 때
                while(!st.isEmpty() && numbers[st.peek()] < numbers[i]) {
                    answer[st.pop()] = numbers[i];
                }
                st.push(i);
            }
        }

        while(!st.isEmpty()) {
            answer[st.pop()] = -1;
        }
        return answer;
    }

}
