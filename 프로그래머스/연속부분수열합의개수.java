import java.util.*;

class 연속부분수열합의개수 {
    public int solution(int[] elements) {
        int[] arr = new int[elements.length * 2]; // 더하기 편하도록 2배로 늘리기
        for (int i = 0; i < elements.length; i++) {
            arr[i] = arr[i + elements.length] = elements[i];
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                set.add(Arrays.stream(arr, j, j + i).sum()); // set을 통해 중복되는 수 제거
            }
        }
        return set.size() + 1;
    }
}