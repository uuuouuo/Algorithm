class Solution {
    public int solution(String s) {
        int size = s.length();
        int answer = size;
        int min = size;

        // substring(n, m) 이용
        // ex) j = 2 -> 0, 2 | 2, 4 | 4, 6
        for (int i = 1; i <= size / 2; i++) { // 압축할 문자열 길이 i (size/2까지 확인)
            String res = ""; // 압축 결과
            String val = ""; // 압축할 문자열
            int cnt = 1; // 압축 수

            for (int j = 0; j < size / i; j++) { // 문자 전체 길이/압축할 문자열 길이(i) 만큼 반복
                String cur = s.substring(i * j, i * j + i);

                if (val.equals(cur)) { // 압축 문자와 같다면 cnt++
                    cnt++;
                    continue;
                }

                if (cnt == 1)
                    res += val;
                else {
                    res += cnt + val;
                    cnt = 1;
                }
                val = cur;
            }
            // 마지막 문자열 처리
            if (cnt == 1)
                res += val;
            else
                res += cnt + val;

            // 전체 문자열 길이에 나눠떨어지지 않는다면
            if (size % i != 0)
                res += s.substring((size / i) * i); // 남은 문자열 추가

            // 더 짧은 길이 있으면 갱신
            if (min > res.length()) {
                min = res.length();
                answer = min;
            }
        }
        return answer;
    }
}