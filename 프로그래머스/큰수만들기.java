package 프로그래머스;

class 큰수만들기 {
    // 투포인터
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int max;
        // 0 -> 4 1 -> 5
        for(int i=0; i<number.length()-k; i++) { // 만들 문자 길이
            max = 0;
            for(int j=start; j<=k+i; j++) { // 찾은 최댓값의 다음 값~
                int cur = number.charAt(j)-'0';
                if(max < cur) {
                    max = cur;
                    start = j+1; // 해당 최a대숫자의 다음부터 시작
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}