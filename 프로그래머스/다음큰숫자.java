package 프로그래머스;

class 다음큰숫자 {
    public int solution(int n) {

        int cnt = Integer.bitCount(n);

        while(true) {
            n++;
            if(Integer.bitCount(n) == cnt) break;
        }

        return n;
    }

}