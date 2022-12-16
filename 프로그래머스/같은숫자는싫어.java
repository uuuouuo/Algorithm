import java.util.*;

public class 같은숫자는싫어 {
    public List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 비어있거나(맨처음일 경우), 앞 숫자와 다르면 넣기
            if (st.isEmpty() || st.peek() != arr[i]) {
                st.push(arr[i]);
                answer.add(arr[i]);
            }
        }

        return answer;
    }
}